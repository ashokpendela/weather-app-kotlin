package com.weather.controller

import com.weather.modal.WeatherApiResponse
import com.weather.modal.WeatherData
import com.weather.modal.WeatherResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/weather")
class WeatherController {

    private val webClient = WebClient.builder()
        .baseUrl("https://api.weather.gov/gridpoints/MLB/33,70/forecast")
        .build()

    @GetMapping("/current")
    fun getCurrentWeather(): Mono<WeatherApiResponse> {
       return webClient
           .get()
           .retrieve()
           .bodyToMono(WeatherResponse::class.java)
           .map { transformResponse(it) }
    }

    private fun transformResponse(apiResponse: WeatherResponse): WeatherApiResponse {
        println("Filtered response $apiResponse")
        var periods = mutableListOf<WeatherData>()
        for (period in apiResponse.properties.periods) {
            val dayName = period.name
            val tempHighCelsius = fahrenheitToCelsius(period.temperature)
            val forecastBlurp = period.shortForecast
            val transformedData = WeatherData(dayName, tempHighCelsius, forecastBlurp)
            periods.add(transformedData)
        }
        return WeatherApiResponse(periods)
    }
    private fun fahrenheitToCelsius(fahrenheit: Double): Double {
        // Conversion formula: (°F - 32) * 5/9
        return (fahrenheit - 32) * 5 / 9
    }
}
