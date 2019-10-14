package com.daniel.atm

import dagger.Module
import dagger.Provides
import java.math.BigDecimal
import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class MinimumBalance

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class MaximumWithdrawal

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
