package com.inflames1986.mytranslator.translator.domain.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.inflames1986.domain.storage.entity.WordFavourite
import com.inflames1986.domain.storage.entity.WordTranslate


@Database(
    exportSchema = true,
    entities = [WordTranslate::class, WordFavourite::class],
    version = 13
)
abstract class WordStorage : RoomDatabase() {

    abstract fun wordDao(): WordDao
}