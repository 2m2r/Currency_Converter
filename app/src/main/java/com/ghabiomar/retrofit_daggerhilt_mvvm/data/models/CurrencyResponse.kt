package com.ghabiomar.retrofit_daggerhilt_mvvm.data.models

data class CurrencyResponse(
    val base: String,
    val date: String,
    val rates: Rates,
    val success: Boolean
)