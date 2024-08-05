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

    @Query("""
        SELECT
            el.pk AS pk,
            el.eventEntityPk AS eventEntityPk,
            el.about AS about,
            el.name AS name,
            l.id AS language_id,
            l.languageKey AS language_languageKey,
            l.languageName AS language_languageName
        FROM EventLocaleEntity el
        INNER JOIN EventEntity e ON e.pk = el.eventEntityPk
        INNER JOIN LanguageEntity l ON el.language_id = l.id
        WHERE e.startDate = :startDate
        """)
    fun getEventLocaleByDate(startDate: String): EventLocaleEntity

    @Query("DELETE FROM EventLocaleEntity")
    suspend fun clearAllEventLocale()
}