package com.dimevagg.daggerapp

import dagger.Component

@MyScope
@Component(dependencies = [], modules = [MyModule::class])
interface MyComponent {

    fun myPresenter(): MyPresenter

}