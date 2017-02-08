package com.flesh.weatherforecastview.objects.weather

import com.google.gson.annotations.SerializedName

/**
 * Created by afleshner on 2/2/2017.
 * The Current Weather forecast
 */
class WeatherForecastCurrentObservation {
    @SerializedName("id") var id: String? = null
    @SerializedName("name") var name: String? = null
    @SerializedName("elev") var elev: String? = null
    @SerializedName("latitude") var latitude: String? = null
    @SerializedName("longitude") var longitude: String? = null
    @SerializedName("Date") var date: String? = null
    @SerializedName("Temp") var temp: String? = null
    @SerializedName("Dewp") var dewp: String? = null
    @SerializedName("Relh") var relh: String? = null
    @SerializedName("Winds") var winds: String? = null
    @SerializedName("Windd") var windd: String? = null
    @SerializedName("Gust") var gust: String? = null
    @SerializedName("Weather") var weather: String? = null
    @SerializedName("Weatherimage") var weatherImage: String? = null
    @SerializedName("Visibility") var visibility: String? = null
    @SerializedName("Altimeter") var altimeter: String? = null
    @SerializedName("SLP") var slp: String? = null
    @SerializedName("timezone") var timezone: String? = null
    @SerializedName("state") var state: String? = null
    @SerializedName("WindChill") var windChill: String? = null
}