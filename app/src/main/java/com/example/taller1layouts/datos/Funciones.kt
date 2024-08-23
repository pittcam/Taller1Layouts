package com.example.taller1layouts.datos

import android.content.Context
import android.util.Log
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream

class Funciones {

    companion object {
        fun guardarPaisesJson(context: Context) {
            val jsonString = loadJSONFromAsset(context)

            if (jsonString != null) {
                try {
                    val json = JSONObject(jsonString)
                    val paisesJson = json.getJSONArray("paises")

                    // Limpia la lista antes de llenarla, por si ya tiene datos
                    Data.COUNTRY_LIST.clear()

                    for (i in 0 until paisesJson.length()) {
                        val jsonObject = paisesJson.getJSONObject(i)
                        val country = Country(
                            name = jsonObject.getString("Name"),
                            alpha2Code = jsonObject.getString("Alpha2Code"),
                            alpha3Code = jsonObject.getString("Alpha3Code"), // Corregido
                            nativeName = jsonObject.getString("NativeName"),
                            region = jsonObject.getString("Region"),
                            subRegion = jsonObject.getString("SubRegion"),
                            latitude = jsonObject.getDouble("Latitude"),
                            longitude = jsonObject.getDouble("Longitude"),
                            area = jsonObject.getInt("Area"),
                            numericCode = jsonObject.getInt("NumericCode"),
                            nativeLanguage = jsonObject.getString("NativeLanguage"),
                            currencyCode = jsonObject.getString("CurrencyCode"),
                            currencyName = jsonObject.getString("CurrencyName"),
                            currencySymbol = jsonObject.getString("CurrencySymbol"), // Corregido
                            flag = jsonObject.getString("Flag"),
                            flagPng = jsonObject.getString("FlagPng")
                        )
                        Data.COUNTRY_LIST.add(country)
                    }
                    Log.d("Funciones", "paises cargados exitosamente: ${Data.COUNTRY_LIST.size}")
                } catch (e: Exception) {
                    Log.e("Funciones", "Error procesando el JSON: ${e.message}")
                }
            } else {
                // Manejar el caso cuando el JSON no se puede cargar
                Log.e("Funciones", "No se pudo cargar el archivo paises.json")
            }
        }

        fun loadJSONFromAsset(context: Context): String? {
            return try {
                val isStream: InputStream = context.assets.open("paises.json")
                val size: Int = isStream.available()
                val buffer = ByteArray(size)
                isStream.read(buffer)
                isStream.close()
                String(buffer, Charsets.UTF_8)
            } catch (ex: IOException) {
                Log.e("Funciones", "Error leyendo el archivo paises.json: ${ex.message}")
                null
            }
        }



    }

   

       
}