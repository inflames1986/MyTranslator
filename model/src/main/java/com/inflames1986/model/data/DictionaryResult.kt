package com.inflames1986.model.data

import com.google.gson.annotations.SerializedName

data class DictionaryResult(

    @SerializedName(ModelConstants.MODEL_DICTIONARY_ENTRY_LIST)
    val dictionaryEntryList: List<DictionaryEntry>
)