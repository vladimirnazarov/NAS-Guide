package by.ssrlab.data.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import by.ssrlab.data.data.settings.locale.OrganizationLocaleEntity

@Dao
interface OrganizationLocaleDao {

    @Query("SELECT * FROM OrganizationLocaleEntity")
    fun getOrganizationLocaleList(): List<OrganizationLocaleEntity>

    @Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    suspend fun insertOrganizationLocale(organizationLocaleEntity: OrganizationLocaleEntity)

    @Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    suspend fun insertOrganizationLocaleList(organizationLocaleEntityList: List<OrganizationLocaleEntity>)

    @Query("DELETE FROM OrganizationLocaleEntity")
    suspend fun clearAllOrganizationLocale()
}