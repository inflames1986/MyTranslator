package com.inflames1986.screenhistory.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.inflames1986.domain.storage.entity.WordTranslate
import com.inflames1986.utils.extensions.click
import com.inflames1986.screenhistory.databinding.HistoryItemBinding


class HistoryWordViewHolder(
    view: View
) : RecyclerView.ViewHolder(view) {

    private val binding: HistoryItemBinding by viewBinding()

    fun bind(data: WordTranslate, delegate: HistoryWordAdapter.Delegate?) {
        with(binding) {
            header.text = data.word
            description.text = data.translate
            binding.root.click { delegate?.onItemPicked(data) }
        }
    }
}