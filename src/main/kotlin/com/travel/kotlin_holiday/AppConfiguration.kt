package com.travel.kotlin_holiday

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.travel.kotlin_holiday.data.DefaultHolidaysRepository
import com.travel.kotlin_holiday.data.FsHolidaysRepository
import com.travel.kotlin_holiday.data.HolidaysRepositoryBase
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@ConfigurationProperties(prefix = "app.holidays.persistence")
data class AppProperties(val type: String, val file: String = "db.json");

@Configuration
class AppConfiguration() {

    @Bean
    fun repositoryConfigurer(objectMapper: ObjectMapper, appProperties: AppProperties): HolidaysRepositoryBase {
        return if (appProperties.type == "file") {
            FsHolidaysRepository(objectMapper, appProperties.file)
        } else {
            DefaultHolidaysRepository();
        }
    }
}