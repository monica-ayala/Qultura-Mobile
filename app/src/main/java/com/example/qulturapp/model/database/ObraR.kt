package com.example.qulturapp.model.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "obras_table",
    foreignKeys = [ForeignKey(entity = SalaR::class,
        parentColumns = arrayOf("id_salas"),
        childColumns = arrayOf("id_sala"),
        onDelete = ForeignKey.CASCADE)]
    )
data class ObraR(
    @PrimaryKey(autoGenerate = true)
    var id_obra: Int = 0,

    @ColumnInfo(name = "nom_obra")
    val nom_obra: String = "",

    @ColumnInfo(name = "audio_obra")
    val audio_obra: String = "",

    @ColumnInfo(name = "subtitulo_obra")
    val subtitulo_obra: String = "",

    @ColumnInfo(name = "img_obra")
    val img_obra: String = "",

    @ColumnInfo(name = "fecha_obra")
    val fecha_obra: String = "",

    @ColumnInfo(name = "autor_obra")
    val autor_obra: String = "",

    @ColumnInfo(name = "desc_obra")
    val desc_obra: String = "",

    @ColumnInfo(name = "id_sala", index = true)
    val id_sala: Int = 0,
)