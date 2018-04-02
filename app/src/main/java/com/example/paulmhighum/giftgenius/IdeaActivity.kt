package com.example.paulmhighum.giftgenius

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import com.github.kittinunf.fuel.httpGet
import android.widget.TextView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

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
        val price = intent.getIntExtra("price", 0)

        val listView = findViewById<ListView>(R.id.listv) as ListView
        val stringArrayList = ArrayList<String>()


        URL.httpGet().responseObject(Idea.Deserializer()){request, response, result ->
            val (ideas, err) = result
            ideas?.forEach{idea ->
                if(idea.gender == gender || idea.gender == "Any"){
                    if(idea.minAge < age && idea.maxAge > age){
                        if(idea.minRelationshipLength < relationshipLength && idea.maxRelationshipLength > relationshipLength){
                            if(idea.occasion.toLowerCase() == occasion.toLowerCase() || idea.occasion == "Any"){
                                if(idea.relationshipType.toLowerCase() == relationshipType.toLowerCase() || idea.relationshipType == "Any"){
                                    if(idea.price == price || idea.price == 0 || price == 0){
                                        stringArrayList.add("  ${idea.idea}")
                                        val listAdapter = ArrayAdapter(this, R.layout.list_row, stringArrayList)
                                        listView.adapter = listAdapter
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

    }
}
