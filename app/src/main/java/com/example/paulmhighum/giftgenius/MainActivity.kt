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

    var gender: String = ""


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

        genderGroup.setOnCheckedChangeListener { group, checkedId ->
            if (M.isChecked){
                gender = "Male"
            }
            if (F.isChecked){
                gender = "Female"
            }
            if (O.isChecked){
                gender = "Other"
            }
        }

        getGiftIdeasBtn.setOnClickListener {
            var age = inputAge.text.toString().toIntOrNull()
            var relationshipLength = bubbleSeekBar.progress
            var occasion = inputGiftOccasion.text.toString()
            var relatonshipType = inputRelationshipType.text.toString()
            val intent = Intent(this, IdeaActivity::class.java)
            intent.putExtra("gender", gender)
            intent.putExtra("age", age)
            intent.putExtra("relationshipLength", relationshipLength)
            intent.putExtra("occasion", occasion)
            intent.putExtra("relationshipType", relatonshipType)
            startActivity(intent)
        }
    }
}
