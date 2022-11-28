package com.inflames1986.mytranslator.translator.view.main.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.inflames1986.mytranslator.databinding.MainItemBinding
import com.inflames1986.mytranslator.translator.domain.storage.entity.WordTranslate
import com.inflames1986.mytranslator.translator.extensions.click

class WordViewHolder(
    view: View
) : RecyclerView.ViewHolder(view) {

    private var _binding: MainItemBinding? = null
    val binding: MainItemBinding
        get() = _binding!!

    fun bind(data: WordTranslate, delegate: WordAdapter.Delegate?) {
        with(binding) {
            header.text = data.word
            description.text = data.translate
            binding.root.click { delegate?.onItemPicked(data) }
            binding.favourite.click { delegate?.onFavouritePicked(data) }
        }
    }
}