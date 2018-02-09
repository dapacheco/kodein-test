package com.davepacheco.kodein.view

import android.app.Activity
import android.util.Log


class PerActivityHelper(private val activity: Activity) {

    fun somethingPerActivity() {
        Log.e(activity.componentName.shortClassName, "Logging per activity POC $this - $activity")
    }
}