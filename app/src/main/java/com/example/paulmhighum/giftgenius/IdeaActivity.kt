package com.example.paulmhighum.giftgenius

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_idea.*

class IdeaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_idea)

        val age = intent.getIntExtra("age", 0)

        testBtn.setOnClickListener {
            println(age)
        }
    }
}
