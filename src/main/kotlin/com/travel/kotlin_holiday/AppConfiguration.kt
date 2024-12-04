package com.travel.kotlin_holiday

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.travel.kotlin_holiday.data.DefaultHolidaysRepository
import com.travel.kotlin_holiday.data.FsHolidaysRepository
import com.travel.kotlin_holiday.data.HolidaysRepositoryBase
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfiguration {
    @Value("\${app.holidays.persistence-type}")
    private lateinit var type: String;

    @Value("\${app.holidays.persistence-file}")
    private lateinit var filename: String;


    @Bean
    fun repositoryConfigurer(): HolidaysRepositoryBase {
        if (type == "file") {
            return if (filename.isNotEmpty()) FsHolidaysRepository(jacksonObjectMapper(), filename)
                        else FsHolidaysRepository(jacksonObjectMapper())
        } else {
            return DefaultHolidaysRepository();
        }
    }
}