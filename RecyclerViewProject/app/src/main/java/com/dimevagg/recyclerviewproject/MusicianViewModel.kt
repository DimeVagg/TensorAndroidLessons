package com.dimevagg.recyclerviewproject

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MusicianViewModel: ViewModel() {

    val musicians = MutableLiveData(Musician.getMockMusicians())
    var idCounter = musicians.value?.toMutableList()?.size

    fun addRandomMusician() {
        musicians.value = musicians.value?.toMutableList()?.apply {
            var musicianToAdd = Musician.getMockMusicians().random()
            musicianToAdd.id = idCounter!!
            idCounter = idCounter?.inc()
            musicianToAdd.liked = false
            add(musicianToAdd)
        }
    }

    fun deleteMusician(position: Int) {
        musicians.value = musicians.value?.toMutableList()?.apply {
            removeAt(position)
        }
    }

    fun toggleLike(position: Int) {
        musicians.value = musicians.value?.toMutableList()?.apply {
            get(position).liked = !get(position).liked
        }
    }
}