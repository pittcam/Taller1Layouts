package com.example.taller1layouts.logica

import android.content.Context
import com.example.taller1layouts.modelo.Country
import java.io.IOException
import java.io.InputStream

class DataRepository(private val context: Context) {

    /*fun loadCountriesFromJSON(): List<Country> {
        val jsonString: String? = try {
            val inputStream = context.assets.open("countries.json") // Replace "countries.json" with your actual filename
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            String(buffer,
            Charsets.UTF_8)
        } catch (ex: IOException) {
            ex.printStackTrace()
            null

        }

        if (jsonString.isNullOrEmpty()) {
            return emptyList()
        }

        val gson = Gson()
        val countriesResponse: CountriesResponse = gson.fromJson(jsonString, CountriesResponse::class.java)
        return countriesResponse.countries.orEmpty() // Handle potential null value for "countries"
    }

    private data class CountriesResponse(val totalCount: Int, val countries: List<Country>?)*/
}