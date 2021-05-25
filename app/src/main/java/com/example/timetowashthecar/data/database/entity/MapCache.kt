package com.example.timetowashthecar.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "map_cache")
class MapCache (
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "lon")
    val lon: Double,
    @ColumnInfo(name = "lat")
    val lat: Double,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "rate")
    val rate:Double,
    @ColumnInfo(name = "city")
    val city:String,
    @ColumnInfo(name = "country")
    var country:String,
    @ColumnInfo(name="address")
    val address: String
) {

}