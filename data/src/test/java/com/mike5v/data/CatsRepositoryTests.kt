package com.mike5v.data

import assertk.assert
import assertk.assertions.isEqualTo
import com.mike5v.domain.Cat
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test

class CatsRepositoryTests {

    private val service: CatsServices = mockk()
    private val repository = CatsRepository(service)

    @Test
    fun `cat repository test`() = runBlocking {
        coEvery { service.getCat() } returns Cat(id = "id", url = "https://images-na.ssl-images-amazon.com/images/I/41y16B5C6rL._SX311_BO1,204,203,200_.jpg")

        val cat = repository.getCat()

        assert(cat.id).isEqualTo("id")
        assert(cat.url).isEqualTo("https://images-na.ssl-images-amazon.com/images/I/41y16B5C6rL._SX311_BO1,204,203,200_.jpg")
    }
}