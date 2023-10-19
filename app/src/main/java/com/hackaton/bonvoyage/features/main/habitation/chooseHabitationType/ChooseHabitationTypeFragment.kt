package com.hackaton.bonvoyage.features.main.habitation.chooseHabitationType

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.hackaton.bonvoyage.coreFeatures.BaseFragment
import com.hackaton.bonvoyage.coreFeatures.ui.adapters.ItemSelectionAdapter
import com.hackaton.bonvoyage.databinding.CreateHabitationChooseTypeFragmentBinding
import com.hackaton.entity.ItemSelection
import com.hackaton.entity.enums.HabitationType

class ChooseHabitationTypeFragment: BaseFragment<CreateHabitationChooseTypeFragmentBinding>(CreateHabitationChooseTypeFragmentBinding::inflate) {

    private var selectedHabitationType: HabitationType? = null

    override fun onStart() {
        super.onStart()

        val itemSelectionList = arrayListOf<ItemSelection>()
        for (habitationType in HabitationType.entries){
            itemSelectionList.add(ItemSelection(habitationType.name) { chooseHabitationType(habitationType) })
        }

        binding.recycler.adapter = ItemSelectionAdapter(itemSelectionList, false)
    }

    private fun chooseHabitationType(habitationType: HabitationType) {
        selectedHabitationType = habitationType
    }

    companion object {
        fun getInstanceProfileFragment() = FragmentScreen { ChooseHabitationTypeFragment() }
    }
}