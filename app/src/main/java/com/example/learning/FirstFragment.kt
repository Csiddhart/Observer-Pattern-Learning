package com.example.learning

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.learning.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    //here where the observe pattern is created and viewed(from here u can view what is happening in viewmodel and can manipulate it)

    private var _binding: FragmentFirstBinding? = null

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
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }
      //after the fragments is created, logic is added
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

          //as a observer
          //here all observe stuff happens
          //and all manipulation stuffs happens
            binding.increase.setOnClickListener{
                viewModel.increament() //so here im observing and manipulating
            }

          //now im copying the lambda fun to observe the change and the output
          viewModel.getdataareviewed().observe(viewLifecycleOwner, Observer { incomingvalue /*this is the actual thing which helps in observing the data*/ ->
              // Update the list UI.
              binding.textviewFirst.text="Count :"+incomingvalue//now this will help in observing the data
          })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}