package by.ssrlab.data.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import by.ssrlab.data.data.settings.locale.DevelopmentLocaleEntity

@Dao
interface DevelopmentLocaleDao {

    @Query("SELECT * FROM DevelopmentLocaleEntity")
    fun getDevelopmentLocaleList(): List<DevelopmentLocaleEntity>

    @Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    suspend fun insertDevelopmentLocale(developmentLocaleEntity: DevelopmentLocaleEntity)

    @Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    suspend fun insertDevelopmentLocaleList(developmentLocaleEntityList: List<DevelopmentLocaleEntity>)

    @Query("DELETE FROM DevelopmentLocaleEntity")
    suspend fun clearAllDevelopmentLocale()
}