package com.example.qulturapp.model.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "guias_table")
data class GuiaR(
    @PrimaryKey(autoGenerate = true)
    var id_guia: Int = 0,

    @ColumnInfo(name = "video_guia")
    val video_guia: String = "",

    @ColumnInfo(name = "desc_guia")
    val desc_guia: String = "",

    @ColumnInfo(name = "icono_guia")
    val icono_guia: String = "",

    @ColumnInfo(name = "nombre_guia")
    val nombre_guia: String = "",

    @ColumnInfo(name = "tip_guia")
    val tip_guia: String = "",

    @ColumnInfo(name = "imagen_guia")
    val imagen_guia: String = "",
)
