package com.travel.kotlin_holiday.controllers

import com.travel.kotlin_holiday.business.HolidaysService
import com.travel.kotlin_holiday.models.Holiday
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/holidays")
class HolidaysController(val service: HolidaysService) {
    @GetMapping
    fun findAll(): MutableList<Holiday> {
        return service.findAll();
    }

    @GetMapping("{id}")
    fun findOne(@PathVariable("id") id: Long): Holiday? {
        return service.findById(id);
    }

    @PostMapping("{name}")
    fun addOne(@PathVariable("name") name: String): Unit {
        service.addHoliday(name)
    }

    @DeleteMapping("{id}")
    fun deleteOne(@PathVariable("id") id: Long): Unit {
        service.deleteHoliday(id)
    }
}