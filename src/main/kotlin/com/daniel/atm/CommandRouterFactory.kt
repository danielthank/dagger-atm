package com.daniel.atm

import com.daniel.atm.helloworld.HelloWorldModule
import dagger.Component

@Component(modules=[HelloWorldModule::class, SystemOutModule::class])
interface CommandRouterFactory {
    fun router(): CommandRouter
}
