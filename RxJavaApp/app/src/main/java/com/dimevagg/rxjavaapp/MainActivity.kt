package com.dimevagg.rxjavaapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
    
    val rangeCount = 14

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Для перехода subscribedObservable на RxComputationThreadPool-2
        val emptyObservable = Observable.empty<Int>()
            .subscribeOn(Schedulers.computation())
        // В RxComputationThreadPool-2 сообщаем о подписке
        val subscribedObservable = Observable.just(1)
            .subscribeOn(Schedulers.computation())
            .doOnNext {
                Log.d("RX_TAG", "${Thread.currentThread().name} Подписались")
            }
        // В RxComputationThreadPool-3 считаем
        val countingObservable = Observable.range(0,rangeCount)
            .subscribeOn(Schedulers.computation())
            .doOnNext {
                Log.d("RX_TAG", "${Thread.currentThread().name} next value $it")
            }
        // В main пробрасываем ошибку и там же ведем обратный отсчет
        val errorObservable = Observable.error<Int> (
                Throwable()
            )
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError {
                Log.d("RX_TAG", "${Thread.currentThread().name} Ой, ошибка! Начинай обратный отсчет")
            }
            .onErrorResumeNext(
                Observable.range(1, rangeCount )
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnNext {
                        Log.d("RX_TAG", "${Thread.currentThread().name} next value ${rangeCount - it}")
                    }
                    .doOnComplete {
                        Log.d("RX_TAG","${Thread.currentThread().name} БУМ! Закончили")
                    }
                    .doFinally{
                        Log.d("RX_TAG","${Thread.currentThread().name} Потока больше нет - отписались")
                    }
            )
        // все Observable помещаем в concat
        Observable.concat(
            emptyObservable,
            subscribedObservable,
            countingObservable,
            errorObservable
        ).subscribe()

    }
}