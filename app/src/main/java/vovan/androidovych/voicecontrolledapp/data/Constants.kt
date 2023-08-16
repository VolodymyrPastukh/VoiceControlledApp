package vovan.androidovych.voicecontrolledapp.data

import android.media.AudioFormat

object Constants {
    const val SAMPLE_RATE = 44000
    const val LANGUAGE_CODE = "en-US"
    const val CHANNEL_CONFIG: Int = AudioFormat.CHANNEL_IN_MONO
    const val AUDIO_FORMAT: Int = AudioFormat.ENCODING_PCM_16BIT
    const val BUFFER_SIZE: Int = 6400
}