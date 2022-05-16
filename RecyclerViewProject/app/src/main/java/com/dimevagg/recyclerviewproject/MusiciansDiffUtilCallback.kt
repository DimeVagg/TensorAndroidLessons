package com.dimevagg.recyclerviewproject

import androidx.recyclerview.widget.DiffUtil

class MusiciansDiffUtilCallback(oldList: MutableList<Musician>, newList: MutableList<Musician>) :
    DiffUtil.Callback() {

    private val mOldList: MutableList<Musician>
    private val mNewList: MutableList<Musician>

    override fun getOldListSize(): Int {
        return mOldList.size
    }

    override fun getNewListSize(): Int {
        return mNewList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return mOldList[oldItemPosition].id.equals(mNewList[newItemPosition].id)
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldMusician: Musician = mOldList[oldItemPosition]
        val newMusician: Musician = mNewList[newItemPosition]
        return (oldMusician.fullName.equals(newMusician.fullName) &&
                oldMusician.bandName.equals(newMusician.bandName) &&
                oldMusician.photoUrl.equals(newMusician.photoUrl) &&
                oldMusician.liked.equals(newMusician.liked)
        )
    }

    init {
        mOldList = oldList
        mNewList = newList
    }
}