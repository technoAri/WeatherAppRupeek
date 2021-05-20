package com.rupeek.rupeekapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rupeek.rupeekapp.MainRepository
import com.rupeek.rupeekapp.models.Data
import com.rupeek.rupeekapp.models.WeatherModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel constructor(private val repository: MainRepository)  : ViewModel() {

    val movieList = MutableLiveData<Data>()
    val errorMessage = MutableLiveData<String>()

    fun getWeather() {

        val response = repository.getWeather()
        response.enqueue(object : Callback<Data> {
            override fun onResponse(call: Call<Data>, response: Response<Data>) {
                movieList.postValue(response.body())
            }

            override fun onFailure(call: Call<Data>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}