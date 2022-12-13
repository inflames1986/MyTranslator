package com.inflames1986.screenfavourite

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen

class FavouriteScreen : FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment =
        FavouriteFragment.newInstance()
}