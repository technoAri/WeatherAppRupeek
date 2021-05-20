package com.rupeek.rupeekapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rupeek.rupeekapp.databinding.WeatherListItemBinding
import com.rupeek.rupeekapp.models.WeatherModel
import java.text.SimpleDateFormat
import java.util.*

class WeatherListAdapter: RecyclerView.Adapter<WeatherListAdapter.MainViewHolder>() {

    var weather = mutableListOf<WeatherModel>()

    fun setWeatherList(weather: List<WeatherModel>) {
        this.weather = weather.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val binding = WeatherListItemBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val weather = weather[position]
        holder.binding.tvWeather.text = "${weather.temperature}\u2103"
        holder.binding.tvDate.text = weather.date?.let { getDateTime(it).toString() }
        holder.binding.tvRain.text = "${weather.rain}%"
        holder.binding.tvWind.text = "${weather.wind} km/h"
    }

    override fun getItemCount(): Int {
        return weather.size
    }

    class MainViewHolder(val binding: WeatherListItemBinding) : RecyclerView.ViewHolder(binding.root) {

    }


    private fun getDateTime(s: String): String? {
        try {
            val sdf = SimpleDateFormat("MMM dd yyyy")
            val netDate = Date(s.toLong() * 1000)
            return sdf.format(netDate)
        } catch (e: Exception) {
            return e.toString()
        }
    }
}