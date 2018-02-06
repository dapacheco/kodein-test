package com.davepacheco.kodein

import android.app.Application
import com.davepacheco.kodein.services.serviceModule
import com.davepacheco.kodein.view.activityModule
import com.github.salomonbrys.kodein.*
import com.github.salomonbrys.kodein.android.autoAndroidModule
import com.github.salomonbrys.kodein.conf.ConfigurableKodein


interface KodeinInitialiser : KodeinAware {
    fun initKodein()
}

class MainApplication : Application(), KodeinInitialiser {

    override val kodein = ConfigurableKodein()

    override fun onCreate() {
        initKodein()
        super.onCreate()
    }

    override fun initKodein() {
        kodein.addConfig {
            import(autoAndroidModule(this@MainApplication))

            import(activityModule)
            import(serviceModule)
        }
    }
}
