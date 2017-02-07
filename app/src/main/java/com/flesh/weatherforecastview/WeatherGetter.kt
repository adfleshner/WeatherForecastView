package com.flesh.weatherforecastview

import android.os.Handler
import android.os.Looper
import com.google.gson.Gson
import edu.ua.caps.emergencypreparedness.models.weather.WeatherForecast

/**
 * Created by afleshner on 2/7/2017.
 */
class WeatherGetter {

    fun getWeather(): WeatherForecast {
        return returnForecast()
    }

    internal fun returnForecast(): WeatherForecast {
        val json = "{\n" +
                "\t\"operationalMode\":\"Production\",\n" +
                "\t\"srsName\":\"WGS 1984\",\n" +
                "\t\"creationDate\":\"2017-02-02T10:06:01-06:00\",\n" +
                "\t\"creationDateLocal\":\"2 Feb 09:53 am CST\",\n" +
                "\t\"productionCenter\":\"Birmingham, AL\",\n" +
                "\t\"credit\":\"http://www.srh.noaa.gov/bmx\",\n" +
                "\t\"moreInformation\":\"http://weather.gov\",\n" +
                "\t\"location\":{\n" +
                "\t\t\"region\":\"srh\",\n" +
                "\t\t\"latitude\":\"33.21\",\n" +
                "\t\t\"longitude\":\"-87.54\",\n" +
                "\t\t\"elevation\":\"276\",\n" +
                "\t\t\"wfo\":\"BMX\",\n" +
                "\t\t\"timezone\":\"C|Y|6\",\n" +
                "\t\t\"areaDescription\":\"2 Miles S Tuscaloosa AL\",\n" +
                "\t\t\"radar\":\"KBMX\",\n" +
                "\t\t\"zone\":\"ALZ023\",\n" +
                "\t\t\"county\":\"ALC125\",\n" +
                "\t\t\"firezone\":\"ALZ023\",\n" +
                "\t\t\"metar\":\"KTCL\"\n" +
                "},\n" +
                "\t\"time\":{\n" +
                "\t\t\"layoutKey\":\"k-p12h-n13-1\",\n" +
                "\t\t\"startPeriodName\":[\n" +
                "\t\t\t\"Today\",\n" +
                "\t\t\t\"Tonight\",\n" +
                "\t\t\t\"Friday\",\n" +
                "\t\t\t\"Friday Night\",\n" +
                "\t\t\t\"Saturday\",\n" +
                "\t\t\t\"Saturday Night\",\n" +
                "\t\t\t\"Sunday\",\n" +
                "\t\t\t\"Sunday Night\",\n" +
                "\t\t\t\"Monday\",\n" +
                "\t\t\t\"Monday Night\",\n" +
                "\t\t\t\"Tuesday\",\n" +
                "\t\t\t\"Tuesday Night\",\n" +
                "\t\t\t\"Wednesday\"\n" +
                "\t\t],\n" +
                "\t\t\"startValidTime\":[\n" +
                "\t\t\t\"2017-02-02T10:00:00-06:00\",\n" +
                "\t\t\t\"2017-02-02T18:00:00-06:00\",\n" +
                "\t\t\t\"2017-02-03T06:00:00-06:00\",\n" +
                "\t\t\t\"2017-02-03T18:00:00-06:00\",\n" +
                "\t\t\t\"2017-02-04T06:00:00-06:00\",\n" +
                "\t\t\t\"2017-02-04T18:00:00-06:00\",\n" +
                "\t\t\t\"2017-02-05T06:00:00-06:00\",\n" +
                "\t\t\t\"2017-02-05T18:00:00-06:00\",\n" +
                "\t\t\t\"2017-02-06T06:00:00-06:00\",\n" +
                "\t\t\t\"2017-02-06T18:00:00-06:00\",\n" +
                "\t\t\t\"2017-02-07T06:00:00-06:00\",\n" +
                "\t\t\t\"2017-02-07T18:00:00-06:00\",\n" +
                "\t\t\t\"2017-02-08T06:00:00-06:00\"\n" +
                "\t\t],\n" +
                "\t\t\"tempLabel\":[\"High\",\"Low\",\"High\",\"Low\",\"High\",\"Low\",\"High\",\"Low\",\"High\",\"Low\",\"High\",\"Low\",\"High\"]\n" +
                "\t},\n" +
                "\t\"data\":{\n" +
                "\t\t\"temperature\":[\"57\",\"43\",\"52\",\"31\",\"57\",\"42\",\"59\",\"46\",\"68\",\"57\",\"72\",\"58\",\"66\"],\n" +
                "\t\t\"pop\":[\"50\",\"40\",\"20\",null,null,\"30\",\"40\",\"20\",\"20\",\"30\",\"60\",\"50\",\"30\"],\n" +
                "\n" +
                "\t\t\"weather\":[\n" +
                "\t\t\t\"Chance Showers\",\n" +
                "\t\t\t\"Chance Showers\",\n" +
                "\t\t\t\"Slight Chance Showers then Partly Sunny\",\n" +
                "\t\t\t\"Partly Cloudy\",\n" +
                "\t\t\t\"Sunny\",\n" +
                "\t\t\t\"Chance Showers\",\n" +
                "\t\t\t\"Chance Showers\",\n" +
                "\t\t\t\"Slight Chance Showers\",\n" +
                "\t\t\t\"Slight Chance Showers\",\n" +
                "\t\t\t\"Chance Showers\",\n" +
                "\t\t\t\"T-storms Likely\",\n" +
                "\t\t\t\"Chance T-storms\",\n" +
                "\t\t\t\"Chance T-storms\"\n" +
                "\t\t\t],\n" +
                "\t\t\"iconLink\":[\n" +
                "\t\t\t\"http://forecast.weather.gov/newimages/medium/shra50.png\",\n" +
                "\t\t\t\"http://forecast.weather.gov/newimages/medium/nshra40.png\",\n" +
                "            \"http://forecast.weather.gov/DualImage.php?i=shra&j=bkn&ip=20\",\n" +
                "\t\t\t\"http://forecast.weather.gov/newimages/medium/nsct.png\",\n" +
                "\t\t\t\"http://forecast.weather.gov/newimages/medium/few.png\",\n" +
                "\t\t\t\"http://forecast.weather.gov/newimages/medium/nshra30.png\",\n" +
                "\t\t\t\"http://forecast.weather.gov/newimages/medium/shra40.png\",\n" +
                "\t\t\t\"http://forecast.weather.gov/newimages/medium/nshra20.png\",\n" +
                "\t\t\t\"http://forecast.weather.gov/newimages/medium/shra20.png\",\n" +
                "\t\t\t\"http://forecast.weather.gov/newimages/medium/nshra30.png\",\n" +
                "\t\t\t\"http://forecast.weather.gov/newimages/medium/tsra60.png\",\n" +
                "\t\t\t\"http://forecast.weather.gov/newimages/medium/ntsra50.png\",\n" +
                "\t\t\t\"http://forecast.weather.gov/newimages/medium/scttsra30.png\"\n" +
                "\t\t\t],\n" +
                "\t\t\"hazard\":[\n" +
                "\t\t\t\"Hazardous Weather Outlook\"\n" +
                "\t\t\t],\n" +
                "\t\t\"hazardUrl\":[\n" +
                "\t\t\t\"http://forecast.weather.gov/showsigwx.php?warnzone=ALZ023&amp;warncounty=ALC125&amp;firewxzone=ALZ023&amp;local_place1=2+Miles+S+Tuscaloosa+AL&amp;product1=Hazardous+Weather+Outlook\"\n" +
                "\t\t\t],\n" +
                "\t\t\"text\":[\n" +
                "\t\t\t\"A 50 percent chance of showers.  Mostly cloudy, with a temperature falling to around 50 by 5pm. North wind 5 to 10 mph.  New precipitation amounts of less than a tenth of an inch possible. \",\n" +
                "\t\t\t\"A 40 percent chance of showers.  Cloudy, with a low around 43. North wind around 5 mph. \",\n" +
                "\t\t\t\"A 20 percent chance of showers before 10am.  Mostly cloudy, with a high near 52. North wind 5 to 10 mph. \",\n" +
                "\t\t\t\"Partly cloudy, with a low around 31. North wind around 5 mph. \",\n" +
                "\t\t\t\"Sunny, with a high near 57. Northeast wind around 5 mph becoming southeast in the afternoon. \",\n" +
                "\t\t\t\"A 30 percent chance of showers.  Increasing clouds, with a low around 42.\",\n" +
                "\t\t\t\"A 40 percent chance of showers.  Mostly cloudy, with a high near 59.\",\n" +
                "\t\t\t\"A 20 percent chance of showers.  Mostly cloudy, with a low around 46.\",\n" +
                "\t\t\t\"A 20 percent chance of showers.  Partly sunny, with a high near 68.\",\n" +
                "\t\t\t\"A 30 percent chance of showers.  Mostly cloudy, with a low around 57.\",\n" +
                "\t\t\t\"Showers and thunderstorms likely.  Cloudy, with a high near 72. Chance of precipitation is 60%.\",\n" +
                "\t\t\t\"A 50 percent chance of showers and thunderstorms.  Mostly cloudy, with a low around 58.\",\n" +
                "\t\t\t\"A 30 percent chance of showers and thunderstorms.  Partly sunny, with a high near 66.\"\t\t\t]\n" +
                "\t\t},\n" +
                "\t\t\"currentobservation\":{\n" +
                "\t\t\t\"id\":\"KTCL\",\n" +
                "\t\t\t\"name\":\"Tuscaloosa Regional Airport\",\n" +
                "\t\t\t\"elev\":\"154\",\n" +
                "\t\t\t\"latitude\":\"33.21\",\n" +
                "\t\t\t\"longitude\":\"-87.62\",\n" +
                "\t\t\t\"Date\":\"2 Feb 09:53 am CST\",\n" +
                "\t\t\t\"Temp\":\"54\",\n" +
                "\t\t\t\"Dewp\":\"52\",\n" +
                "\t\t\t\"Relh\":\"93\",\n" +
                "\t\t\t\"Winds\":\"12\",\n" +
                "\t\t\t\"Windd\":\"40\",\n" +
                "\t\t\t\"Gust\":\"0\",\n" +
                "\t\t\t\"Weather\":\"Overcast\",\n" +
                "\t\t\t\"Weatherimage\":\"ovc.png\",\n" +
                "\t\t\t\"Visibility\":\"8.00\",\n" +
                "\t\t\t\"Altimeter\":\"1024.0\",\n" +
                "\t\t\t\"SLP\":\"30.24\",\n" +
                "\t\t\t\"timezone\":\"CST\",\n" +
                "\t\t\t\"state\":\"AL\",\n" +
                "\t\t\t\"WindChill\":\"NA\"\n" +
                "\t\t}\n" +
                "\t}\n" +
                "\t"
        return Gson().fromJson(json, WeatherForecast::class.java)
    }
}


