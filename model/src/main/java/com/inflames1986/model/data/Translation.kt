package com.inflames1986.model.data

import com.google.gson.annotations.SerializedName

data class Translation(

    @SerializedName(ModelConstants.MODEL_ASP)
    val asp: String?,

    @SerializedName(ModelConstants.MODEL_EXAMPLE_LIST)
    val examplesList: List<Examples>?,

    @SerializedName(ModelConstants.MODEL_FR)
    val fr: Int,

    @SerializedName(ModelConstants.MODEL_GENDER)
    val gen: String?,

    @SerializedName(ModelConstants.MODEL_MEAN_LIST)
    val meanList: List<Mean> = listOf(),

    @SerializedName(ModelConstants.MODEL_NUM)
    val num: String?,

    @SerializedName(ModelConstants.MODEL_PART_OF_SPEECH)
    val pos: String = "",

    @SerializedName(ModelConstants.MODEL_SYNONYM_LIST)
    val synonymList: List<Synonym> = listOf(),

    @SerializedName(ModelConstants.MODEL_TEXT)
    val text: String = ""
)