package com.mdemel.afl

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton

class HomeScreenFragment : Fragment() {

    companion object {
        fun newInstance() = HomeScreenFragment()
    }

    private val viewModel: HomeScreenViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val root = inflater.inflate(R.layout.fragment_home_screen, container, false)

        root.findViewById<AppCompatButton>(R.id.buttonNavigate).setOnClickListener {
            // Add the next screen / second screen
            activity?.supportFragmentManager?.beginTransaction()
                ?.add(R.id.fragment_container_view, SecondScreenFragment::class.java, null)
                ?.addToBackStack("second")?.commit()
        }

        return root
    }
}