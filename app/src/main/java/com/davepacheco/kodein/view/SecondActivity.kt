package com.davepacheco.kodein.view

import android.os.Bundle
import android.view.View
import com.davepacheco.kodein.R
import com.davepacheco.kodein.services.GoodByeMessageService
import com.davepacheco.kodein.services.MessageService
import com.github.salomonbrys.kodein.*
import com.github.salomonbrys.kodein.android.KodeinAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class SecondActivity : KodeinAppCompatActivity(), GreeterView {

    private val presenter: GreetPresenter by with(this).instance()
    private val perActivityHelper: PerActivityHelper by with(this).instance()

    override fun provideOverridingModule() = Kodein.Module {
        bind<MessageService>(overrides = true) with singleton { GoodByeMessageService() }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun setGreeting(greeting: String) {
        greetingTextView.text = greeting
        nextButton.visibility = View.INVISIBLE
    }

    override fun onResume() {
        super.onResume()
        presenter.setName("test")
        presenter.resume()
        perActivityHelper.somethingPerActivity()
    }
}

