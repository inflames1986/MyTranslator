package com.inflames1986.mytranslator.translator.domain.model

import com.google.gson.annotations.SerializedName


data class Translation(


    @SerializedName("asp")
    val asp: String?,

    @SerializedName("ex")
    val examplesList: List<Examples>?,

    @SerializedName("fr")
    val fr: Int,

    @SerializedName("gen")
    val gen: String?,

    @SerializedName("mean")
    val meanList: List<Mean> = listOf(),

    @SerializedName("num")
    val num: String?,

    @SerializedName("pos")
    val pos: String = "",

    @SerializedName("syn")
    val synonymList: List<Synonym> = listOf(),

    @SerializedName("text")
    val text: String = ""
) {
    override fun toString(): String {

        var result: String = this.text

        this.num?.let {
            result += ", ${this.num} ч."
        }

        this.gen?.let {
            result += ", ${this.gen} род."
        }

        this.asp?.let {
            result += ", ${this.asp}"
        }

        examplesList?.let {
            result += "\n[" + it.joinToString(separator = ",\n") + "]"
        }

        return result
    }
}