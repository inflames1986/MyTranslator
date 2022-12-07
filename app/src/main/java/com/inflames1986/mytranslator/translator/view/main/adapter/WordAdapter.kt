package com.inflames1986.mytranslator.translator.view.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.inflames1986.domain.storage.entity.WordTranslate
import com.inflames1986.mytranslator.R

class WordAdapter(
    private val delegate: Delegate?
) : RecyclerView.Adapter<WordViewHolder>() {

    interface Delegate {

        fun onItemPicked(word: WordTranslate)


        fun onFavouritePicked(word: WordTranslate)
    }

    private val data = ArrayList<WordTranslate>()

    fun setData(newList: ArrayList<WordTranslate>) {
        val result = DiffUtil.calculateDiff(DiffUtilCallback(this.data, newList))
        result.dispatchUpdatesTo(this)
        this.data.clear()
        this.data.addAll(newList)
    }

    fun clear() {
        this.data.clear()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        return WordViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.main_item, parent, false) as View
        )
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        holder.bind(data[position], delegate)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class DiffUtilCallback(
        private var oldItems: ArrayList<WordTranslate>,
        private var newItems: ArrayList<WordTranslate>
    ) : DiffUtil.Callback() {

        override fun getOldListSize(): Int = oldItems.size

        override fun getNewListSize(): Int = newItems.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldItems[oldItemPosition].word == newItems[newItemPosition].word &&
                    oldItems[oldItemPosition].partOfSpeech == newItems[newItemPosition].partOfSpeech

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldItems[oldItemPosition] == newItems[newItemPosition]
    }
}