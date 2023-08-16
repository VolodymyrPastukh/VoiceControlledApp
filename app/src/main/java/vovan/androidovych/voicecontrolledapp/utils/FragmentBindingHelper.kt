package vovan.androidovych.voicecontrolledapp.utils

import android.view.View
import androidx.annotation.MainThread
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle.Event.ON_DESTROY
import androidx.lifecycle.Lifecycle.State.INITIALIZED
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

fun <T : ViewBinding> viewBinding(bindMethod: (View) -> T) =
    FragmentViewBindingDelegate(bindMethod)

class FragmentViewBindingDelegate<out T : ViewBinding>(
    private val _bindMethod: (View) -> T,
) : ReadOnlyProperty<Fragment, T> {
    private var _binding: T? = null

    @MainThread
    override fun getValue(thisRef: Fragment, property: KProperty<*>): T {
        _binding?.let { return it }

        thisRef.viewLifecycleOwner.lifecycle.currentState.also { state ->
            if (!state.isAtLeast(INITIALIZED)) {
                error("Cannot access view bindings. View lifecycle is ${state}!")
            }
        }

        thisRef.viewLifecycleOwnerLiveData.observe(thisRef, ::onLifecycleUpdate)

        _bindMethod.invoke(thisRef.requireView()).let { binding ->
            _binding = binding
            return binding
        }
    }

    @MainThread
    private fun onLifecycleUpdate(owner: LifecycleOwner) {
        owner.lifecycle.addObserver(LifecycleEventObserver { _, event ->
            if (event == ON_DESTROY) {
                _binding = null
            }
        })
    }
}