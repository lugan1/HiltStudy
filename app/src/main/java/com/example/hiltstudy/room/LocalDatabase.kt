package com.example.hiltstudy.room

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.hiltstudy.room.dao.LibraryDao
import com.example.hiltstudy.room.dao.UserAndLibraryDao
import com.example.hiltstudy.room.dao.UserDao
import com.example.hiltstudy.room.entity.Library
import com.example.hiltstudy.room.entity.User

//version: 데이터베이스 스키마가 변경,수정 될때마다 올려야된다.
//entities: 사용된 entity 클래스들을 작성한다.
@Database(version = 1, entities = [User::class, Library::class])
abstract class LocalDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun libraryDao(): LibraryDao
    abstract fun userAndLibraryDao(): UserAndLibraryDao

    //데이터베이스는 생성시 많은 비용이 발생하므로 앱 전역에서 사용할 수 있는 싱글톤 패턴으로 생성한다.
    companion object {
        @Volatile
        private var INSTANCE: LocalDatabase? = null

        fun getDatabase(context: Context): LocalDatabase {
            //INSTANCE 가 존재하면 INSTANCE 리턴, 없으면 databaseBuilder 로 DB 생성후 리턴
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(context.applicationContext, LocalDatabase::class.java, "room_db")
                    .fallbackToDestructiveMigration() //데이터 베이스 버전(스키마)가 변경되면, 마이그레이션을 해야되는데, 마이그레이션 실패시 IllegalException 보다는 DB를 삭제후 재생성한다.
                    .build()

                INSTANCE = instance
                instance
            }
        }
    }
}