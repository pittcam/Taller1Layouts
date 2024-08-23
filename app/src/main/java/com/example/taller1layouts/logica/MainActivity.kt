package com.example.taller1layouts.logica

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.taller1layouts.R
import com.example.taller1layouts.datos.Funciones
import org.json.JSONArray
import java.io.IOException

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //Variables
        val spinnerRegion = findViewById<Spinner>(R.id.spinnerRegion)
        val btnListCountries: Button = findViewById<Button>(R.id.btnListCountries)
        Funciones.guardarPaisesJson(this)

        spinnerRegion.onItemSelectedListener = this

        btnListCountries.setOnClickListener {
            val selectedRegion = spinnerRegion.selectedItem.toString()
            enviarRegion(selectedRegion)
        }

    }

    private fun enviarRegion(region: String ){
        val bolsa = Bundle()
        bolsa.putString("region",region)
        val intent = Intent(this, CountryList::class.java)
        intent.putExtra("bolsa", bolsa)
        startActivity(intent)

    }


    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
    }

}