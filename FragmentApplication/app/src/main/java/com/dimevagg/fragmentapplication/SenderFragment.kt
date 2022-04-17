package com.dimevagg.fragmentapplication

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

class SenderFragment : Fragment() {

    companion object {
        fun newInstance() = SenderFragment()
    }

    private lateinit var viewModel: MessageViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.sender_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(requireActivity()).get(MessageViewModel::class.java)
        val editMessage = view.findViewById<EditText>(R.id.editMessage)

        view.findViewById<Button>(R.id.sendMessage).setOnClickListener {
            viewModel.setMessage(editMessage.text.toString())
            sendMessage()
        }
    }

   private fun sendMessage() {
        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragments_container, ReceiverFragment())
            .addToBackStack(null)
            .commit()
    }

}