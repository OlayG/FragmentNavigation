package com.example.fragmentnavigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.fragmentnavigation.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    // SecondFragmentArgs is generated based on the arguments in the nav_graph.xml
    // by navArgs is for kotlin java 1.8 its an extension function for lazy that helps
    // us initialize the generated class (SecondFragmentArgs)
    private val args: SecondFragmentArgs by navArgs()
    private lateinit var binding: FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentSecondBinding.inflate(LayoutInflater.from(context), container, false)
        .also { binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Using the args (SecondFragmentArgs) to access the properties i defined in the nav_xml
        args.greetingMessage?.let { message ->
            binding.tvDisplay.text = message
        }

        // using the fragment to access the properties I passed through the bundle but not in the
        // fragments nested arguments in the nav_graph.xml
        arguments?.getInt("num_count")?.let {
            binding.tvDisplay.append("\n $it")
        }
    }
}