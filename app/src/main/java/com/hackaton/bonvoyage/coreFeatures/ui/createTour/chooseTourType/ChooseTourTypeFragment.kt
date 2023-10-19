package com.hackaton.bonvoyage.coreFeatures.ui.createTour.chooseTourType

import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.hackaton.bonvoyage.coreFeatures.BaseFragment
import com.hackaton.bonvoyage.coreFeatures.ui.adapters.ItemSelectionAdapter
import com.hackaton.bonvoyage.coreFeatures.ui.createTour.description.DescriptionFragment
import com.hackaton.bonvoyage.databinding.CreateTourChooseTypeFragmentBinding
import com.hackaton.bonvoyage.features.main.habitation.HabitationFragment
import com.hackaton.bonvoyage.features.main.main.MainFragment
import com.hackaton.core_di.qualifiers.NavigationQualifiers
import com.hackaton.entity.ItemSelection
import com.hackaton.entity.enums.TourType
import org.koin.android.ext.android.inject
import org.koin.core.qualifier.named

class ChooseTourTypeFragment: BaseFragment<CreateTourChooseTypeFragmentBinding>(CreateTourChooseTypeFragmentBinding::inflate) {

    private val router: Router by inject(named(NavigationQualifiers.ROUTER_MAIN))

    private var selectedTourTypeList: MutableList<TourType> = arrayListOf()

    override fun onStart() {
        super.onStart()

        val itemSelectionList = arrayListOf<ItemSelection>()
        for (tourType in TourType.entries){
            itemSelectionList.add(ItemSelection(tourType.name) { chooseTourType(tourType) })
        }

        binding.recycler.adapter = ItemSelectionAdapter(itemSelectionList, true)

        binding.btnNext.setOnClickListener {
            router.navigateTo(DescriptionFragment.getInstanceProfileFragment())
        }

        binding.createTourView.btnSaveAndExit.setOnClickListener {
            router.navigateTo(FragmentScreen{ MainFragment() })
        }
    }

    private fun chooseTourType(tourType: TourType) {
        if(selectedTourTypeList.contains(tourType)){
            selectedTourTypeList.remove(tourType)
        }
        else{
            selectedTourTypeList.add(tourType)
        }
    }

    companion object {
        fun getInstanceProfileFragment() = FragmentScreen { ChooseTourTypeFragment() }
    }
}