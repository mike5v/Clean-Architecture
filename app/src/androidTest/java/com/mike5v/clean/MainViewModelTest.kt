package com.mike5v.clean

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import assertk.assert
import assertk.assertions.isEqualTo
import com.mike5v.clean.utils.extensions.getOrAwaitValue
import com.mike5v.clean.vm.MainViewModel
import com.mike5v.data.CatsRepository
import dagger.hilt.android.testing.BindValue
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import io.mockk.coEvery
import io.mockk.mockk
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class MainViewModelTest {

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @BindValue
    val repository: CatsRepository = mockk()

    private val viewModel = MainViewModel(repository)

    @Test
    fun verifySuccessLiveData() {
        coEvery { repository.getCatUrlImage() } returns "https://static.toiimg.com/thumb/msid-67586673,width-800,height-600,resizemode-75,imgsize-3918697,pt-32,y_pad-40/67586673.jpg"

        viewModel.fetch()
        viewModel.success.getOrAwaitValue()

        assert(viewModel.success.value).isEqualTo("https://static.toiimg.com/thumb/msid-67586673,width-800,height-600,resizemode-75,imgsize-3918697,pt-32,y_pad-40/67586673.jpg")
    }
}