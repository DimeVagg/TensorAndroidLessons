package com.dimevagg.mvvmapplication

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.lifecycle.MutableLiveData

class ViewModel {
    private val model = Model()
    var error = MutableLiveData("")
    var remarks = MutableLiveData(listOf<String>())
    var remarksBackup = MutableLiveData(listOf<String>())
    var input = MutableLiveData("")

    fun addRemark(view: View) {
        val res = model.addRemark(input.value!!)
        if (res.isNotEmpty()) {
            error.value = res
            return
        }
        remarks.value = model.getRemarks()
        remarksBackup.value = remarks.value
        input.value = ""
    }

    fun onEditTextWatcher(): TextWatcher {
        return object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s.isEmpty()) {
                    remarks.value = remarksBackup.value
                    return
                }
                var newList = model.filterRemarks(s)
                remarks.value = newList
            }
            override fun afterTextChanged(s: Editable) {}
        }
    }
}