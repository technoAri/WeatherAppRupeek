package com.rupeek.rupeekapp.models

import com.google.gson.annotations.SerializedName

data class Data(
    @field:SerializedName("data")
    var results: List<WeatherModel>
)

data class WeatherModel (
    @field:SerializedName("temp")
    var temperature: String ?= null,

    @field:SerializedName("time")
    var date: String ?= null,

    @field:SerializedName("rain")
    var rain: String ?= null,

    @field:SerializedName("wind")
    var wind: String ?= null,
    )

