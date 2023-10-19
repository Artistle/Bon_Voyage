package com.hackaton.bonvoyage.features.main.habitation.createHabitation.description

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.hackaton.bonvoyage.coreFeatures.BaseFragment
import com.hackaton.bonvoyage.databinding.CreateHabitationDescriptionFragmentBinding
import com.hackaton.entity.request.HabitationRequest


class DescriptionFragment() : BaseFragment<CreateHabitationDescriptionFragmentBinding>(
    CreateHabitationDescriptionFragmentBinding::inflate
) {

    override fun onStart() {
        super.onStart()

        binding.btnNext.isClickable =
            !binding.titleText.text.isNullOrEmpty() && !binding.descriptionEditText.text.isNullOrEmpty()
        binding.btnNext.setOnClickListener {


        }
    }

    companion object {
        fun getInstanceProfileFragment() =
            FragmentScreen { DescriptionFragment() }
    }
}