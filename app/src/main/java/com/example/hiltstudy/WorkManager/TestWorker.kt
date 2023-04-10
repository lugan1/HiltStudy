package com.example.hiltstudy.WorkManager

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.hiltstudy.Di.TestDependency
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

@HiltWorker
class TestWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted workerParams: WorkerParameters,
    private val testDependency: TestDependency
) : Worker(context, workerParams) {
    override fun doWork(): Result {
        testDependency.foo()
        return Result.success()
    }
}