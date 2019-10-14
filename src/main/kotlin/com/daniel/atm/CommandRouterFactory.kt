package com.daniel.atm

import com.daniel.atm.helloworld.HelloWorldModule
import com.daniel.atm.login.LoginModule
import dagger.Component

@Component(modules = [HelloWorldModule::class, LoginModule::class, SystemOutModule::class])
interface CommandRouterFactory {
    fun router(): CommandRouter
}
