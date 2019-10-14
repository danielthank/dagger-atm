package com.daniel.atm

import java.math.BigDecimal
import javax.inject.Inject
import kotlin.collections.HashMap


class Database @Inject constructor() {
    private val accounts = HashMap<String, Account>()

    fun getAccount(username: String): Account {
        return accounts.computeIfAbsent(username) {
            Account(it)
        }
    }

    class Account(private val username: String) {
        private val balance = BigDecimal.ZERO

        fun username(): String {
            return username
        }

        fun balance(): BigDecimal {
            return balance
        }
    }
}
