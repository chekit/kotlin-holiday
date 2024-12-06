package com.travel.kotlin_holiday.data

import com.fasterxml.jackson.databind.ObjectMapper
import com.travel.kotlin_holiday.models.Holiday
import java.io.File
import java.nio.file.Paths
import kotlin.properties.Delegates

class FsHolidaysRepository(val mapper: ObjectMapper, val filename: String) : HolidaysRepositoryBase {
    private var currentId by Delegates.notNull<Long>();

    val file: File by lazy {
        Paths.get("src/main/resources/$filename").toFile();
    }

    val holidays: MutableList<Holiday> by lazy {
        if (file.exists()) {
            mapper.readValue(file, Array<Holiday>::class.java).toList().toMutableList();
        } else {
            mutableListOf();
        }
    }

    override fun findAll(): MutableList<Holiday> {
        return holidays;
    }

    override fun find(id: Long): Holiday? {
        return holidays.find { it.id == id };
    }

    override fun add(name: String) {
        currentId = holidays.size.toLong();
        val holiday = Holiday(++currentId, name, "-");
        holidays.add(holiday);

        mapper.writeValue(file, holidays);
    }

    override fun remove(id: Long) {
        holidays.removeIf { it.id == id };

        mapper.writeValue(file, holidays);
    }
}