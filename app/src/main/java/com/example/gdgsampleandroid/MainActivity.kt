package com.example.gdgsampleandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gdgsampleandroid.presentation.FirstViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity @Inject constructor(

) : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}