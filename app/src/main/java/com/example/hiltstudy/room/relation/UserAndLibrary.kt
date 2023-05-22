package com.example.hiltstudy.room.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.example.hiltstudy.room.entity.Library
import com.example.hiltstudy.room.entity.User

data class UserAndLibrary(
    @Embedded val user: User,

    @Relation(
        entity = Library::class,
        parentColumn = "id",
        entityColumn = "user_id"
    )
    var library: Library?
)
