package com.daniel.atm.login

import com.daniel.atm.Command
import com.daniel.atm.Database
import dagger.Binds
import dagger.BindsOptionalOf
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@Module
abstract class LoginModule {
    @Binds
    @IntoMap
    @StringKey("login")
    abstract fun loginCommand(command: LoginCommand): Command

    @BindsOptionalOf
    abstract fun optionalAccount(): Database.Account
}
