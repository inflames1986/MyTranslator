package com.inflames1986.mytranslator.translator.view.favourite

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen


class FavouriteScreen : FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment =
        FavouriteFragment.newInstance()
}