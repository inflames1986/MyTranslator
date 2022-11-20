package com.inflames1986.mytranslator.translator.domain.model

import com.google.gson.annotations.SerializedName

data class DictionaryResult(

    @SerializedName("def")
    val dictionaryEntryList: List<DictionaryEntry>
)