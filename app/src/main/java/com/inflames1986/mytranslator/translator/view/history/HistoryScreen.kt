package com.inflames1986.mytranslator.translator.view.history

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen

class HistoryScreen : FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment =
        HistoryFragment.newInstance()
}