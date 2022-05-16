package com.dimevagg.recyclerviewproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class MusicianAdapter(
    private val deleteAction: (Int) -> Unit,
    private val toggleLikeAction: (Int) -> Unit,
    val fragmentActivity: FragmentActivity): RecyclerView.Adapter<MusicianAdapter.MusicianViewHolder>() {

    private val musicians = Musician.getMockMusicians()

    class MusicianViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val photoImageView: ImageView = itemView.findViewById(R.id.photo)
        val fullnameTextView: TextView = itemView.findViewById(R.id.fullname)
        val bandnameTextView: TextView = itemView.findViewById(R.id.bandname)
        val deleteButton: ImageView = itemView.findViewById(R.id.delete_button)
        val likeButton: ImageView = itemView.findViewById(R.id.like_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicianViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.musician_item, parent, false)
        return MusicianViewHolder(view)
    }

    override fun onBindViewHolder(holder: MusicianViewHolder, position: Int) {
        val musician = musicians[position]
        with(holder) {
            fullnameTextView.text = musician.fullName
            bandnameTextView.text = musician.bandName
            setLikeImage(this, musician)
            Glide.with(photoImageView.context)
                .load(musician.photoUrl)
                .circleCrop()
                .into(photoImageView)

            deleteButton.setOnClickListener {
                deleteAction(position)
            }
            likeButton.setOnClickListener {
                toggleLikeAction(position)
                setLikeImage(holder, musician)
            }
            itemView.setOnClickListener {
                var bundle = Bundle()
                var musicianFragment = MusicianFragment()
                bundle.putString("photoUrl", musician.photoUrl)
                musicianFragment.arguments = bundle
                fragmentActivity.supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragments_container, musicianFragment)
                    .addToBackStack(null)
                    .commit()
            }
        }
    }

    override fun getItemCount(): Int {
        return musicians.size
    }

    fun reload(data: MutableList<Musician>) {
        val diffCallback = MusiciansDiffUtilCallback(musicians, data)
        val musiciansDiffResult = DiffUtil.calculateDiff(diffCallback)

        musicians.clear()
        musicians.addAll(data)

        musiciansDiffResult.dispatchUpdatesTo(this)
    }

    fun setLikeImage(holder: MusicianViewHolder, musician: Musician) {
        if(musician.liked) {
            holder.likeButton.setImageResource(R.drawable.like)
            return
        }
        holder.likeButton.setImageResource(R.drawable.like_inactive)
    }

}