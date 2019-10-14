package com.daniel.atm.login

import com.daniel.atm.Command
import com.daniel.atm.Database
import com.daniel.atm.Outputter
import com.daniel.atm.SingleArgCommand
import javax.inject.Inject

class LoginCommand @Inject
constructor(private val database: Database, private val outputter: Outputter) : SingleArgCommand() {

    override fun key(): String {
        return "login"
    }

    override fun handleArg(arg: String): Command.Result {
        val account = database.getAccount(arg)
        outputter.output("$arg is logged in with balance: ${account.balance()}")
        return Command.Result.handled()
    }
}
