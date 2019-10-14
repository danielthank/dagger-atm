package com.daniel.atm.deposit

import com.daniel.atm.BigDecimalCommand
import com.daniel.atm.Database
import com.daniel.atm.Outputter
import java.math.BigDecimal
import javax.inject.Inject

class DepositCommand @Inject constructor(
    private val account: Database.Account,
    private val outputter: Outputter
) : BigDecimalCommand(outputter) {
    override fun handleAmount(amount: BigDecimal) {
        account.deposit(amount)
        outputter.output("${account.username()} now has ${account.balance()}")
    }
}
