package com.mike5v.clean

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mike5v.api.RetrofitCatsApi
import com.mike5v.data.CatsRepository
import com.mike5v.domain.CatsUseCase
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val api = RetrofitCatsApi()
    private val repository = CatsRepository(api)
    private val useCase = CatsUseCase(repository)

    private val mutableSuccess = MutableLiveData<String>()
    val success: LiveData<String>
        get() = mutableSuccess

    fun fetch() {
        viewModelScope.launch {
            mutableSuccess.postValue(useCase.getCatUrlImage())
        }
    }
}