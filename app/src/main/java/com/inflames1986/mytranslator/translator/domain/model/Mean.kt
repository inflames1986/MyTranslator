package com.inflames1986.mytranslator.translator.domain.model

import com.google.gson.annotations.SerializedName

data class Mean(

    @SerializedName("text")
    val text: String,

    @SerializedName("gen")
    val gender: String = "",

    @SerializedName("pos")
    val partOfSpeech: String = "",

    @SerializedName("num")
    val num: String = ""
)