package com.davepacheco.kodein.view

import android.content.Context
import com.davepacheco.kodein.services.PersistenceService
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.android.androidActivityScope
import com.github.salomonbrys.kodein.android.androidContextScope
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.scopedSingleton

val activityModule = Kodein.Module {
    bind<PersistenceService>()  with scopedSingleton(androidContextScope) {
        ctx: Context -> PersistenceService(ctx.getSharedPreferences("KodeinTest", Context.MODE_PRIVATE)) }
    bind<GreetPresenter>() with scopedSingleton(androidActivityScope) { GreetPresenter(it as GreeterView, instance(), instance()) }
    bind<PerActivityHelper>() with scopedSingleton(androidActivityScope) { PerActivityHelper(instance()) }

}
