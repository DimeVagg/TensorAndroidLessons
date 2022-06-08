package com.dimevagg.mvvmapplication

class Model {
    private var data = mutableListOf<String>()
    private var filteredData = mutableListOf<String>()

    fun addRemark(remark: String): String {
        if (remark.isEmpty()) {
            return "Введите текст заметки"
        }
        data.add(remark)
        return ""
    }

    fun getRemarks(): List<String> {
        return data
    }

    fun filterRemarks(s: CharSequence): List<String> {
        filteredData.clear()
        for (elem in data) {
            if (elem.contains(s, true))
                filteredData.add(elem)
        }
        return filteredData
    }


}