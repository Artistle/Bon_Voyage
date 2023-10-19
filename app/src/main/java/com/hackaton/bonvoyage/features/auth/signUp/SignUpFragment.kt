package com.hackaton.bonvoyage.features.auth.signUp

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.hackaton.bonvoyage.coreFeatures.BaseFragment
import com.hackaton.bonvoyage.databinding.SignUpFragmentBinding

class SignUpFragment: BaseFragment<SignUpFragmentBinding>(SignUpFragmentBinding::inflate) {



    companion object {

        fun getInstanceSignUpFragment() = FragmentScreen { SignUpFragment() }
    }
}