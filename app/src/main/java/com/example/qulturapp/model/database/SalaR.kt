package com.example.qulturapp.model.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "salas_table",
    foreignKeys = [ForeignKey(entity = MuseoR::class,
        parentColumns = arrayOf("id_museo"),
        childColumns = arrayOf("id_museo_sala"),
        onDelete = ForeignKey.CASCADE)]
)
data class SalaR(
    @PrimaryKey(autoGenerate = true)
    var id_salas: Int = 0,

    @ColumnInfo(name = "nom_sala")
    val nom_sala: String = "",

    @ColumnInfo(name = "audio_sala")
    val audio_sala: String = "",

    @ColumnInfo(name = "desc_sala")
    val desc_sala: String = "",

    @ColumnInfo(name = "img_sala")
    val img_sala: String = "",

    @ColumnInfo(name = "status_sala")
    val status_sala: String = "",

    @ColumnInfo(name = "id_museo_sala", index = true)
    val id_museo_sala: Int = 0
)