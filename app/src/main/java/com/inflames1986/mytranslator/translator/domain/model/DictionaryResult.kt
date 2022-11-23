package com.inflames1986.mytranslator.translator.domain.model

import com.google.gson.annotations.SerializedName
import com.inflames1986.mytranslator.translator.domain.model.ModelConstants.MODEL_DICTIONARY_ENTRY_LIST

data class DictionaryResult(

    @SerializedName(MODEL_DICTIONARY_ENTRY_LIST)
    val dictionaryEntryList: List<DictionaryEntry>
)