package com.davepacheco.kodein.view

import android.content.Intent
import android.os.Bundle
import com.davepacheco.kodein.R
import com.github.salomonbrys.kodein.android.KodeinAppCompatActivity
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.with
import kotlinx.android.synthetic.main.activity_main.*

class GreetActivity : KodeinAppCompatActivity(), GreeterView {

    private val presenter: GreetPresenter by with(this).instance()
    private val perActivityHelper: PerActivityHelper by with(this).instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nextButton.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        presenter.resume()
        perActivityHelper.somethingPerActivity()
    }

    override fun setGreeting(greeting: String) {
        greetingTextView.text = greeting
    }
}
