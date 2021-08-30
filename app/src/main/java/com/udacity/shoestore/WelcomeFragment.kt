package com.udacity.shoestore

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.LoginFragmentBinding
import com.udacity.shoestore.databinding.WelcomeFragmentBinding

class WelcomeFragment : Fragment() {

    private lateinit var binding: WelcomeFragmentBinding
    private lateinit var viewModel: WelcomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.welcome_fragment,
            container,
            false
        )

        viewModel = ViewModelProvider(this).get(WelcomeViewModel::class.java)
        binding.welcomeViewModel = viewModel
        binding.setLifecycleOwner(this)

        viewModel.buttonInstructions.observe(viewLifecycleOwner, Observer{button ->

            if (button){
//                val action = WelcomeFragmentDirections.actionWelcomeFragmentToInstructionsFragment()
//                NavHostFragment.findNavController(this).navigate(action)
                viewModel.onShoeListComplete()
                findNavController().navigate(WelcomeFragmentDirections.actionWelcomeFragmentToInstructionsFragment())
            }
        })

        return binding.root    }

}