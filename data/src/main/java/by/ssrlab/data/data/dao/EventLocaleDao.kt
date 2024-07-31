package by.ssrlab.data.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import by.ssrlab.data.data.settings.locale.EventLocaleEntity

@Dao
interface EventLocaleDao {

    @Query("SELECT * FROM EventLocaleEntity")
    fun getEventLocaleList(): List<EventLocaleEntity>

    @Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    suspend fun insertEventLocale(eventLocaleEntity: EventLocaleEntity)

    @Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    suspend fun insertEventLocaleList(eventLocaleEntityList: List<EventLocaleEntity>)

//    @Query("SELECT * FROM EventEntity WHERE startDate = :startDate AND endDate = :endDate")
//    fun getEventLocale(startDate: String, endDate: String): EventLocaleEntity

    @Query("SELECT * FROM EventEntity WHERE (startDate BETWEEN :startDate AND :endDate) AND (endDate BETWEEN :startDate AND :endDate)")
    fun getEventLocaleByDate(startDate: String, endDate: String): EventLocaleEntity

    @Query("DELETE FROM EventLocaleEntity")
    suspend fun clearAllEventLocale()
}