package com.example.gdgsampleandroid.presentation

import androidx.lifecycle.ViewModel
import com.example.gdgsampleandroid.di.FirstRepo
import com.example.gdgsampleandroid.di.module.ApplicationScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FirstViewModel @Inject constructor(
    private val repo : FirstRepo,
    @ApplicationScope private val externalScope: CoroutineScope
):ViewModel() {

    override fun onCleared() {
        super.onCleared()
        externalScope.launch {
            repo.callWhenLeavePage()
            // todo call api when leave this page
        }
    }
}