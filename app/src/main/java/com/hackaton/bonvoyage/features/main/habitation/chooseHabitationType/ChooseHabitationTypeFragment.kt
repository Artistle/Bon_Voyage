package com.hackaton.bonvoyage.features.main.habitation.chooseHabitationType

import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.hackaton.bonvoyage.coreFeatures.BaseFragment
import com.hackaton.bonvoyage.coreFeatures.ui.adapters.ItemSelectionAdapter
import com.hackaton.bonvoyage.coreFeatures.ui.createHabitation.description.DescriptionFragment
import com.hackaton.bonvoyage.databinding.CreateHabitationChooseTypeFragmentBinding
import com.hackaton.bonvoyage.features.main.habitation.HabitationFragment
import com.hackaton.bonvoyage.features.main.main.MainFragment
import com.hackaton.core_di.qualifiers.NavigationQualifiers
import com.hackaton.entity.ItemSelection
import com.hackaton.entity.enums.HabitationType
import org.koin.android.ext.android.inject
import org.koin.core.qualifier.named

class ChooseHabitationTypeFragment: BaseFragment<CreateHabitationChooseTypeFragmentBinding>(CreateHabitationChooseTypeFragmentBinding::inflate) {

    private val router: Router by inject(named(NavigationQualifiers.ROUTER_MAIN))

    private var selectedHabitationType: HabitationType? = null

    override fun onStart() {
        super.onStart()

        val itemSelectionList = arrayListOf<ItemSelection>()
        for (habitationType in HabitationType.entries){
            itemSelectionList.add(ItemSelection(habitationType.name) { chooseHabitationType(habitationType) })
        }

        binding.recycler.adapter = ItemSelectionAdapter(itemSelectionList, false)

        binding.btnNext.setOnClickListener {
            router.navigateTo(DescriptionFragment.getInstanceProfileFragment())
        }

        binding.createHabitationView.btnSaveAndExit.setOnClickListener {
            router.navigateTo(HabitationFragment.getInstanceProfileFragment())
        }
    }

    private fun chooseHabitationType(habitationType: HabitationType) {
        selectedHabitationType = habitationType
    }

    companion object {
        fun getInstanceProfileFragment() = FragmentScreen { ChooseHabitationTypeFragment() }
    }
}