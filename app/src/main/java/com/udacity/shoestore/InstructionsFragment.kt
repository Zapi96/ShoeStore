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
import com.udacity.shoestore.databinding.InstructionsFragmentBinding

class InstructionsFragment : Fragment() {

    private lateinit var viewModel: InstructionsViewModel
    private lateinit var binding: InstructionsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.instructions_fragment,
            container,
            false
        )

        viewModel = ViewModelProvider(this).get(InstructionsViewModel::class.java)
        binding.instructionsViewModel = viewModel
        binding.setLifecycleOwner(this)

        viewModel.buttonShoeList.observe(viewLifecycleOwner, Observer{button ->
            if (button){
//                val action = InstructionsFragmentDirections.actionInstructionsFragmentToShoeListFragment()
//                NavHostFragment.findNavController(this).navigate(action)

                findNavController().navigate(InstructionsFragmentDirections.actionInstructionsFragmentToShoeListFragment())
            }
        })

        return binding.root
    }


}