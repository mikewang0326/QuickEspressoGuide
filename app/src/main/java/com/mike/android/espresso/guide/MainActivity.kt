package com.mike.android.espresso.guide

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
  private lateinit var greetingView: TextView

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    greetingView = findViewById(R.id.greeting)
  }

  fun greet(v: View) {
    greetingView.setText(R.string.hello)
  }
}