package com.hackaton.bonvoyage.features.main.habitation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.hackaton.bonvoyage.coreFeatures.BaseFragment
import com.hackaton.bonvoyage.databinding.HabitationFragmentBinding
import com.hackaton.bonvoyage.features.main.habitation.adapters.HabitationSelectionAdapter
import com.hackaton.bonvoyage.features.main.main.adapters.MainSelectionAdapter
import com.hackaton.entity.Habitation
import com.hackaton.entity.SelectionTour
import java.util.Date

class HabitationFragment: BaseFragment<HabitationFragmentBinding>(HabitationFragmentBinding::inflate) {

    override fun onStart() {
        super.onStart()

        binding.recycler.adapter = HabitationSelectionAdapter(
            arrayListOf(
                Habitation("title", "url", 1, 10, 11, Date(), Date(), "Alex icon", "Alex"),
                Habitation("title", "url", 1, 10, 11, Date(), Date(), "Alex icon", "Alex"),
                Habitation("title", "url", 1, 10, 11, Date(), Date(), "Alex icon", "Alex")
            )
        )
    }
    companion object {
        fun getInstanceProfileFragment() = FragmentScreen { HabitationFragment() }
    }
}