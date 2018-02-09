package com.davepacheco.kodein.view

import android.util.Log
import com.davepacheco.kodein.services.MessageService
import com.davepacheco.kodein.services.PersistenceService


interface GreeterView {
    fun setGreeting(greeting: String)
}

class GreetPresenter(val view: GreeterView,
                     private val service: MessageService,
                     val persistenceService: PersistenceService) {

    fun resume() {
        Log.e("GreetPresenter", "Instance is $this - $view - $persistenceService")
        view.setGreeting("${service.getMessage()} - ${persistenceService.getValueFromStore()}" )
    }

    fun setName(name: String) {
        persistenceService.setValueIntoStore(name)
    }
}