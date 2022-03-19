package com.example.gdgsampleandroid.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gdgsampleandroid.di.FirstRepo
import com.example.gdgsampleandroid.useCase.SelectString
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BlankViewModel @Inject constructor(
    private val selectStringUseCase: SelectString,
): ViewModel() {
    private val TAG = this.javaClass.name

    private val _apiRequestData = MutableLiveData<String>()
    val apiRequestData:LiveData<String> = _apiRequestData

    fun getString(input:String){
        //todo get string and update ui
        viewModelScope.launch {
            val result = selectStringUseCase(input)
            Log.d(TAG, result)
            _apiRequestData.postValue(result)
        }
    }
}