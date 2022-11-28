package com.inflames1986.mytranslator.translator.view.main.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.inflames1986.mytranslator.databinding.MainItemBinding
import com.inflames1986.mytranslator.translator.domain.storage.entity.WordTranslate
import com.inflames1986.mytranslator.translator.extensions.click

class WordViewHolder(
    view: View
) : RecyclerView.ViewHolder(view) {


    private val binding: MainItemBinding by viewBinding()

    fun bind(data: WordTranslate, delegate: WordAdapter.Delegate?) {
        with(binding) {
            header.text = data.word
            description.text = data.translate
            binding.root.click { delegate?.onItemPicked(data) }
            binding.favourite.click { delegate?.onFavouritePicked(data) }
        }
    }
}