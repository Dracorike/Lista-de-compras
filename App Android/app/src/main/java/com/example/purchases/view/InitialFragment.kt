package com.example.purchases.view

import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.purchases.R
import com.example.purchases.databinding.FragmentInitialBinding
import com.example.purchases.databinding.FragmentStoreGroupBinding

class InitialFragment : Fragment() {
    private lateinit var binding: FragmentInitialBinding
    private lateinit var navController: NavController
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInitialBinding.inflate(inflater, container, false)
        navController = findNavController()
        setupButtons()

        return binding.root
    }

    private fun setupButtons(){
        binding.buttonRegisteredStores.setOnClickListener {
            switchFragment(R.id.storeGroup)
        }
    }

    private fun switchFragment(navigateFragmentId:Int){
        navController.navigate(navigateFragmentId)
    }
}