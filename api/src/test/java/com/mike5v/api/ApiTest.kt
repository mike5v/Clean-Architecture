package com.mike5v.api


import com.mike5v.api.utils.Response
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.net.HttpURLConnection

class ApiTest {

    private val catsApi: CatsApi by lazy {
        Network.createService(baseUrl = mockWebServer.url("/").toString(), service = CatsApi::class.java)
    }

    private val mockWebServer = MockWebServer()

    @Before
    fun setup() {
        mockWebServer.start()
    }

    @After
    fun shutdown() {
        mockWebServer.shutdown()
    }

    @Test
    fun `search cat`() {

        // GIVEN
        val response =
            Response.createResponseWthBody(
                HttpURLConnection.HTTP_OK,
                Response.loadJson("api-response/search")
            )

        // WHEN
        mockWebServer.enqueue(response)
        val cats = runBlocking { catsApi.getCatFromNetwork() }

        //THEN
        val request = mockWebServer.takeRequest()

        assertEquals(1, cats.size)
        assertEquals("GET", request.method)
        assertEquals("/images/search", request.path)
        assertEquals("blp", cats.first().id)
        assertEquals("https://cdn2.thecatapi.com/images/blp.jpg", cats.first().url)
    }
}