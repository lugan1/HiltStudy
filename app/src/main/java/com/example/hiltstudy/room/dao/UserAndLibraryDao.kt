package com.example.hiltstudy.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.hiltstudy.room.entity.Library
import com.example.hiltstudy.room.entity.User
import com.example.hiltstudy.room.relation.UserAndLibrary

@Dao
interface UserAndLibraryDao {
    @Transaction
    @Query("SELECT * FROM User")
    fun getUsersAndLibraries(): List<UserAndLibrary>

    @Insert
    fun insert(user: User): Long

    @Insert
    fun insert(library: Library) : Long

    @Transaction
    fun insertUserAndLibrary(user: User, library: Library) {
        library.userId = insert(user)
        insert(library)
    }
}