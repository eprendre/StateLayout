package com.github.eprendre.statelayout.demo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    simple_state_button.setOnClickListener { startActivity<SimpleStateActivity>() }
    custom_state_button.setOnClickListener { startActivity<CustomStateActivity>() }
  }
}
