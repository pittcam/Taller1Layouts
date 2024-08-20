package com.example.taller1layouts.logica

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.taller1layouts.R

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //Variables
        val spinnerRegion = findViewById<Spinner>(R.id.spinnerRegion)
        val btnListCountries: Button = findViewById<Button>(R.id.btnListCountries)

        spinnerRegion.onItemSelectedListener = this

        btnListCountries.setOnClickListener{
            val selectedItem = spinnerRegion.selectedItem.toString()

            // Obtener la lista de países desde el JSON según el continente seleccionado


        }


    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
    }

}