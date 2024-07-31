package by.ssrlab.data.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import by.ssrlab.data.data.settings.locale.PlaceLocaleEntity

@Dao
interface PlaceLocaleDao {

    @Query("SELECT * FROM PlaceLocaleEntity")
    fun getPlaceLocaleList(): List<PlaceLocaleEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPlaceLocale(placeLocale: PlaceLocaleEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPlaceLocaleList(placeLocaleList: List<PlaceLocaleEntity>)

    @Query("DELETE FROM PlaceLocaleEntity")
    fun deleteAllPlaceLocale()
}