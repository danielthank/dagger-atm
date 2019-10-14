package com.daniel.atm

import dagger.Module
import dagger.Provides
import java.math.BigDecimal

@Module
object AmountsModule {
    @JvmStatic
    @Provides
    @MinimumBalance
    fun minimumBalance(): BigDecimal {
        return BigDecimal.ZERO
    }

    @JvmStatic
    @Provides
    @MaximumWithdrawal
    fun maximumWithdrawal(): BigDecimal {
        return BigDecimal(1000)
    }
}
