package com.dimevagg.recyclerviewproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class RecyclerViewFragment: Fragment() {

    private lateinit var viewModel: MusicianViewModel
    private lateinit var musicianAdapter: MusicianAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.recycler_view_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById<RecyclerView>(R.id.musician_list)

        viewModel = ViewModelProvider(this).get(MusicianViewModel::class.java)
        musicianAdapter = MusicianAdapter(
            viewModel::deleteMusician,
            viewModel::toggleLike,
            requireActivity()
        )

        val verticalDivider = DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL)
        val horizontalDivider = DividerItemDecoration(this.context, DividerItemDecoration.HORIZONTAL)

        verticalDivider.setDrawable(ResourcesCompat.getDrawable(resources, R.drawable.divider, null)!!)
        horizontalDivider.setDrawable(ResourcesCompat.getDrawable(resources, R.drawable.divider, null)!!)

        recyclerView.addItemDecoration(verticalDivider)
        recyclerView.addItemDecoration(horizontalDivider)

        recyclerView.layoutManager = GridLayoutManager(this.context, 2)
        recyclerView.adapter = musicianAdapter

        viewModel.musicians.observe(viewLifecycleOwner, Observer {
            musicianAdapter.reload(it)
        })

        val fab = view.findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            viewModel.addRandomMusician()
        }
    }

}