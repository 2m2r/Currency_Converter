package com.ghabiomar.retrofit_daggerhilt_mvvm.util

import kotlinx.coroutines.CoroutineDispatcher

interface DispatcherProvides {
    val main : CoroutineDispatcher
    val io : CoroutineDispatcher
    val default : CoroutineDispatcher
    val unconfined : CoroutineDispatcher
}