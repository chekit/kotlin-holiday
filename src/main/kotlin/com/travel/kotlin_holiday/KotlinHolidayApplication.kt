package com.travel.kotlin_holiday

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@ConfigurationPropertiesScan
@SpringBootApplication
class KotlinHolidayApplication

fun main(args: Array<String>) {
	runApplication<KotlinHolidayApplication>(*args)
}
