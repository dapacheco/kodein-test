package com.davepacheco.kodein

import com.github.salomonbrys.kodein.Kodein.Module
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.singleton
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

val testModule = Module {
    bind<ServiceDependency>(overrides = true) with singleton { ServiceDependency("TestValue") }
}

class SomeServiceTest {

    @Rule
    @JvmField
    val injectorRule = KodeinRule(::MainApplication, listOf(testModule))

    val serviceTest: SomeService by injectorRule.injector.instance()

    @Test
    fun `ensure Kodein dependency can be overriden`() {
        Assert.assertEquals(serviceTest.dependencyValue(), "TestValue")
    }
}