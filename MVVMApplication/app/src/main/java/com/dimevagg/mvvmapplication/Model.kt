package com.dimevagg.mvvmapplication

class Model {
    private var data = mutableListOf<String>()
    private var filteredData = mutableListOf<String>()

    fun addRemark(remark: String): String {
        if (remark.isEmpty()) {
            return "Введите текст заметки"
        }
        data.add(remark)
        filteredData = data
        return ""
    }

    fun getRemarks(): List<String> {
        return data
    }

    fun clear() {
        data.clear()
    }

}