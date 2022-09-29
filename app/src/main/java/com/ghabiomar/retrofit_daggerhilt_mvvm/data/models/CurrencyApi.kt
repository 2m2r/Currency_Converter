package com.ghabiomar.retrofit_daggerhilt_mvvm.data.models

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyApi {
    @GET("/latest")
     suspend fun getRatesApi(
        @Query("base")  base : String
    ) :Response<CurrencyResponse>

}