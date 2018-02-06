package com.davepacheco.kodein.services

import java.util.*


interface MessageService {
    fun getMessage(): String
}

class RandomMessageService(private val defaultMessage: String) : MessageService {
    private val random = Random()

    override fun getMessage(): String {

        return when (random.nextInt(3)) {
            0 -> "Hi"
            1 -> "Hey"
            2 -> "Hola"
            else -> defaultMessage
        }
    }
}


class GoodByeMessageService : MessageService {
    override fun getMessage(): String {
        return "Bye"
    }
}