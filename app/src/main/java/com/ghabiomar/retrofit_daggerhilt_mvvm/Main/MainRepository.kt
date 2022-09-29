package com.ghabiomar.retrofit_daggerhilt_mvvm.Main

import com.ghabiomar.retrofit_daggerhilt_mvvm.data.models.CurrencyResponse
import com.ghabiomar.retrofit_daggerhilt_mvvm.util.Resource

interface MainRepository {
    suspend fun getRates (base: String) : Resource<CurrencyResponse>
}