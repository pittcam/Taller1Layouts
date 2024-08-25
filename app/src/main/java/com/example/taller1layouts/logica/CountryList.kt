package com.example.taller1layouts.logica

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.taller1layouts.R
import com.example.taller1layouts.datos.Country
import com.example.taller1layouts.datos.Data

class CountryList : AppCompatActivity() {
    private lateinit var listView: ListView
    private lateinit var countryAdapter: CountryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.country_list)

        listView = findViewById(R.id.listPaises)

        val bolsa = intent.getBundleExtra("bolsa")
        if(bolsa != null){
            val region = bolsa.getString("region")?: ""
            loadCountries(region)
        }

    }

    private fun loadCountries(region: String) {
        var paisesFiltrados = ArrayList<Country> ()
        for (pais in Data.COUNTRY_LIST) {
            if (pais.region == region) {
                paisesFiltrados.add(pais)
            }
        }
        var adapter = CountryAdapter(paisesFiltrados)
        val listView: ListView = findViewById(R.id.listPaises)

        listView.adapter = adapter


    }







}