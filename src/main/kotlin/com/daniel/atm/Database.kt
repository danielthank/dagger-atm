package com.daniel.atm

import java.math.BigDecimal
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Database @Inject constructor() {
    private val accounts = HashMap<String, Account>()

    fun getAccount(username: String): Account {
        return accounts.computeIfAbsent(username) {
            Account(it)
        }
    }

    class Account(private val username: String) {
        private var balance = BigDecimal.ZERO

        fun username(): String {
            return username
        }

        fun balance(): BigDecimal {
            return balance
        }

        fun deposit(amount: BigDecimal) {
            balance += amount
        }

        fun withdraw(amount: BigDecimal) {
            balance -= amount
        }
    }
}
