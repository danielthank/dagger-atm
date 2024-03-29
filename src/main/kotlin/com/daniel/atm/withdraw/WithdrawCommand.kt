package com.daniel.atm.withdraw

import com.daniel.atm.*
import java.math.BigDecimal
import javax.inject.Inject

class WithdrawCommand @Inject constructor(
    private val outputter: Outputter,
    private val account: Database.Account,
    private val limiter: WithdrawalLimiter,
    @MinimumBalance private val minimumBalance: BigDecimal,
    @MaximumWithdrawal private val maximumWithdrawal: BigDecimal
) : BigDecimalCommand(outputter) {
    override fun handleAmount(amount: BigDecimal) {
        val remainingWithdrawalLimit = limiter.remainingWithdrawalLimit
        if (amount > remainingWithdrawalLimit) {
            outputter.output("you may not withdraw $amount; you may withdraw $remainingWithdrawalLimit more in this session")
            return
        }
        val newBalance = account.balance() - amount
        if (newBalance < minimumBalance) {
            outputter.output("error")
        } else {
            account.withdraw(amount)
            limiter.recordWithdrawal(amount)
            outputter.output("your new balance is: " + account.balance())
        }
    }
}
