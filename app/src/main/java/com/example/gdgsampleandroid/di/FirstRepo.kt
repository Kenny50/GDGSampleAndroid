package com.example.gdgsampleandroid.di

import android.util.Log
import com.example.gdgsampleandroid.dto.Post
import kotlinx.coroutines.delay
import retrofit2.http.GET
import retrofit2.http.Path
import javax.inject.Inject

class FirstRepo @Inject constructor(
    val api:CallI
) {
    private val TAG = this.javaClass.name

    suspend fun callMe(input:String): Post {
        return api.hello(input.hashCodeModTen())
    }

    private fun String.hashCodeModTen() = this.hashCode().mod(10) + 1

    suspend fun callWhenLeavePage(){
        Log.d(TAG,"before delay")
        delay(1000)
        Log.d(TAG,"after delay")
    }
}

interface CallI{

    @GET("posts/{count}")
    suspend fun hello(@Path("count") count:Int):Post
}