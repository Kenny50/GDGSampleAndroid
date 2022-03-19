package com.example.gdgsampleandroid.useCase

import android.util.Log
import com.example.gdgsampleandroid.di.Cache
import com.example.gdgsampleandroid.di.FirstRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SelectString @Inject constructor(
    private val repo: FirstRepo,
    private val cache: Cache
) {
    private val TAG = this.javaClass.name

    suspend operator fun invoke(key: String): String {
        //todo get data either from cache, or from remote
        return ""

    }
}