package com.daniel.atm.commandprocessor

import com.daniel.atm.AmountsModule
import com.daniel.atm.SystemOutModule
import com.daniel.atm.UserCommandsRouter
import com.daniel.atm.helloworld.HelloWorldModule
import com.daniel.atm.login.LoginModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [HelloWorldModule::class, LoginModule::class, UserCommandsRouter.InstallationModule::class, SystemOutModule::class, AmountsModule::class])
interface CommandProcessorFactory {
    fun commandProcessor(): CommandProcessor

    companion object {
        fun create(): CommandProcessorFactory {
            return DaggerCommandProcessorFactory.create()
        }
    }
}
