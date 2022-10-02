package com.example.qulturapp.model.database

import android.content.Context
import androidx.room.Room
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class DbUtil(private val context: Context) {
    private lateinit var db: QulturaDatabase

    fun initRoomDatabase(){
        db = Room.databaseBuilder(
            context,
            QulturaDatabase::class.java, "qultura-db"
        ).build()

        val qulturaDao = db.qulturaDatabaseDao

        CoroutineScope(IO).launch {
            qulturaDao.clearMuseos()
            qulturaDao.clearGuias()
            qulturaDao.clearObras()
            qulturaDao.clearSalas()
        }
    }

}