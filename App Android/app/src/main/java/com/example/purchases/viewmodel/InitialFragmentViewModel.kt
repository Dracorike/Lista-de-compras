package com.example.purchases.viewmodel

import androidx.lifecycle.ViewModel
import com.example.purchases.model.Store
import com.example.purchases.util.ANDROID_ICON_DRAWABLE

class InitialFragmentViewModel:ViewModel() {
    fun mockListStores(): ArrayList<Store> {
        return arrayListOf(
            Store(ANDROID_ICON_DRAWABLE, "Amazonia"),
            Store(ANDROID_ICON_DRAWABLE, "Magazine Melissa"),
            Store(ANDROID_ICON_DRAWABLE, "Casas Paraíba")
        )
    }
}