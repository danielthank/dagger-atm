package com.daniel.atm.logout

import com.daniel.atm.Command
import com.daniel.atm.Database
import com.daniel.atm.Outputter
import javax.inject.Inject

class LogoutCommand @Inject constructor(private val outputter: Outputter, private val account: Database.Account) :
    Command {
    override fun handleInput(input: List<String>): Command.Result {
        return if (input.isEmpty()) {
            outputter.output("${account.username()} logout success")
            Command.Result.inputCompleted()
        } else {
            Command.Result.invalid()
        }
    }
}
