package com.example.paulmhighum.giftgenius

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_idea.*

class IdeaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_idea)

        val age = intent.getIntExtra("age", 0)
        val relationshipLength = intent.getIntExtra("relationshipLength", 0)
        val gender = intent.getStringExtra("gender")
        val relationshipType = intent.getStringExtra("relationshipType")
        val occasion = intent.getStringExtra("occasion")


        println("${age}, ${relationshipLength}, ${gender}, ${relationshipType}, ${occasion}")

    }
}
