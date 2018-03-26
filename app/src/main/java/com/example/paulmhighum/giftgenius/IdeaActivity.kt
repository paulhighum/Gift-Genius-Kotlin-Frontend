package com.example.paulmhighum.giftgenius

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.github.kittinunf.fuel.httpGet
import android.widget.TextView
import android.widget.LinearLayout

class IdeaActivity : AppCompatActivity() {

    val URL: String = "https://gift-genie-ideas.herokuapp.com/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_activity_idea)

        val age = intent.getIntExtra("age", 0)
        val relationshipLength = intent.getIntExtra("relationshipLength", 0)
        val gender = intent.getStringExtra("gender")
        val relationshipType = intent.getStringExtra("relationshipType")
        val occasion = intent.getStringExtra("occasion")

        val llMain = findViewById<LinearLayout>(R.id.ll_main_layout) as LinearLayout

        URL.httpGet().responseObject(Idea.Deserializer()){request, response, result ->
            val (ideas, err) = result
            ideas?.forEach{idea ->
                if(idea.gender == gender || idea.gender == "Any"){
                    if(idea.minAge < age){
                        if(idea.minRelationshipLength < relationshipLength && idea.maxRelationshipLength > relationshipLength){
                            if(idea.occasion.toLowerCase() == occasion.toLowerCase() || idea.occasion == "Any"){
                                if(idea.relationshipType.toLowerCase() == relationshipType.toLowerCase() || idea.relationshipType == "Any"){
                                    val ideaDynamic = TextView(this)
                                    ideaDynamic.textSize = 24f
                                    ideaDynamic.text = idea.idea
                                    llMain.addView(ideaDynamic)
                                }
                            }
                        }
                    }
                }
            }
        }

    }
}
