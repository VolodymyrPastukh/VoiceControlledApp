package vovan.androidovych.voicecontrolledapp.ui.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow
import vovan.androidovych.voicecontrolledapp.data.VoiceRecognitionRepository
import vovan.androidovych.voicecontrolledapp.data.entity.VoiceCommandEntity

abstract class VoiceManagedViewModel(
    private val voiceRecognizer: VoiceRecognitionRepository,
) : ViewModel() {
    val commandState: Flow<VoiceCommandEntity> = voiceRecognizer.commandsFlow

    fun startRecognition(){
        voiceRecognizer.startRecognition()
    }

    protected fun release() {
        voiceRecognizer.release()
    }
}