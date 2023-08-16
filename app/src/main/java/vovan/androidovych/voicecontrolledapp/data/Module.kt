package vovan.androidovych.voicecontrolledapp.data

import android.content.Context
import com.google.api.gax.core.CredentialsProvider
import com.google.auth.oauth2.ServiceAccountCredentials
import com.google.cloud.speech.v1.SpeechClient
import com.google.cloud.speech.v1.stub.GrpcSpeechStub
import com.google.cloud.speech.v1.stub.SpeechStubSettings
import org.koin.dsl.module
import vovan.androidovych.voicecontrolledapp.R

private const val HOSTNAME = "speech.googleapis.com"
private const val PORT = 443

val dataModule = module {
    single {
        CredentialsProvider {
            get<Context>().resources.openRawResource(R.raw.creds).let {
                ServiceAccountCredentials.fromStream(it)
            }
        }
    }

    single {
        var grpcStub: GrpcSpeechStub? = null
        SpeechStubSettings.newBuilder()?.apply {
            credentialsProvider = get()
            endpoint = "$HOSTNAME:$PORT"
            grpcStub = GrpcSpeechStub.create(build())
        }
        SpeechClient.create(grpcStub)
    }

    single<VoiceRecognitionRepository> { VoiceRecognitionGoogleApiRepository(get(), get()) }
}