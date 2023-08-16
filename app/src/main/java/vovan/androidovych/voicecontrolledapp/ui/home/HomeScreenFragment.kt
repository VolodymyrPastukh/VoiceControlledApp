package vovan.androidovych.voicecontrolledapp.ui.home

import android.Manifest.permission.RECORD_AUDIO
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import org.koin.androidx.viewmodel.ext.android.viewModel
import vovan.androidovych.voicecontrolledapp.R
import vovan.androidovych.voicecontrolledapp.data.entity.VoiceCommandEntity
import vovan.androidovych.voicecontrolledapp.databinding.FragmentHomeScreenBinding
import vovan.androidovych.voicecontrolledapp.ui.base.VoiceManagedFragment
import vovan.androidovych.voicecontrolledapp.utils.checkAndRequestPermissions
import vovan.androidovych.voicecontrolledapp.utils.navigateTo
import vovan.androidovych.voicecontrolledapp.utils.viewBinding

class HomeScreenFragment :
    VoiceManagedFragment<HomeScreenViewModel>(R.layout.fragment_home_screen) {
    companion object {
        private const val TAG = "HomeScreenFragment"
    }

    private val binding by viewBinding { FragmentHomeScreenBinding.bind(it) }
    override val viewModel: HomeScreenViewModel by viewModel()

    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { permission ->
        Log.d(TAG, "RECORD_AUDIO granted=${permission[RECORD_AUDIO]}")
        if (permission[RECORD_AUDIO] == true) viewModel.startRecognition()
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkAndRequestPermissions(
            listOf(RECORD_AUDIO),
            requestPermissionLauncher,
            onGranted = { viewModel.startRecognition() }
        )
    }

    override fun commandProcessing(command: VoiceCommandEntity) {
        when (command) {
            VoiceCommandEntity.SETTINGS ->
                navigateTo(HomeScreenFragmentDirections.actionHomeScreenFragmentToSettingsScreenFragment())

            else -> super.commandProcessing(command)
        }
    }

    override fun navigateNext() {
        navigateTo(HomeScreenFragmentDirections.actionHomeScreenFragmentToContentScreenFragment())
    }
}