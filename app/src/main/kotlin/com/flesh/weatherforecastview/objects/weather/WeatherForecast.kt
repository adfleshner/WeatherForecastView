package com.flesh.weatherforecastview.objects.weather

import com.flesh.weatherforecastview.library.helpers.WeatherHelper
import com.flesh.weatherforecastview.library.interfaces.WeatherForecastInterface
import com.google.gson.annotations.SerializedName

/**
 * Created by afleshner on 2/2/2017.
 * The main WeatherForecast object that conforms to the WeatherForecastInterface
 */
class WeatherForecast : WeatherForecastInterface {

    @SerializedName("operationalMode") var operationalMode: String? = null
    @SerializedName("srsName") var srsName: String? = null
    @SerializedName("creationDate") var creationDate: String? = null
    @SerializedName("creationDateLocal") var creationDateLocal: String? = null
    @SerializedName("productionCenter") var productionCenter: String? = null
    @SerializedName("credit") var credit: String? = null
    @SerializedName("moreInformation") var moreInformation: String? = null
    @SerializedName("location") var location: WeatherForecastLocation? = null
    @SerializedName("time") var time: WeatherForecastTime? = null
    @SerializedName("data") var data: WeatherForecastData? = null
    @SerializedName("currentobservation") var currentobservation: WeatherForecastCurrentObservation? = null


    override fun getWeatherLocation(): String {
        return "Tuscaloosa"
    }

    override fun getCurrentTemperature(): String {
        return "${currentobservation?.temp} \u2109"
    }

    override fun getCurrentWeatherForecast(): String {
        return currentobservation?.weather ?: "N/A"
    }

    override fun getHeatherHelperList(): MutableList<WeatherHelper> {
        val list: MutableList<WeatherHelper> = mutableListOf()
        time?.startPeriodName!!.mapIndexedTo(list) { i, startPeriodName ->
            WeatherHelper(time?.startPeriodName!![i],
                    time?.tempLabel!![i],
                    data?.temperature!![i],
                    data?.weather!![i],
                    data?.pop!![i],
                    data?.iconLink!![i])
        }
        return list
    }

    override fun getTodaysHigh(isNight: Boolean): String {
        return if (isNight) data?.temperature!![1] else data?.temperature!![0]
    }

    override fun getTodaysLow(isNight: Boolean): String {
        return if (isNight) data?.temperature!![0] else data?.temperature!![1]
    }

    override fun getTodaysPOP(): String {
        return data?.pop?.get(0) ?: "0"
    }

    override fun getCurrentObservationDate(): String {
        return currentobservation?.date ?: "Unknown"
    }


}