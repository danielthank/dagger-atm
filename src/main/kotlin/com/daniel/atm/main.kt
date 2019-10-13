package com.daniel.atm

import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val commandRouterFactory = DaggerCommandRouterFactory.create()
    val commandRouter = commandRouterFactory.router()

    while (scanner.hasNextLine()) {
        val str = scanner.nextLine()
        commandRouter.route(str)
    }

}