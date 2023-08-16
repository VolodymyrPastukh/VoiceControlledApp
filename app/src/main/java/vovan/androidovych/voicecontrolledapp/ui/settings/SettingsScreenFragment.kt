package vovan.androidovych.voicecontrolledapp.ui.settings

import org.koin.androidx.viewmodel.ext.android.viewModel
import vovan.androidovych.voicecontrolledapp.R
import vovan.androidovych.voicecontrolledapp.databinding.FragmentSettingsScreenBinding
import vovan.androidovych.voicecontrolledapp.ui.base.VoiceManagedFragment
import vovan.androidovych.voicecontrolledapp.utils.viewBinding

class SettingsScreenFragment :
    VoiceManagedFragment<SettingsScreenViewModel>(R.layout.fragment_settings_screen) {
    companion object {
        private const val TAG = "SettingsScreenFragment"
    }

    private val binding by viewBinding { FragmentSettingsScreenBinding.bind(it) }
    override val viewModel: SettingsScreenViewModel by viewModel()
}