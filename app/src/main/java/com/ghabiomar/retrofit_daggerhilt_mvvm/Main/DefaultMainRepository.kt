package com.ghabiomar.retrofit_daggerhilt_mvvm.Main

import com.ghabiomar.retrofit_daggerhilt_mvvm.data.models.CurrencyApi
import com.ghabiomar.retrofit_daggerhilt_mvvm.data.models.CurrencyResponse
import com.ghabiomar.retrofit_daggerhilt_mvvm.util.Resource
import javax.inject.Inject

class DefaultMainRepository @Inject constructor(
    private val api :CurrencyApi
):MainRepository{
    override suspend fun getRates(base: String): Resource<CurrencyResponse> {
       return try {
           val response = api.getRatesApi(base)
           val result = response.body()
           if (response.isSuccessful && result != null ){
               Resource.Success(result)
           }else{
               Resource.Error(response.message())
           }
       }catch (e: Exception){
           Resource.Error(e.message ?: "An Error Occured")
       }
    }


}
