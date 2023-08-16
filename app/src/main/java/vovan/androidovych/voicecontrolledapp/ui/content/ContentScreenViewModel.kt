package vovan.androidovych.voicecontrolledapp.ui.content

import vovan.androidovych.voicecontrolledapp.data.VoiceRecognitionRepository
import vovan.androidovych.voicecontrolledapp.ui.base.VoiceManagedViewModel

class ContentScreenViewModel(
    voiceRecognitionRepository: VoiceRecognitionRepository,
): VoiceManagedViewModel(voiceRecognitionRepository)