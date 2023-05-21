package com.example.hiltstudy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.example.hiltstudy.workManager.TestWorker
import com.example.hiltstudy.databinding.ActivityMainBinding
import com.example.hiltstudy.room.LocalDatabase
import com.example.hiltstudy.workManager.DatabaseWorker
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.testButton.setOnClickListener {
            WorkManager.getInstance(this)
                .beginUniqueWork("TEST", ExistingWorkPolicy.KEEP, OneTimeWorkRequest.Companion.from(DatabaseWorker::class.java))
                .enqueue()
        }
    }

}