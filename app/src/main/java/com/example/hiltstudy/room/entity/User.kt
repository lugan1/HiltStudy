package com.example.hiltstudy.room.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    val name: String,

    @Embedded(prefix = "home_")
    val homeAddress: Address?,

    @Embedded(prefix = "work_")
    val workAddress: Address?
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}
