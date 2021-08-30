package com.udacity.shoestore

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.ScrollView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.DetailsFragmentBinding
import com.udacity.shoestore.databinding.ShoeLayoutBinding
import com.udacity.shoestore.databinding.ShoeListFragmentBinding

class ShoeListFragment : Fragment() {


    private lateinit var viewModel: ShoeListViewModel
    private lateinit var binding: ShoeListFragmentBinding
    private lateinit var bindingShoeLayout: ShoeLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.shoe_list_fragment,
            container,
            false
        )

//        viewModel = ViewModelProvider(this).get(ShoeListViewModel::class.java)
        viewModel = ViewModelProvider(requireActivity()).get(ShoeListViewModel::class.java)

        binding.listViewModel = viewModel
        binding.setLifecycleOwner(requireActivity())

        viewModel.buttonDetails.observe(viewLifecycleOwner, Observer{button ->
            if (button){
                viewModel.onDetailsComplete()

                findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToDetailsFragment())
            }
        })




        viewModel.shoeList.observe(viewLifecycleOwner, Observer{button ->
            addNewShoeView(inflater)
        })


        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.sample_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

    private fun addNewShoeView(inflater: LayoutInflater){

        for (shoe in viewModel.shoeList.value!!) {
            bindingShoeLayout = DataBindingUtil.inflate(
                inflater,
                R.layout.shoe_layout,
                binding.shoeListContainer,
                false
            )

            bindingShoeLayout.shoe = shoe

            binding.shoeListContainer.addView(bindingShoeLayout.root)

        }
    }




}