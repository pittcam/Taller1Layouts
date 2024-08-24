package com.example.taller1layouts.logica

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.taller1layouts.R
import com.example.taller1layouts.datos.Country
import com.google.android.material.floatingactionbutton.FloatingActionButton

class CountryAdapter(private val countries: List<Country>) : BaseAdapter() {

    override fun getCount(): Int = countries.size

    override fun getItem(position: Int): Any = countries[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = convertView ?: LayoutInflater.from(parent?.context).inflate(R.layout.item_country_card, parent, false)
        val country = getItem(position) as Country

        val ivFlag = view.findViewById<ImageView>(R.id.iv_flag)
        val tvCountryName = view.findViewById<TextView>(R.id.tv_country_name)
        val tvNativeName = view.findViewById<TextView>(R.id.tv_native_name)
        val tvAlpha3Code = view.findViewById<TextView>(R.id.tv_alpha3_code)
        val tvCurrency = view.findViewById<TextView>(R.id.tv_currency)
        val fabCall = view.findViewById<FloatingActionButton>(R.id.fab_call)

        // Cargar la imagen de la bandera usando Glide o cualquier otro cargador de imágenes
        parent?.context?.let {
            Glide.with(it)
                .load(country.flagPng)
                .into(ivFlag)
        }

        // Asignar valores a los TextViews
        tvCountryName.text = country.name
        tvNativeName.text = country.nativeName
        tvAlpha3Code.text = country.alpha3Code
        tvCurrency.text = "${country.currencyName} (${country.currencySymbol})"

        // Configurar la acción del botón flotante
        fabCall.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:${country.numericCode}")
            }
            parent?.context?.startActivity(intent)
        }

        // Configurar el click en toda la vista para abrir la nueva actividad
        view.setOnClickListener {
            val context = view.context // Obtener el contexto desde la vista
            val intent = Intent(context, CountryDetails::class.java)
            intent.putExtra("country", country)
            context.startActivity(intent)
        }


        return view
    }
}
