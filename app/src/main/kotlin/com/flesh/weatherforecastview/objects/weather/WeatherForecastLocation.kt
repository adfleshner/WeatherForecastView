package com.flesh.weatherforecastview.objects.weather

import com.google.gson.annotations.SerializedName
/**
 * Created by afleshner on 2/2/2017.
 * Weather Forecast Location object
 */
class WeatherForecastLocation {

    @SerializedName("region") var region: String? = null
    @SerializedName("latitude") var latitude: String? = null
    @SerializedName("longitude") var longitude: String? = null
    @SerializedName("elevation") var elevation: String? = null
    @SerializedName("wfo")  var wfo: String? = null
    @SerializedName("timezone") var timezone: String? = null
    @SerializedName("areaDescription") var areaDescription: String? = null
    @SerializedName("radar") var radar: String? = null
    @SerializedName("zone") var zone: String? = null
    @SerializedName("county") var county: String? = null
    @SerializedName("firezone") var firezone: String? = null
    @SerializedName("metar") var metar: String? = null
}