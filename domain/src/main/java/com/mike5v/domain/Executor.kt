package com.mike5v.domain

interface Executor <T> {
    suspend fun execute(): T
}