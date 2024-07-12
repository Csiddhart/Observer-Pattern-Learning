package com.example.learning

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.learning.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val viewModel: ViewModel by activityViewModels()//so now i'm connected with viewmodel

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //initialization
        //connect xml of fragments with kotlin files
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //after the fragments is created, logic is added
        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }

        //as a observer
        //here all observe stuff happens
        //and all manipulation stuffs happens
        binding.decrease.setOnClickListener{
            viewModel.decreament() //so here im observing and manipulating
        }

        //now im copying the lambda fun to observe the change and the output
        viewModel.getdataareviewed().observe(viewLifecycleOwner, Observer { incomingvalue /*this is the actual thing which helps in observing the data*/ ->
            // Update the list UI.
            binding.textviewSecond.text="Count :"+incomingvalue//now this will help in observing the data
        })


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}