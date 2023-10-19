package com.hackaton.bonvoyage.features.main.profile

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.hackaton.bonvoyage.coreFeatures.BaseFragment
import com.hackaton.bonvoyage.databinding.ProfileFragmentBinding

class ProfileFragment: BaseFragment<ProfileFragmentBinding>(ProfileFragmentBinding::inflate) {

    companion object {

        fun getInstanceProfileFragment() = FragmentScreen { ProfileFragment() }
    }
}