package com.flesh.weatherforecastview.objects.weather

import com.google.gson.annotations.SerializedName

/**
 * Created by afleshner on 2/2/2017.
 * Weather Forecast time object.
 */
class WeatherForecastTime {
    @SerializedName("layoutKey") var layoutKey: String? = null
    @SerializedName("startPeriodName") var startPeriodName: MutableList<String>? = null
    @SerializedName("startValidTime") var startValidTime: MutableList<String>? = null
    @SerializedName("tempLabel") var tempLabel: MutableList<String>? = null
}