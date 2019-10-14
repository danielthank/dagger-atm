package com.daniel.atm.helloworld

import dagger.Binds
import dagger.Module
import com.daniel.atm.Command
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@Module
abstract class HelloWorldModule {
    @Binds
    @IntoMap
    @StringKey("hello")
    abstract fun helloWorldCommand(command: HelloWorldCommand): Command
}
