package com.daniel.atm.login

import com.daniel.atm.Command
import com.daniel.atm.Outputter
import com.daniel.atm.SingleArgCommand
import javax.inject.Inject

class LoginCommand @Inject
constructor(private val outputter: Outputter) : SingleArgCommand() {

    override fun key(): String {
        return "login"
    }

    override fun handleArg(username: String): Command.Result {
        outputter.output("$username is logged in.")
        return Command.Result.handled()
    }
}
