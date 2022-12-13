package com.inflames1986.model.data

import com.google.gson.annotations.SerializedName

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