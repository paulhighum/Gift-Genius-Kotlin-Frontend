package com.example.paulmhighum.giftgenius

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import com.google.gson.Gson



class MainActivity : AppCompatActivity() {
    val URL: String = "https://gift-genie-ideas.herokuapp.com/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        URL.httpGet().responseObject(Idea.Deserializer()){request, response, result ->
            val (ideas, err) = result
            ideas?.forEach{idea ->
                println("idea: ${idea.idea}")
            }
        }
        URL.httpGet().responseString { request, response, result ->
            when(result){
                is Result.Success -> {
                    val getInfo = (result.get())
                    println(getInfo)

                }
                is Result.Failure -> {
                    println("Failure")
                }
            }
        }

        getGiftIdeasBtn.setOnClickListener {
            val intent = Intent(this, IdeaActivity::class.java)
            startActivity(intent)
        }
    }
}
