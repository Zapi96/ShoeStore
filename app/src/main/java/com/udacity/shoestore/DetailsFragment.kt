package com.udacity.shoestore

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.DetailsFragmentBinding
//import androidx.fragment.app.activityViewModels

class DetailsFragment : Fragment() {


    private lateinit var viewModel: ShoeListViewModel
    private lateinit var binding: DetailsFragmentBinding
//    private val sharedViewModel: ShoeListViewModel by activityViewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.details_fragment,
            container,
            false
        )

        viewModel = ViewModelProvider(requireActivity()).get(ShoeListViewModel::class.java)
        binding.shoelistViewModel = viewModel
        binding.setLifecycleOwner(this)


//        binding.buttonCancel.setOnClickListener {
//
//            findNavController().navigate(DetailsFragmentDirections.actionDetailsFragmentToShoeListFragment())
//        }


        viewModel.buttonCancel.observe(viewLifecycleOwner, Observer{button ->
            if (button){
                viewModel.onCancelComplete()

                findNavController().navigate(DetailsFragmentDirections.actionDetailsFragmentToShoeListFragment())
            }
        })

        viewModel.buttonSave.observe(viewLifecycleOwner, Observer{button ->
            if (button){
                viewModel.onSaveComplete()
                findNavController().navigate(DetailsFragmentDirections.actionDetailsFragmentToShoeListFragment())
            }
        })



        return binding.root
    }

    private fun createShoeView(){

    }

}