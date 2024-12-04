package com.travel.kotlin_holiday.data

import com.travel.kotlin_holiday.models.Holiday

interface HolidaysRepositoryBase {
    fun findAll(): MutableList<Holiday>;

    fun find(id: Long): Holiday?;

   fun add(name: String): Unit;

   fun remove(id: Long): Unit;
}