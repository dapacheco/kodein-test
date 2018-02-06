package com.davepacheco.kodein.view

import android.util.Log
import com.davepacheco.kodein.services.MessageService
import com.davepacheco.kodein.services.PersistenceService


interface GreeterView {
    fun setGreeting(greeting: String)
}

class GreetPresenter(val view: GreeterView,
                     private val service: MessageService,
                     private val persistenceService: PersistenceService) {

    fun resume() {
        Log.e("MainPresenter", "Instance is $this - $view")
        view.setGreeting("${service.getMessage()} - ${persistenceService.getValueFromStore()}" )
    }

    fun setName(name: String) {
        persistenceService.setValueIntoStore(name)
    }
}