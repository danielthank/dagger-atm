package com.daniel.atm

interface Outputter {
    companion object {
        operator fun invoke(fn: (String) -> Unit) = object: Outputter {
            override fun output(output: String) = fn(output)
        }
    }

    fun output(output: String)
}
