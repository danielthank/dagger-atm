package com.daniel.atm.login

import com.daniel.atm.Command
import dagger.Binds
import dagger.Module

@Module
abstract class LoginModule {
    @Binds
    abstract fun loginCommand(command: LoginCommand): Command
}