package com.daniel.atm.helloworld

import dagger.Binds
import dagger.Module
import com.daniel.atm.Command

@Module
abstract class HelloWorldModule {
    @Binds
    abstract fun helloWorldCommand(command: HelloWorldCommand): Command
}
