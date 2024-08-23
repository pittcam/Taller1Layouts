package com.example.taller1layouts.datos

data class Country(
    val name: String,
    val alpha2Code: String,
    val alpha3Code: String,
    val nativeName: String,
    val region: String,
    val subRegion: String,
    val latitude: Double,
    val longitude: Double,
    val area: Int,
    val numericCode: Int,
    val nativeLanguage: String,
    val currencyCode: String,
    val currencyName: String,
    val currencySymbol: String,
    val flag: String,
    val flagPng: String
)