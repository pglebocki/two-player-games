package org.home.twoplayergames.ox.dagger

import dagger.Component
import org.home.twoplayergames.ox.ui.OXWindow
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun appWindow(): OXWindow

    @Component.Builder
    interface Builder {

        fun build(): AppComponent
    }
}