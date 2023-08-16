package vovan.androidovych.voicecontrolledapp.ui.home

import vovan.androidovych.voicecontrolledapp.data.VoiceRecognitionRepository
import vovan.androidovych.voicecontrolledapp.ui.base.VoiceManagedViewModel

class HomeScreenViewModel(
    voiceRecognitionRepository: VoiceRecognitionRepository
): VoiceManagedViewModel(voiceRecognitionRepository)