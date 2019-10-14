package com.daniel.atm

import com.daniel.atm.helloworld.HelloWorldModule
import com.daniel.atm.login.LoginModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [HelloWorldModule::class, LoginModule::class, UserCommandsModule::class, SystemOutModule::class])
interface CommandRouterFactory {
    fun router(): CommandRouter
}
