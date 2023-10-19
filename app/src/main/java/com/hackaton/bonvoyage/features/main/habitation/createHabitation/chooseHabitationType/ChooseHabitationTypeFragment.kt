package com.hackaton.bonvoyage.features.main.habitation.createHabitation.chooseHabitationType

import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.hackaton.bonvoyage.coreFeatures.BaseFragment
import com.hackaton.bonvoyage.coreFeatures.ui.adapters.ItemSelectionAdapter
import com.hackaton.bonvoyage.databinding.CreateHabitationChooseTypeFragmentBinding
import com.hackaton.bonvoyage.features.main.habitation.createHabitation.description.DescriptionFragment
import com.hackaton.core_di.nameDeep
import com.hackaton.core_di.qualifiers.NavigationQualifiers
import com.hackaton.entity.ItemSelection
import com.hackaton.entity.enums.HabitationType
import com.hackaton.entity.request.HabitationRequest
import org.koin.android.ext.android.inject

class ChooseHabitationTypeFragment(): BaseFragment<CreateHabitationChooseTypeFragmentBinding>(CreateHabitationChooseTypeFragmentBinding::inflate) {

    private val router: Router by inject(nameDeep(NavigationQualifiers.ROUTER_MAIN))
    private val habitationRequest: HabitationRequest = HabitationRequest()

    override fun onStart() {
        super.onStart()

        val itemSelectionList = arrayListOf<ItemSelection>()
        for (habitationType in HabitationType.entries){
            itemSelectionList.add(ItemSelection(habitationType.type, habitationType.name) { chooseHabitationType(habitationType) })
        }

        binding.recycler.adapter = ItemSelectionAdapter(itemSelectionList, false)
        //binding.btnNext.setOnClickListener { router.navigateTo(DescriptionFragment.getInstanceProfileFragment()) }
    }

    private fun chooseHabitationType(habitationType: HabitationType) {
        habitationRequest.hostelType = habitationType.type
    }

    companion object {
        fun getInstanceProfileFragment() = FragmentScreen { ChooseHabitationTypeFragment() }
    }
}