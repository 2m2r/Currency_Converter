package com.ghabiomar.retrofit_daggerhilt_mvvm.di

import android.app.Application
import com.ghabiomar.retrofit_daggerhilt_mvvm.Main.DefaultMainRepository
import com.ghabiomar.retrofit_daggerhilt_mvvm.Main.MainRepository
import com.ghabiomar.retrofit_daggerhilt_mvvm.data.models.CurrencyApi
import com.ghabiomar.retrofit_daggerhilt_mvvm.util.DispatcherProvides
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

private const val BASE_URL = "https://exchangerate.host/#/donate/"

@Module
@InstallIn(ApplicationComponent::class)
object AppModule : Application() {

    fun gson ():Gson = GsonBuilder()
        .setLenient()
        .create()

    fun client (): OkHttpClient = OkHttpClient()


    @Singleton
    @Provides
    fun provideCurrencyApi () : CurrencyApi= Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson()))
        .client(client())
        .build()
        .create(CurrencyApi::class.java)

    @Singleton
    @Provides
    fun provideMainRepository(api :CurrencyApi) : MainRepository = DefaultMainRepository(api)


    @Singleton
    @Provides
    fun provideDispatchers():DispatcherProvides = object :DispatcherProvides{
        override val main: CoroutineDispatcher
            get() = Dispatchers.Main
        override val io: CoroutineDispatcher
            get() = Dispatchers.IO
        override val default: CoroutineDispatcher
            get() = Dispatchers.Default
        override val unconfined: CoroutineDispatcher
            get() = Dispatchers.Unconfined
    }


}