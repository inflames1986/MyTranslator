package com.inflames1986.domain.storage.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import com.inflames1986.mytranslator.translator.domain.storage.entity.EntityConstants
import kotlinx.parcelize.Parcelize

@Entity(
    tableName = EntityConstants.TABLE_FAVOURITE,
    primaryKeys = [EntityConstants.PRIMARY_KEY_ONE, EntityConstants.PRIMARY_KEY_TWO]
)
@Parcelize
data class WordFavourite(

    @ColumnInfo(name = EntityConstants.WORD_COLUMN_WORD)
    val word: String,

    @ColumnInfo(name = EntityConstants.WORD_COLUMN_TRANSLATE)
    val translate: String = "",

    @ColumnInfo(name = EntityConstants.WORD_COLUMN_MEAN)
    val mean: String = "",

    @ColumnInfo(name = EntityConstants.WORD_COLUMN_TRANSCRIPTION)
    val transcription: String = "",

    @ColumnInfo(name = EntityConstants.WORD_COLUMN_PART_OF_SPEECH)
    val partOfSpeech: String = "",

    @ColumnInfo(name = EntityConstants.WORD_COLUMN_SYNONYM)
    val synonym: String = "",

    @ColumnInfo(name = EntityConstants.WORD_COLUMN_EXAMPLE)
    val example: String = "",

    @ColumnInfo(name = EntityConstants.WORD_COLUMN_IMAGE_URL)
    val imageURL: String = "",

    @ColumnInfo(name = EntityConstants.WORD_COLUMN_FAVOURITE)
    val favourite: Boolean = false

) : Parcelable