package com.daniel.atm.login

import com.daniel.atm.*
import java.util.*
import javax.inject.Inject

class LoginCommand @Inject
constructor(
    private val database: Database,
    private val outputter: Outputter,
    private val userCommandsRouterFactory: UserCommandsRouter.Factory,
    private val account: Optional<Database.Account>

) : SingleArgCommand() {
    override fun handleArg(str: String): Command.Result {
        if (account.isPresent) {
            return Command.Result.handled()
        }
        val account = database.getAccount(str)
        outputter.output("$str is logged in with balance: ${account.balance()}")
        return Command.Result.enterNestedCommandSet(userCommandsRouterFactory.create(account).router())
    }
}
