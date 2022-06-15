package com.dimevagg.daggerapp

import dagger.Module
import dagger.Provides

@Module
class MyModule {

    @MyScope
    @Provides
    fun myPresenter() : MyPresenter = MyPresenter()

}