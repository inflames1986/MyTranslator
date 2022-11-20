package com.inflames1986.mytranslator.translator.domain.model

import com.google.gson.annotations.SerializedName

data class DictionaryEntry(

    @SerializedName("gen")
    val gender: String = "",

    @SerializedName("pos")
    val partOfSpeech: String = "",

    @SerializedName("text")
    val text: String = "",

    @SerializedName("tr")
    val translatesList: List<Translation> = listOf(),

    @SerializedName("ts")
    val transcription: String = "",

    @SerializedName("num")
    val num: String = ""
)