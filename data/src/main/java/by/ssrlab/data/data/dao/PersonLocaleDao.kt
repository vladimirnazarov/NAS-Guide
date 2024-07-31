package by.ssrlab.data.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import by.ssrlab.data.data.settings.locale.PersonLocaleEntity

@Dao
interface PersonLocaleDao {

    @Query("SELECT * FROM PersonLocaleEntity")
    fun getPersonLocaleList(): List<PersonLocaleEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPersonLocale(personLocale: PersonLocaleEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPersonLocaleList(personLocaleList: List<PersonLocaleEntity>)

    @Query("DELETE FROM PersonLocaleEntity")
    fun deleteAllPersonLocale()
}