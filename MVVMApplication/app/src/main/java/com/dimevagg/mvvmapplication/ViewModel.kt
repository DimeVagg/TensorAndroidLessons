package com.dimevagg.mvvmapplication

import android.view.View
import androidx.lifecycle.MutableLiveData

class ViewModel {
    private val model = Model()
    var error = MutableLiveData("")
    var remarks = MutableLiveData(listOf<String>())
    var input = MutableLiveData("")

    fun addRemark(view: View) {
        val res = model.addRemark(input.value!!)
        if (res.isNotEmpty()) {
            error.value = res
            return
        }
        remarks.value = model.getRemarks()
        input.value = ""
    }

    fun clear() {
        model.clear()
        remarks.value = model.getRemarks()
    }
}