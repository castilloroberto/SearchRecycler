package com.roberto.searchrecycler

import android.content.Context
import org.json.JSONException
import org.json.JSONObject

class Model(val title: String, val desc: String, val code: String, val price: String) {


    companion object {

        fun getRecipesFromFile(filename: String, context: Context): ArrayList<Model> {
            val paiList = ArrayList<Model>()

            try {
                // Load data
                val jsonString = loadJsonFromAsset("data.json", context)
                val json = JSONObject(jsonString)
                val recargas = json.getJSONArray("recargas")

                // Get Recipe objects from data
                (0 until recargas.length()).mapTo(paiList) {
                    Model(
                        recargas.getJSONObject(it).getString("title"),
                        recargas.getJSONObject(it).getString("description"),
                        recargas.getJSONObject(it).getString("codigo"),
                        recargas.getJSONObject(it).getString("precio")
                        )
                }
            } catch (e: JSONException) {
                e.printStackTrace()
            }

            return paiList
        }

        private fun loadJsonFromAsset(filename: String, context: Context): String? {
            var json: String? = null

            try {
                val inputStream = context.assets.open(filename)
                val size = inputStream.available()
                val buffer = ByteArray(size)
                inputStream.read(buffer)
                inputStream.close()
                json = String(buffer, Charsets.UTF_8)
            } catch (ex: java.io.IOException) {
                ex.printStackTrace()
                return null
            }

            return json
        }
    }
}




