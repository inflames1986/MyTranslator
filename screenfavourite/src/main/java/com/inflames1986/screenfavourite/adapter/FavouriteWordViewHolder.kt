package com.inflames1986.screenfavourite.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.inflames1986.domain.storage.entity.WordFavourite
import com.inflames1986.screenfavourite.databinding.HistoryItemBinding
import com.inflames1986.utils.extensions.click

class FavouriteWordViewHolder(
    view: View
) : RecyclerView.ViewHolder(view) {

    private val binding: HistoryItemBinding by viewBinding()

    fun bind(data: WordFavourite, delegate: FavouriteWordAdapter.Delegate?) {
        with(binding) {
            header.text = data.word
            description.text = data.translate
            binding.root.click { delegate?.onItemPicked(data) }
        }
    }
}