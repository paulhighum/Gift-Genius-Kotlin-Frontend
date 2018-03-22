package com.example.paulmhighum.giftgenius

/**
 * Created by paulmhighum on 3/22/18.
 */


import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson

data class Idea(var id: Int, var idea: String, var occasion: String, var gender: String, var minAge: Int, var maxAge: Int, var minRelationshipLength: Int, var maxRelationshipLength: Int, var relationshipType: String) {


    class Deserializer: ResponseDeserializable<Array<Idea>>{
        override fun deserialize(content: String): Array<Idea>? = Gson().fromJson(content, Array<Idea>::class.java)
    }
}