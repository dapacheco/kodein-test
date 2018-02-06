package com.davepacheco.kodein.services

import com.github.salomonbrys.kodein.*


val serviceModule = Kodein.Module {
    bind<MessageService>() with singleton { RandomMessageService(instance(tag = "defaultGreeting")) }
    constant("defaultGreeting") with "Hello"
}
