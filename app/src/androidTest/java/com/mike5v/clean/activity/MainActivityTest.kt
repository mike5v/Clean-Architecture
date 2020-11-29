package com.mike5v.clean.activity

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.mike5v.clean.MainActivity
import com.mike5v.clean.R
import com.mike5v.data.CatsRepository
import dagger.hilt.android.testing.BindValue
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import io.mockk.coEvery
import io.mockk.mockk
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class MainActivityTest {

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @BindValue
    val repository: CatsRepository = mockk()

    @Test
    fun changeCatImageOnButtonClik() {
        coEvery { repository.getCatUrlImage() } returns "https://static.toiimg.com/thumb/msid-67586673,width-800,height-600,resizemode-75,imgsize-3918697,pt-32,y_pad-40/67586673.jpg"

        ActivityScenario.launch(MainActivity::class.java)

        coEvery { repository.getCatUrlImage() } returns "https://images.theconversation.com/files/350865/original/file-20200803-24-50u91u.jpg?ixlib=rb-1.1.0&q=45&auto=format&w=1200&h=1200.0&fit=crop"

        onView(withId(R.id.button)).perform(ViewActions.click())

    }
}