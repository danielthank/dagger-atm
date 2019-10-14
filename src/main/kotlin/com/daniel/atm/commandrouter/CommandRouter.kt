package com.daniel.atm.commandrouter

import com.daniel.atm.Command
import javax.inject.Inject

class CommandRouter @Inject constructor(private val commands: Map<String, @JvmSuppressWildcards Command>) {

    fun route(input: String): Command.Result {
        val splitInput = split(input)
        if (splitInput.isEmpty()) {
            return invalidCommand(input)
        }
        val commandKey = splitInput[0]
        val command = commands[commandKey]
        command ?: return invalidCommand(input)
        val result = command.handleInput(splitInput.subList(1, splitInput.size))
        if (result.status() === Command.Status.INVALID) {
            println("$commandKey: invalid arguments")
        }
        return result
    }

    private fun invalidCommand(input: String): Command.Result {
        println(
            String.format("couldn't understand \"%s\". please try again.", input)
        )
        return Command.Result.invalid()
    }

    // Split on whitespace
    private fun split(input: String): List<String> {
        return input.trim().split(Regex("\\s+"))
    }
}