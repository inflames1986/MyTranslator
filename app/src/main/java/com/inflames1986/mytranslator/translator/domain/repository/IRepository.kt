package com.inflames1986.mytranslator.translator.domain.repository

interface IRepository<T> {

    suspend fun getData(word: String): T
}