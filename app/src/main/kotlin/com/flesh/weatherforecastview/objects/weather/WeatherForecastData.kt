package com.flesh.weatherforecastview.objects.weather

import com.google.gson.annotations.SerializedName

/**
 * Created by afleshner on 2/2/2017.
 * An object of lists of strings that all conform to each other.
 */
class WeatherForecastData {
    @SerializedName("temperature") var temperature: List<String>? = null
    @SerializedName("pop") var pop: List<String>? = null
    @SerializedName("weather") var weather: List<String>? = null
    @SerializedName("iconLink") var iconLink: List<String>? = null
    @SerializedName("hazard") var hazard: List<String>? = null
    @SerializedName("hazardUrl") var hazardUrl: List<String>? = null
    @SerializedName("text") var text: List<String>? = null
}