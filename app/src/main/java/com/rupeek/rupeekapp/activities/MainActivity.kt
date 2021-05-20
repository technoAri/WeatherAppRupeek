package com.rupeek.rupeekapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.rupeek.rupeekapp.MainRepository
import com.rupeek.rupeekapp.MyViewModelFactory
import com.rupeek.rupeekapp.R
import com.rupeek.rupeekapp.adapters.WeatherListAdapter
import com.rupeek.rupeekapp.databinding.ActivityMainBinding
import com.rupeek.rupeekapp.interfaces.RetrofitService
import com.rupeek.rupeekapp.viewmodels.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    lateinit var viewModel: MainViewModel

    private val retrofitService = RetrofitService.getInstance()
    val adapter = WeatherListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this, MyViewModelFactory(MainRepository(retrofitService))).get(MainViewModel::class.java)

        binding.recyclerview.adapter = adapter

        viewModel.movieList.observe(this, Observer {
//            Log.d(TAG, "onCreate: $it")
            adapter.setWeatherList(it.results)
        })

        viewModel.errorMessage.observe(this, Observer {

        })
        viewModel.getWeather()
    }
}