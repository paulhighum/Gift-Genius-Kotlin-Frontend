package com.example.paulmhighum.giftgenius

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_activity_main)

        var gender: String = ""

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

        var price: Int = 0

        priceGroup.setOnCheckedChangeListener{ group, checkedId ->
            if(lowPrice.isChecked){
               price = 1
            }

            if(midLowPrice.isChecked){
                price = 2
            }

            if(highMidPrice.isChecked){
                price = 3
            }

            if(highPrice.isChecked){
                price = 4
            }

            if(anyPrice.isChecked){
                price = 0
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
            intent.putExtra("price", price)
            startActivity(intent)
        }
    }
}
