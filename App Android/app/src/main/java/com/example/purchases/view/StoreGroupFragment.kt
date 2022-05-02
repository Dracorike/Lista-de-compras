package com.example.purchases.view

import android.app.Application
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.purchases.R
import com.example.purchases.databinding.FragmentInitialBinding
import com.example.purchases.databinding.FragmentStoreGroupBinding
import com.example.purchases.model.Store
import com.example.purchases.util.ANDROID_ICON_DRAWABLE
import com.example.purchases.util.ClickCard
import com.example.purchases.view.adapters.StoreGroupAdapter
import com.example.purchases.viewmodel.InitialFragmentViewModel

class StoreGroupFragment : Fragment(), ClickCard {
    private lateinit var binding: FragmentStoreGroupBinding
    private lateinit var viewModel:InitialFragmentViewModel
    private lateinit var navController: NavController
    private lateinit var storeBunch:List<Store>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStoreGroupBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider
            .AndroidViewModelFactory(activity?.application as Application)
            .create(InitialFragmentViewModel::class.java)
        storeBunch = viewModel.mockListStores()
        navController = findNavController()

        initUIFunctions()
        return binding.root
    }

    private fun initUIFunctions() {
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.recyclerviewGroupStore.layoutManager =
            LinearLayoutManager(activity?.applicationContext)
        binding.recyclerviewGroupStore.adapter = recyclerViewAdapterBuild()
    }

    private fun recyclerViewAdapterBuild(): StoreGroupAdapter =
        StoreGroupAdapter(storeBunch, activity?.applicationContext as Context, this)

    override fun switchFragment() {

    }

}