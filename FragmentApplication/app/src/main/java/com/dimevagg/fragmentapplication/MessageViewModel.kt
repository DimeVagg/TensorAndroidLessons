package com.dimevagg.fragmentapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MessageViewModel : ViewModel() {
    val message = MutableLiveData<String>()
    val isMessageRead = MutableLiveData<Boolean>(false)

    fun setMessage(messageToSet: String) {
        message.value = messageToSet
    }

    fun setMessageRead() {
        isMessageRead.value = true
        setMessage("Message is read")
    }
}