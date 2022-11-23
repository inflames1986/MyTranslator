package com.inflames1986.mytranslator.translator.domain.model

import com.google.gson.annotations.SerializedName
import com.inflames1986.mytranslator.translator.domain.model.ModelConstants.MODEL_TEXT
import com.inflames1986.mytranslator.translator.domain.model.ModelConstants.MODEL_TRANSLATES_LIST

data class Examples(

    @SerializedName(MODEL_TEXT)
    val text: String,

    @SerializedName(MODEL_TRANSLATES_LIST)
    val translatesList: List<Translation>
) {
    override fun toString(): String {
        return text + " - " + translatesList.joinToString("\n")
    }
}