package com.inflames1986.mytranslator.translator.view.favourite.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.inflames1986.mytranslator.databinding.HistoryItemBinding
import com.inflames1986.mytranslator.translator.domain.storage.entity.WordFavourite
import com.inflames1986.mytranslator.translator.extensions.click

class FavouriteWordViewHolder(
    view: View
) : RecyclerView.ViewHolder(view) {

    lateinit var binding: HistoryItemBinding

    fun bind(data: WordFavourite, delegate: FavouriteWordAdapter.Delegate?) {
        with(binding) {
            header.text = data.word
            description.text = data.translate
            binding.root.click { delegate?.onItemPicked(data) }
        }
    }
}