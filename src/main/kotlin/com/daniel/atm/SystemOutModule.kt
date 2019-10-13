package com.daniel.atm

import dagger.Module
import dagger.Provides

@Module
abstract class SystemOutModule {
    @Provides
    fun textOutputter() {
        Outputter {
            println(it)
        }
    }
}

