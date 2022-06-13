package com.dimevagg.rxjavaapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    val rangeCount = 14

    /*var intList = mutableListOf<Int>()

    private fun initIntList(reverse: Boolean = false) {
        var tmpIntList = IntRange(0,13).toMutableList()
        intList = if (reverse) tmpIntList.asReversed() else tmpIntList
    }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initIntList(false)
        // Для перехода subscribedObservable на RxComputationThreadPool-2
        val emptyObservable = Observable.empty<Int>()
            .subscribeOn(Schedulers.computation())
        val subscribedObservable = Observable.just(1)
            .doOnNext {
                Log.d("RX_TAG", "${Thread.currentThread().name} Подписались")
            }
            .subscribeOn(Schedulers.computation())
        val countingObservable = Observable.range(0,rangeCount)
            .subscribeOn(Schedulers.computation())
            .doOnNext {
                Log.d("RX_TAG", "${Thread.currentThread().name} next value $it")
            }


        var backCountFrom = rangeCount + 1
        val mainCountingObservable = Observable.range(0, rangeCount)
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError{
                Log.d("RX_TAG","${Thread.currentThread().name} Ой, ошибка! Начинай обратный отсчет")
            }
            .doOnNext {
                // TODO нужно попасть в error
                backCountFrom--
                Log.d("RX_TAG", "${Thread.currentThread().name} next value $backCountFrom")
            }
            .doOnComplete {
                Log.d("RX_TAG","${Thread.currentThread().name} БУМ! Закончили")
            }
            .doFinally{
                Log.d("RX_TAG","${Thread.currentThread().name} Потока больше нет - отписались")
            }.
            repeat(1)
        Observable.concat(
            emptyObservable,
            subscribedObservable,
            countingObservable,
            mainCountingObservable
        ).subscribe()
    }

}