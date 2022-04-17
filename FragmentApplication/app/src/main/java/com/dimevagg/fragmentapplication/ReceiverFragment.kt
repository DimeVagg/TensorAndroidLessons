package com.dimevagg.fragmentapplication

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer

class ReceiverFragment : Fragment() {

    /*companion object {
        fun newInstance() = ReceiverFragment()
    }*/

    private lateinit var viewModel: MessageViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.receiver_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(requireActivity()).get(MessageViewModel::class.java)

        val textArea = view.findViewById<TextView>(R.id.messageContainer)
        val readButton = view.findViewById<TextView>(R.id.readButton)

        viewModel.message.observe(viewLifecycleOwner, Observer {
            textArea.text = it
        })

        readButton.setOnClickListener {
            viewModel.setMessageRead()
        }
    }

}