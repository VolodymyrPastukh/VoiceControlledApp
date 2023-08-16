package vovan.androidovych.voicecontrolledapp.data

import kotlinx.coroutines.flow.Flow
import vovan.androidovych.voicecontrolledapp.data.entity.VoiceCommandEntity

interface VoiceRecognitionRepository {

    val commandsFlow: Flow<VoiceCommandEntity>
    fun startRecognition()
    fun resume()
    fun pause()
    fun release()
}