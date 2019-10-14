package com.daniel.atm.withdraw

import com.daniel.atm.*
import java.math.BigDecimal
import javax.inject.Inject

class WithdrawCommand @Inject constructor(
    private val outputter: Outputter,
    private val account: Database.Account,
    @MinimumBalance private val minimumBalance: BigDecimal,
    @MaximumWithdrawal private val maximumWithdrawal: BigDecimal
) : BigDecimalCommand(outputter) {
    override fun handleAmount(amount: BigDecimal) {
        if (amount > maximumWithdrawal) {
            outputter.output("error")
            return
        }
        val newBalance = account.balance() - amount
        if (newBalance < minimumBalance) {
            outputter.output("error")
        } else {
            account.withdraw(amount)
            outputter.output("your new balance is: " + account.balance())
        }
    }
}
