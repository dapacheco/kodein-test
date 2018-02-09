package com.davepacheco.kodein.view

import android.app.Activity
import android.content.Context
import com.davepacheco.kodein.services.PersistenceService
import com.github.salomonbrys.kodein.*
import com.github.salomonbrys.kodein.android.androidActivityScope
import com.github.salomonbrys.kodein.android.androidContextScope

val activityModule = Kodein.Module {
    bind<PersistenceService>()  with scopedSingleton(androidContextScope) {
        ctx: Context -> PersistenceService(ctx.getSharedPreferences("KodeinTest", Context.MODE_PRIVATE)) }
    bind<GreetPresenter>() with scopedSingleton(androidActivityScope) { GreetPresenter(it as GreeterView, instance(), with(it as Activity).instance()) }
    bind<PerActivityHelper>() with scopedSingleton(androidActivityScope) { PerActivityHelper(instance()) }

}
