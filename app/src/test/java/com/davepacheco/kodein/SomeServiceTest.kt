package com.davepacheco.kodein

import com.davepacheco.kodein.services.MessageService
import com.github.salomonbrys.kodein.Kodein.Module
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.singleton
import com.github.salomonbrys.kodein.with
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

val testModule = Module {
    bind<MessageService>(overrides = true) with singleton { DefaultMessageService(instance(tag = "defaultGreeting")) }
    constant("defaultGreeting", overrides = true) with "TestValue"
}

class DefaultMessageService(private val defaultMessage: String): MessageService {
    override fun getMessage(): String {
        return defaultMessage
    }
}

class SomeServiceTest {

    @Rule
    @JvmField
    val injectorRule = KodeinRule(::MainApplication, listOf(testModule))

    val serviceTest: MessageService by injectorRule.injector.instance()

    @Test
    fun `ensure Kodein dependency can be overriden`() {
        Assert.assertEquals(serviceTest.getMessage(), "TestValue")
    }
}