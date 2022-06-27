package com.example.lugares.model

import kotlinx.android.parcel.Parcelize
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey



@Parcelize
@Entity(tableName = "lugar")
data class Lugar (
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    @ColumnInfo(name = "nombre")
    val nombre: String,
    ) : Parcelable
