package com.example.hiltstudy.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.hiltstudy.room.entity.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao : BaseDao<User> {
    @Query("SELECT * FROM user")
    fun getAllData(): Flow<List<User>>
}