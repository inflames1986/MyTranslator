package com.inflames1986.mytranslator.translator.view.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.inflames1986.mytranslator.translator.view.main.MainFragment

class MainScreen : FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment =
        MainFragment.newInstance()
}