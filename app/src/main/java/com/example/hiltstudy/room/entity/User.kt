package com.example.hiltstudy.room.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    val name: String,

    @Embedded
    val address: Address?
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "user_id")
    var id: Long = 0
}
