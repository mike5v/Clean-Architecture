package com.mike5v.api.utils

import okhttp3.mockwebserver.MockResponse

object Response {

    @Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
    fun loadJson(name: String) = javaClass.classLoader
        .getResourceAsStream("$name.json")
        .readBytes()
        .toString(Charsets.UTF_8)

    fun createResponseWthBody(code: Int, body: String) = MockResponse()
        .setResponseCode(code)
        .setBody(body)
}