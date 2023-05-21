package com.example.hiltstudy.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "library",
    foreignKeys = [
        ForeignKey(entity = User::class,
            parentColumns = ["id"],
            childColumns = ["user_id"],
            onDelete = ForeignKey.CASCADE)
    ])
data class Library(
    @ColumnInfo(name = "user_id")
    var userId: Long
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}
