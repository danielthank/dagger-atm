package com.daniel.atm

import java.util.Optional


interface Command {
    /**
     * String token that signifies this command should be selected (e.g.:
     * "deposit", "withdraw")
     */
    fun key(): String

    /** Process the rest of the command's words and do something.  */
    fun handleInput(input: List<String>): Result

    class Result constructor(
        private val status: Status,
        private val nestedCommandRouter: Optional<CommandRouter>
    ) {

        fun status(): Status {
            return status
        }

        fun nestedCommandRouter(): Optional<CommandRouter> {
            return nestedCommandRouter
        }

        companion object {

            fun invalid(): Result {
                return Result(Status.INVALID, Optional.empty())
            }

            fun handled(): Result {
                return Result(Status.HANDLED, Optional.empty())
            }

            fun inputCompleted(): Result {
                return Result(Status.INPUT_COMPLETED, Optional.empty())
            }

            fun enterNestedCommandSet(nestedCommandRouter: CommandRouter): Result {
                return Result(Status.HANDLED, Optional.of(nestedCommandRouter))
            }
        }
    }


    enum class Status {
        INVALID,
        HANDLED,
        INPUT_COMPLETED
    }
}

