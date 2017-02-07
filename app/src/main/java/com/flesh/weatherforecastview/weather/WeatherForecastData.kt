package edu.ua.caps.emergencypreparedness.models.weather

import com.google.gson.annotations.SerializedName

/**
 * Created by afleshner on 2/2/2017.
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