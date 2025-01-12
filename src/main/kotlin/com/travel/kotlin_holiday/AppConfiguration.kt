package com.travel.kotlin_holiday

import com.fasterxml.jackson.databind.ObjectMapper
import com.travel.kotlin_holiday.data.DefaultHolidaysRepository
import com.travel.kotlin_holiday.data.FsHolidaysRepository
import com.travel.kotlin_holiday.data.HolidaysRepositoryBase
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile

@ConfigurationProperties(prefix = "app.holidays.persistence")
data class AppProperties(val type: String, val file: String = "db.json");


@Configuration
class AppConfiguration() {

    @Bean
    @Profile("!demo")
    fun fsRepositoryConfigurer(objectMapper: ObjectMapper, appProperties: AppProperties): HolidaysRepositoryBase {
        return FsHolidaysRepository(objectMapper, appProperties.file);
    }

    @Bean
    @Profile("demo")
    fun defaultRepositoryConfigurer(): HolidaysRepositoryBase {
        return DefaultHolidaysRepository();
    }
}