package vovan.androidovych.voicecontrolledapp.ui

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import vovan.androidovych.voicecontrolledapp.ui.content.ContentScreenViewModel
import vovan.androidovych.voicecontrolledapp.ui.home.HomeScreenViewModel
import vovan.androidovych.voicecontrolledapp.ui.settings.SettingsScreenViewModel

val uiModule = module {
    single(named(DispatcherToken.IO)) { Dispatchers.IO }
    single(named(DispatcherToken.DEFAULT)) { Dispatchers.Default }
    single(named(DispatcherToken.MAIN)) { Dispatchers.Main }

    single {
        CoroutineScope(
            SupervisorJob() +
                    get<CoroutineDispatcher>(named(DispatcherToken.DEFAULT)) +
                    CoroutineExceptionHandler { _, throwable -> throwable.printStackTrace() }
        )
    }

    viewModel { HomeScreenViewModel(get()) }
    viewModel { SettingsScreenViewModel(get()) }
    viewModel { ContentScreenViewModel(get()) }
}

enum class DispatcherToken {
    IO,
    DEFAULT,
    MAIN,
}