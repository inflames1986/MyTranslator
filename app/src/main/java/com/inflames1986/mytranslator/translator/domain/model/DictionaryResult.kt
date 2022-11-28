package com.inflames1986.mytranslator.translator.domain.model

import com.google.gson.annotations.SerializedName

data class DictionaryResult(

    @SerializedName(ModelConstants.MODEL_DICTIONARY_ENTRY_LIST)
    val dictionaryEntryList: List<DictionaryEntry>
)