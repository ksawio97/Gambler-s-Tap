package com.example.myfirstapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myfirstapp.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.toast_button).setOnClickListener {
            val myToast = Toast.makeText(context, "Hello Toast!", Toast.LENGTH_SHORT)
            myToast.show()
        }

        view.findViewById<Button>(R.id.count_button).setOnClickListener {
            countMe(view)
        }

        view.findViewById<Button>(R.id.random_button).setOnClickListener {
            val shownCountText = view.findViewById<TextView>(R.id.textview_first)
            val currCount = shownCountText.text.toString().toInt()
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(currCount)
            findNavController().navigate(action)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun countMe(view: View) {
        val shownCountText = view.findViewById<TextView>(R.id.textview_first)
        val countText = shownCountText.text.toString()
        shownCountText.text = (countText.toInt() + 1).toString()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}