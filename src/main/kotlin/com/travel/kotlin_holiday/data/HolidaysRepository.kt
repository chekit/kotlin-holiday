package com.travel.kotlin_holiday.data

import com.travel.kotlin_holiday.models.Holiday
import org.springframework.stereotype.Service

@Service
class HolidaysRepository {
    private var currentId = 3L;

    private var holidays: MutableList<Holiday> = mutableListOf(
        Holiday(1L, "Canada", "Visit Rocky Mountains"),
        Holiday(2L, "China", "To the Middle Kingdom")
    );

    fun findAll(): MutableList<Holiday> {
        return holidays;
    }

    fun find(id: Long): Holiday? {
        return holidays.find { it.id == id };
    }

    fun add(name: String): Unit {
        val holiday = Holiday(currentId++, name, "-");
        holidays.add(holiday);
    }

    fun remove(id: Long): Unit {
        holidays.removeIf { it -> it.id == id };
    }
}