package com.davepacheco.kodein

import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.KodeinInjector
import com.github.salomonbrys.kodein.conf.ConfigurableKodein
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement


class KodeinRule(private val factory: () -> KodeinInitialiser, private val testModules: List<Kodein.Module> = listOf()) : TestRule {

    val injector = KodeinInjector()

    override fun apply(base: Statement, description: Description?): Statement {

        val app: KodeinInitialiser = factory()
        app.initKodein()

        testModules.forEach {
            (app.kodein as ConfigurableKodein).addImport(it, true)
        }

        injector.inject(app.kodein)

        return object : Statement() {
            override fun evaluate() {
                base.evaluate()
            }
        }
    }
}