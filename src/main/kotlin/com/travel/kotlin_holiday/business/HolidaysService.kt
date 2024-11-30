package com.travel.kotlin_holiday.business

import com.travel.kotlin_holiday.data.HolidaysRepository
import com.travel.kotlin_holiday.models.Holiday
import org.springframework.stereotype.Service

@Service
class HolidaysService(val repository: HolidaysRepository) {
    fun findAll(): MutableList<Holiday> {
        return repository.findAll()
    }

    fun findById(id: Long): Holiday? {
        return repository.find(id);
    }

    fun addHoliday(name: String): Unit {
        repository.add(name);
    }

    fun deleteHoliday(id: Long): Unit {
        repository.remove(id);
    }
}