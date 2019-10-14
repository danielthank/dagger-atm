package com.daniel.atm.deposit

import com.daniel.atm.Command
import com.daniel.atm.Database
import com.daniel.atm.Outputter
import java.math.BigDecimal
import javax.inject.Inject

class DepositCommand @Inject constructor(
    private val account: Database.Account,
    private val outputter: Outputter
) : Command {
    override fun handleInput(input: List<String>): Command.Result {
        if (input.size != 1) {
            return Command.Result.invalid()
        }
        account.deposit(BigDecimal(input[0]))
        outputter.output("${account.username()} now has ${account.balance()}")
        return Command.Result.handled()
    }
}