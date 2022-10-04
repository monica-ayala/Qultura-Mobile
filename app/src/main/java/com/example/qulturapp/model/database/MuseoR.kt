package com.example.qulturapp.model.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "museos_table")
data class MuseoR(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_museo")
    var id_museo: Int = 0,

    @ColumnInfo(name = "nom_museo")
    val nom_museo: String = "",

    @ColumnInfo(name = "desc_museo")
    val desc_museo: String = "",

    @ColumnInfo(name = "ubicacion_museo")
    val ubicacion_museo: String = "",

    @ColumnInfo(name = "link_ubi")
    val link_ubi: String = "",

    @ColumnInfo(name = "num_museo")
    val num_museo: String = "",

    @ColumnInfo(name = "imgP_museo")
    val imgP_museo: String = "",

    @ColumnInfo(name = "imgB_museo")
    val imgB_museo: String = "",

    @ColumnInfo(name = "status")
    val status: Int = 0,
)
