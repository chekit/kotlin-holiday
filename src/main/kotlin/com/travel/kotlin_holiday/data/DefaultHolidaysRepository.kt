package com.travel.kotlin_holiday.data

import com.travel.kotlin_holiday.models.Holiday

class DefaultHolidaysRepository: HolidaysRepositoryBase {
    private var currentId = 3L;

    private var holidays: MutableList<Holiday> = mutableListOf(
        Holiday(1L, "Canada", "Visit Rocky Mountains"),
        Holiday(2L, "China", "To the Middle Kingdom")
    );

    override fun findAll(): MutableList<Holiday> {
        return holidays;
    }

    override fun find(id: Long): Holiday? {
        return holidays.find { it.id == id };
    }

    override fun add(name: String): Unit {
        val holiday = Holiday(currentId++, name, "-");
        holidays.add(holiday);
    }

    override fun remove(id: Long): Unit {
        holidays.removeIf { it -> it.id == id };
    }
}