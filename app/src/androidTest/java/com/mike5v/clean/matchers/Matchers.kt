package com.mike5v.clean.matchers

import android.view.View
import android.widget.ImageView
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher

fun isImageLoaded(): Matcher<View> {

    return object : TypeSafeMatcher<View>() {
        override fun describeTo(description: org.hamcrest.Description?) {
            description?.appendText("imageview should have an image")
        }

        override fun matchesSafely(item: View?): Boolean {
            return (item as? ImageView)?.drawable != null
        }
    }
}