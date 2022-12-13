package com.inflames1986.domain.repository

interface IRepository<T> {

    suspend fun getData(word: String): T
}