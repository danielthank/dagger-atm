package com.daniel.atm.deposit

import com.daniel.atm.BigDecimalCommand
import com.daniel.atm.Database
import com.daniel.atm.Outputter
import com.daniel.atm.WithdrawalLimiter
import java.math.BigDecimal
import javax.inject.Inject

class DepositCommand @Inject constructor(
    private val account: Database.Account,
    private val outputter: Outputter,
    private val limiter: WithdrawalLimiter
) : BigDecimalCommand(outputter) {
    override fun handleAmount(amount: BigDecimal) {
        account.deposit(amount)
        limiter.recordDeposit(amount)
        outputter.output("${account.username()} now has ${account.balance()}")
    }
}
