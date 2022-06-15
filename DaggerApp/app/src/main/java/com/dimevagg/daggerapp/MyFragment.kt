package com.dimevagg.daggerapp

import androidx.fragment.app.Fragment

class MyFragment: Fragment() {

    val myComponent = DaggerMyComponent.create().myPresenter()

}