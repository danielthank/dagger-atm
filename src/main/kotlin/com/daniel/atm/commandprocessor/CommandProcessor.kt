package com.daniel.atm.commandprocessor

import com.daniel.atm.Command
import com.daniel.atm.commandrouter.CommandRouter
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CommandProcessor @Inject constructor(_firstCommandRouter: CommandRouter) {
    private val commandRouterStack = ArrayDeque<CommandRouter>()

    init {
        commandRouterStack.push(_firstCommandRouter)
    }

    fun process(input: String): Command.Status {
        val result = commandRouterStack.peek().route(input)
        if (result.status() === Command.Status.INPUT_COMPLETED) {
            commandRouterStack.pop()
            return if (commandRouterStack.isEmpty())
                Command.Status.INPUT_COMPLETED
            else
                Command.Status.HANDLED
        }

        result.nestedCommandRouter().ifPresent {
            commandRouterStack.push(it)
        }
        return result.status()
    }
}
