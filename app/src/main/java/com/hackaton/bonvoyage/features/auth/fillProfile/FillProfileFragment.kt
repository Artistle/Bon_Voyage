package com.hackaton.bonvoyage.features.auth.fillProfile

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.hackaton.bonvoyage.coreFeatures.BaseFragment
import com.hackaton.bonvoyage.databinding.FillProfileDataFragmentBinding

class FillProfileFragment: BaseFragment<FillProfileDataFragmentBinding>(FillProfileDataFragmentBinding::inflate) {

    companion object {

        fun getInstanceFillProfileFragment() = FragmentScreen { FillProfileFragment() }
    }
}