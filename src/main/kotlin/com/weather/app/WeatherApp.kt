package com.weather.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan("com.weather")
class WeatherApp

fun main(args: Array<String>) {
    runApplication<WeatherApp>(*args)
}
