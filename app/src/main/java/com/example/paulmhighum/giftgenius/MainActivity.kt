package com.example.paulmhighum.giftgenius

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        "https://gift-genie-ideas.herokuapp.com/".httpGet().responseString { request, response, result ->
            when(result){
                is Result.Success -> {
                    println("Result: ${result.get()}")}
                is Result.Failure -> {
                    println("Failure")
                }
            }
        }

        getGiftIdeasBtn.setOnClickListener {

        }
    }
}
