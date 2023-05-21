package com.example.hiltstudy.workManager

import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.hiltstudy.room.dao.UserDao
import com.example.hiltstudy.room.entity.Address
import com.example.hiltstudy.room.entity.User
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@HiltWorker
class DatabaseWorker @AssistedInject constructor(@Assisted context: Context, @Assisted workerParams: WorkerParameters, private val userDao: UserDao)
    : Worker(context, workerParams) {
    @OptIn(DelicateCoroutinesApi::class)
    override fun doWork(): Result {
        Log.d("ROOMTEST", "테스트 시작")

        GlobalScope.launch(Dispatchers.IO) {
            val result = userDao.insert(User("leehoogy", Address(street = "송파구", state = "B01호", city = "서울", postCode = 103)))
            Log.d("ROOMTEST", "result: $result")
        }

        return Result.success()
    }
}