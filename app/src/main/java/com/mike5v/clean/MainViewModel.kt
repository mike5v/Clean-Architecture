package com.mike5v.clean

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mike5v.api.RetrofitCatsApi
import com.mike5v.data.CatsRepository
import com.mike5v.domain.CatsUseCase
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private val api = RetrofitCatsApi()
    private val repository = CatsRepository(api)
    private val useCase = CatsUseCase(repository)

    val success = MutableLiveData<String>()

    fun fetch() {
        viewModelScope.launch {
            success.postValue(useCase.getCatUrlImage())
        }
    }
}