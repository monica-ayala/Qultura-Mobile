package com.example.qulturapp.model.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface QulturaDatabaseDao {
    @Insert
    suspend fun insertMuseo(museoR: MuseoR)

    @Query("SELECT * from museos_table")
    fun getAllMuseos(): LiveData<List<MuseoR>>

    @Insert
    suspend fun insertGuia(guiaR: GuiaR)

    @Query("SELECT * from guias_table")
    fun getAllGuias(): LiveData<List<GuiaR>>

    @Insert
    suspend fun insertObra(obraR: ObraR)

    @Query("SELECT * from obras_table")
    fun getAllObras(): LiveData<List<ObraR>>

    @Insert
    suspend fun insertSala(salaR: SalaR)

    @Query("SELECT * from salas_table")
    fun getAllSalas(): LiveData<List<SalaR>>
}