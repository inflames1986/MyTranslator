package com.inflames1986.mytranslator.translator.domain.model

import com.google.gson.annotations.SerializedName
import com.inflames1986.mytranslator.translator.domain.model.ModelConstants.MODEL_GENDER
import com.inflames1986.mytranslator.translator.domain.model.ModelConstants.MODEL_NUM
import com.inflames1986.mytranslator.translator.domain.model.ModelConstants.MODEL_PART_OF_SPEECH
import com.inflames1986.mytranslator.translator.domain.model.ModelConstants.MODEL_TEXT

data class Mean(

    @SerializedName(MODEL_TEXT)
    val text: String,

    @SerializedName(MODEL_GENDER)
    val gender: String = "",

    @SerializedName(MODEL_PART_OF_SPEECH)
    val partOfSpeech: String = "",

    @SerializedName(MODEL_NUM)
    val num: String = ""
)