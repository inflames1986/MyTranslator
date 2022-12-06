package com.inflames1986.screendetail

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.inflames1986.domain.storage.entity.WordTranslate

class DetailScreen(private val word: WordTranslate) : FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment =
        DetailFragment.newInstance(word)
}