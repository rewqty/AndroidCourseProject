package com.rewqty.prototypelistanime

import com.google.gson.*
import com.rewqty.prototypelistanime.model.Anime
import java.lang.reflect.Type

class AnimeDeserializer : JsonDeserializer<List<Anime>> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): List<Anime> {
        val jsonObject = json?.asJsonObject
        val listAnime = ArrayList<Anime>()
        if(jsonObject?.get("data")?.isJsonArray == true) {
            var node: JsonObject
            var title: String
            var poster: String
            for (anime in jsonObject.get("data")?.asJsonArray!!) {
                node = anime.asJsonObject.get("node").asJsonObject
                title = node.get("title").asString
                poster = node.get("main_picture").asJsonObject.get("large").asString
                listAnime.add(Anime(poster, title))
            }
        }
        return listAnime
    }
}