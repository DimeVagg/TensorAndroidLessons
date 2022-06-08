package com.dimevagg.mvvmapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dimevagg.mvvmapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val myAdapter = MyAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.recyclerView.adapter = myAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        setContentView(binding.root)
    }

    companion object {
        val viewModel = ViewModel()
    }
}

@BindingAdapter("data")
fun setData(recyclerView: RecyclerView, data: List<String>) {
    val adapter = recyclerView.adapter as MyAdapter
    adapter.data = data
}

class MyAdapter: RecyclerView.Adapter<MyViewHolder>() {
    var data = listOf<String>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder(TextView(parent.context))

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.textView.text = data[position]
    }

    override fun getItemCount() = data.size
}

class MyViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)

