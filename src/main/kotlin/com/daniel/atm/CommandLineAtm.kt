package com.daniel.atm

import com.daniel.atm.commandprocessor.CommandProcessorFactory
import java.util.*

class CommandLineAtm {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val scanner = Scanner(System.`in`)
            val commandProcessor = CommandProcessorFactory.create().commandProcessor()
            while (scanner.hasNextLine()) {
                val str = scanner.nextLine()
                val status = commandProcessor.process(str)
                if (status === Command.Status.INPUT_COMPLETED) {
                    break
                }
            }
        }
    }
}