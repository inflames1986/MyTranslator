package com.inflames1986.mytranslator.translator.extensions

import android.view.View
import com.google.android.material.snackbar.Snackbar

fun View.click(click: () -> Unit) = setOnClickListener { click() }

fun View.showSnakeBar(text: String, length: Int = Snackbar.LENGTH_SHORT) {
    Snackbar.make(this, text, length).show()
}