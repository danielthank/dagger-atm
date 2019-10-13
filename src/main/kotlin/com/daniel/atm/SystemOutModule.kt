package com.daniel.atm

import dagger.Module
import dagger.Provides

@Module
object SystemOutModule {
    @JvmStatic
    @Provides
    fun textOutputter(): Outputter {
        return Outputter {
            println(it)
        }
    }
}

