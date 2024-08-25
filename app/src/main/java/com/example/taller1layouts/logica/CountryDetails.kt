package com.example.taller1layouts.logica

import android.graphics.drawable.PictureDrawable
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.example.taller1layouts.R
import com.example.taller1layouts.datos.Country


class CountryDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.country_detail)

        val FlagDetail = findViewById<ImageView>(R.id.flag_detail)
        val CountryNameDetail = findViewById<TextView>(R.id.country_name_detail)
        val AlphaCodeDetail = findViewById<TextView>(R.id.alpha_code_detail)
        val CurrencyDetail = findViewById<TextView>(R.id.currency_detail)
        val RegionDetail = findViewById<TextView>(R.id.region_detail)
        val NativeNameDetail = findViewById<TextView>(R.id.native_name_detail)
        val AreaDetail = findViewById<TextView>(R.id.area_detail)
        val NumericCodeDetail = findViewById<TextView>(R.id.numeric_code_detail)
        val NativeLanguageDetail = findViewById<TextView>(R.id.native_language_detail)
        val LatitudeDetail = findViewById<TextView>(R.id.latitude_detail)
        val LongitudeDetail = findViewById<TextView>(R.id.longitude_detail)

        // Obtener el objeto Country de la intención
        val country = intent.getSerializableExtra("country") as Country

        // Cargar la imagen de la bandera usando Glide con el contexto de la actividad
        Glide.with(this)
            .load(country.flagPng)
            .into(FlagDetail)

        CountryNameDetail.text = country.name
        AlphaCodeDetail.text = "${country.alpha2Code} - ${country.alpha3Code}"
        CurrencyDetail.text = "${country.currencyName} (${country.currencySymbol})"
        RegionDetail.text = "${country.region}/${country.subRegion} (${country.latitude}, ${country.longitude})"
        NativeNameDetail.text = country.nativeName
        AreaDetail.text = "Area: ${country.area} km²"
        NumericCodeDetail.text = "Numeric Code: ${country.numericCode}"
        NativeLanguageDetail.text = "Language: ${country.nativeLanguage}"
        LatitudeDetail.text = "Latitud: ${country.latitude}"
        LongitudeDetail.text = "Longitud: ${country.longitude}"

    }

}