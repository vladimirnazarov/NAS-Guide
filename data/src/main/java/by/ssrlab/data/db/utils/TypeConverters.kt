package by.ssrlab.data.db.utils

import androidx.room.TypeConverter

class TypeConverters {

    @TypeConverter
    fun fromStringToList(value: String) = value.split(",").map { it.trim() }

    @TypeConverter
    fun fromListToString(value: List<String>) = value.joinToString { "," }
}