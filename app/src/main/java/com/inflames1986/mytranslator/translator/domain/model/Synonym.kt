package com.inflames1986.mytranslator.translator.domain.model

import com.google.gson.annotations.SerializedName

data class Synonym(

    @SerializedName("fr")
    val fr: Int,

    @SerializedName("gen")
    val gen: String,

    @SerializedName("pos")
    val pos: String,

    @SerializedName("text")
    val text: String, // словечко

    @SerializedName("num")
    val num: String = ""
)