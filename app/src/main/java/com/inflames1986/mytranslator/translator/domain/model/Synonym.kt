package com.inflames1986.mytranslator.translator.domain.model

import com.google.gson.annotations.SerializedName
import com.inflames1986.mytranslator.translator.domain.model.ModelConstants.MODEL_FR
import com.inflames1986.mytranslator.translator.domain.model.ModelConstants.MODEL_GENDER
import com.inflames1986.mytranslator.translator.domain.model.ModelConstants.MODEL_NUM
import com.inflames1986.mytranslator.translator.domain.model.ModelConstants.MODEL_PART_OF_SPEECH
import com.inflames1986.mytranslator.translator.domain.model.ModelConstants.MODEL_TEXT

data class Synonym(

    @SerializedName(MODEL_FR)
    val fr: Int,

    @SerializedName(MODEL_GENDER)
    val gen: String,

    @SerializedName(MODEL_PART_OF_SPEECH)
    val pos: String,

    @SerializedName(MODEL_TEXT)
    val text: String,

    @SerializedName(MODEL_NUM)
    val num: String = ""
)