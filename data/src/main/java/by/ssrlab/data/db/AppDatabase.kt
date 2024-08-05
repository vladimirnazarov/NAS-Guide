package by.ssrlab.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import by.ssrlab.data.data.dao.DevelopmentLocaleDao
import by.ssrlab.data.data.dao.EventLocaleDao
import by.ssrlab.data.data.dao.OrganizationLocaleDao
import by.ssrlab.data.data.dao.PersonLocaleDao
import by.ssrlab.data.data.dao.PlaceLocaleDao
import by.ssrlab.data.data.local.DepartmentFilterEntity
import by.ssrlab.data.data.local.DevelopmentEntity
import by.ssrlab.data.data.local.EventEntity
import by.ssrlab.data.data.local.ImageEntity
import by.ssrlab.data.data.local.LanguageEntity
import by.ssrlab.data.data.local.OrganizationEntity
import by.ssrlab.data.data.local.PersonEntity
import by.ssrlab.data.data.local.PlaceEntity
import by.ssrlab.data.data.settings.locale.DevelopmentLocaleEntity
import by.ssrlab.data.data.settings.locale.EventLocaleEntity
import by.ssrlab.data.data.settings.locale.OrganizationLocaleEntity
import by.ssrlab.data.data.settings.locale.PersonLocaleEntity
import by.ssrlab.data.data.settings.locale.PlaceLocaleEntity

@Database(
    entities = [DevelopmentLocaleEntity::class, EventLocaleEntity::class,
        OrganizationLocaleEntity::class, PersonLocaleEntity::class, PlaceLocaleEntity::class,
        DepartmentFilterEntity::class, DevelopmentEntity::class, EventEntity::class, ImageEntity::class,
        LanguageEntity::class, OrganizationEntity::class, PersonEntity::class, PlaceEntity::class
    ],
    version = 1
)
@TypeConverters(by.ssrlab.data.db.utils.TypeConverters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract val developmentLocaleDao: DevelopmentLocaleDao
    abstract val eventLocaleDao: EventLocaleDao
    abstract val organizationLocaleDao: OrganizationLocaleDao
    abstract val personLocaleDao: PersonLocaleDao
    abstract val placeLocaleDao: PlaceLocaleDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}