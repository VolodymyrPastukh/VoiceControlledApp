package vovan.androidovych.voicecontrolledapp.ui.settings

import vovan.androidovych.voicecontrolledapp.data.VoiceRecognitionRepository
import vovan.androidovych.voicecontrolledapp.ui.base.VoiceManagedViewModel

class SettingsScreenViewModel(
    voiceRecognitionRepository: VoiceRecognitionRepository
): VoiceManagedViewModel(voiceRecognitionRepository)