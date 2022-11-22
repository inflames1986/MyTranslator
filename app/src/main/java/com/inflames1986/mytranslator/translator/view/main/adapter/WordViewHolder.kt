package com.inflames1986.mytranslator.translator.view.main.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.inflames1986.mytranslator.databinding.RecyclerViewItemBinding
import com.inflames1986.mytranslator.translator.domain.model.DictionaryEntry
import com.inflames1986.mytranslator.translator.extensions.click

class WordViewHolder(
    view: View
) : RecyclerView.ViewHolder(view) {

    private var _binding: RecyclerViewItemBinding? = null
    private val binding: RecyclerViewItemBinding
        get() = _binding!!

    fun bind(data: DictionaryEntry, delegate: WordAdapter.Delegate?) {
        with(binding) {
            "${data.partOfSpeech} - [${data.transcription}]".also { extensionInfo.text = it }
            headerTextviewRecyclerItem.text = data.text
            descriptionTextviewRecyclerItem.text =
                data.translatesList.joinToString(separator = "\n")
            binding.root.click { delegate?.onItemPicked(data) }
        }
    }
}