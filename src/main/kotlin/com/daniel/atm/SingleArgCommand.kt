package com.daniel.atm

abstract class SingleArgCommand : Command {
    override fun handleInput(input: List<String>): Command.Result {
        return if (input.isEmpty()) handleArg("testUser") else Command.Result.invalid()
    }

    /** Handles the single argument to the command.  */
    protected abstract fun handleArg(arg: String): Command.Result
}
