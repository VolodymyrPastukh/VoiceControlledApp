package vovan.androidovych.voicecontrolledapp.ui.content

import org.koin.androidx.viewmodel.ext.android.viewModel
import vovan.androidovych.voicecontrolledapp.R
import vovan.androidovych.voicecontrolledapp.databinding.FragmentHomeScreenBinding
import vovan.androidovych.voicecontrolledapp.ui.base.VoiceManagedFragment
import vovan.androidovych.voicecontrolledapp.utils.viewBinding

class ContentScreenFragment :
    VoiceManagedFragment<ContentScreenViewModel>(R.layout.fragment_content_screen) {
    companion object {
        private const val TAG = "ContentScreenFragment"
    }

    private val binding by viewBinding { FragmentHomeScreenBinding.bind(it) }
    override val viewModel: ContentScreenViewModel by viewModel()
}