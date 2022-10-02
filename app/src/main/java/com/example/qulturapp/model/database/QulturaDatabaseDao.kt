package com.example.qulturapp.model.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface QulturaDatabaseDao {
    @Insert
    suspend fun insertMuseo(museoR: MuseoR)

    @Query("SELECT * from museos_table")
    fun getAllMuseos(): LiveData<List<MuseoR>>

    @Query("DELETE FROM museos_table")
    fun clearMuseos()

    @Insert
    suspend fun insertGuia(guiaR: GuiaR)

    @Query("SELECT * from guias_table")
    fun getAllGuias(): LiveData<List<GuiaR>>

    @Query("DELETE FROM guias_table")
    fun clearGuias()

    @Insert
    suspend fun insertObra(obraR: ObraR)

    @Query("SELECT * from obras_table")
    fun getAllObras(): LiveData<List<ObraR>>

    @Query("DELETE FROM obras_table")
    fun clearObras()

    @Insert
    suspend fun insertSala(salaR: SalaR)

    @Query("SELECT * from salas_table")
    fun getAllSalas(): LiveData<List<SalaR>>

    @Query("DELETE FROM salas_table")
    fun clearSalas()
}