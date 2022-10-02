package com.example.qulturapp.model.database
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MuseoR::class, GuiaR::class, ObraR::class, SalaR::class], version = 1, exportSchema = false)
abstract class QulturaDatabase : RoomDatabase() {

    abstract val qulturaDatabaseDao: QulturaDatabaseDao

    companion object {

        @Volatile
        private var INSTANCE: QulturaDatabase? = null

        fun getInstance(context: Context): QulturaDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        QulturaDatabase::class.java,
                        "sleep_history_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}