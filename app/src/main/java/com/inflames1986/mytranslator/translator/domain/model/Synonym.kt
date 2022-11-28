package com.inflames1986.mytranslator.translator.domain.model

import com.google.gson.annotations.SerializedName
import com.inflames1986.mytranslator.translator.domain.model.ModelConstants

data class Synonym(

    @SerializedName(ModelConstants.MODEL_FR)
    val fr: Int,

    @SerializedName(ModelConstants.MODEL_GENDER)
    val gen: String,

    @SerializedName(ModelConstants.MODEL_PART_OF_SPEECH)
    val pos: String,

    @SerializedName(ModelConstants.MODEL_TEXT)
    val text: String,

    @SerializedName(ModelConstants.MODEL_NUM)
    val num: String = ""
)