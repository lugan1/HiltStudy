package com.example.hiltstudy.room.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.hiltstudy.room.entity.Library
import com.example.hiltstudy.room.entity.User
import kotlinx.coroutines.flow.Flow

@Dao
interface LibraryDao: BaseDao<Library> {
    @Query("SELECT * FROM library")
    fun getAllData(): Flow<List<Library>>
}