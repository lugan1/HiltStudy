package com.example.hiltstudy.Room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAllData(): List<UserEntity>

    @Insert(entity = UserEntity::class, onConflict = OnConflictStrategy.ABORT)
    fun insert(vararg user: UserEntity)

    @Delete(entity = UserEntity::class)
    fun delete(vararg user: UserEntity)

    @Update(entity = UserEntity::class, onConflict = OnConflictStrategy.ABORT)
    fun update(vararg user: UserEntity)
}