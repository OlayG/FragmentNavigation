package com.example.fragmentnavigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.fragmentnavigation.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentFirstBinding.inflate(LayoutInflater.from(context), container, false)
        .also { binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // when button is click we will navigate to the next screen(SecondFragment)
        binding.btnAction.setOnClickListener { navigateToScreen2() }
    }


    // Method to navigate to SecondFragment
    private fun navigateToScreen2() {
        // FirstFragmentDirections is generated based on the tags in the nav_graph.xml
        // goToFragment() is the action in the nav_graph.xml
        // person is one of 3 arguments that can be passed
        FirstFragmentDirections.goToFragment2(
            person = Person("Name", 27)
        ).let {
            // `it` is an instance of the NavDirections Class
            // findNavController is an extension function made for Fragments
            // navigate is a method that takes NavDirections as its param and performs the action
            findNavController().navigate(it)
        }
    }

}