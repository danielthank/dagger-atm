package com.daniel.atm

import javax.inject.Inject

class CommandRouter {

    private val commands = mutableMapOf<String, Command>()

    @Inject
    constructor(command: Command) {
        commands[command.key()] = command
    }

    fun route(input: String): Command.Status {
        val splitInput = split(input)
        if (splitInput.isEmpty()) {
            return invalidCommand(input)
        }
        val commandKey = splitInput[0]
        val command = commands[commandKey]
        command ?: return invalidCommand(input)
        val status = command.handleInput(splitInput.subList(1, splitInput.size))
        if (status === Command.Status.INVALID) {
            println("$commandKey: invalid arguments")
        }
        return status
    }

    private fun invalidCommand(input: String): Command.Status {
        println(
            String.format("couldn't understand \"%s\". please try again.", input)
        )
        return Command.Status.INVALID
    }

    // Split on whitespace
    private fun split(input: String): List<String> {
        return input.trim().split("\\s+")
    }
}