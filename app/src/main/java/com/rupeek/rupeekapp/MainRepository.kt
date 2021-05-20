package com.rupeek.rupeekapp

import com.rupeek.rupeekapp.interfaces.RetrofitService

class MainRepository constructor(private val retrofitService: RetrofitService) {

    fun getWeather() = retrofitService.getWeather()
}