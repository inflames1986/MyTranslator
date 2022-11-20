package com.inflames1986.mytranslator.translator.domain.model

import com.google.gson.annotations.SerializedName

data class Examples(

    @SerializedName("text")
    val text: String,

    @SerializedName("tr")
    val translatesList: List<Translation>
) {
    override fun toString(): String {
        return text + " - " + translatesList.joinToString("\n")
    }
}