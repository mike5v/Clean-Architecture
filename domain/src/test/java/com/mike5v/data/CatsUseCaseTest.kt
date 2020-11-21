package com.mike5v.data

import assertk.assert
import assertk.assertions.isEqualTo
import com.mike5v.domain.Cat
import com.mike5v.domain.CatsRepository
import com.mike5v.domain.CatsUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test

class CatsUseCaseTest {

    private val repository: CatsRepository = mockk()
    private val useCase = CatsUseCase(repository)

    @Test
    fun `cat usecase test`() = runBlocking {
        coEvery { repository.getCat() } returns Cat(id = "id", url = "https://images-na.ssl-images-amazon.com/images/I/41y16B5C6rL._SX311_BO1,204,203,200_.jpg")

        val url = useCase.getCatUrlImage()

        assert(url).isEqualTo("https://images-na.ssl-images-amazon.com/images/I/41y16B5C6rL._SX311_BO1,204,203,200_.jpg")
    }
}