package com.example.hiltstudy.workManager

import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.hiltstudy.room.dao.LibraryDao
import com.example.hiltstudy.room.dao.UserAndLibraryDao
import com.example.hiltstudy.room.dao.UserDao
import com.example.hiltstudy.room.entity.Address
import com.example.hiltstudy.room.entity.Library
import com.example.hiltstudy.room.entity.User
import com.example.hiltstudy.room.relation.UserAndLibrary
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@HiltWorker
class DatabaseWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted workerParams: WorkerParameters,
    private val userDao: UserDao,
    private val libraryDao: LibraryDao,
    private val userAndLibraryDao: UserAndLibraryDao)
    : Worker(context, workerParams) {
    @OptIn(DelicateCoroutinesApi::class)
    override fun doWork(): Result {
        Log.d("ROOMTEST", "테스트 시작")

        GlobalScope.launch(Dispatchers.IO) {
        }

        return Result.success()
    }

    suspend fun test() {
        val homeAddress = Address(street = "송파구", state = "B01호", city = "서울", postCode = 103)
        val workAddress = Address(street = "강남구", state = "301호", city = "서울", postCode = 1001)
        val user = User("leehoogy", homeAddress, workAddress)

        val library = Library("music")
        userAndLibraryDao.insertUserAndLibrary(user, library)

        val userAndLibrary:List<UserAndLibrary> = userAndLibraryDao.getUsersAndLibraries()
    }

    suspend fun test2() {
        val library = Library("music")
        val userAndLibrary = userAndLibraryDao.getUsersAndLibraries().first()
        userAndLibrary.library = library
        userAndLibraryDao.insert(userAndLibrary)
    }
}