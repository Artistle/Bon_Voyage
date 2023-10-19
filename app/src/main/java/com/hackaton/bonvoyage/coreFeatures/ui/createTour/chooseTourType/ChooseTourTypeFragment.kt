package com.hackaton.bonvoyage.coreFeatures.ui.createTour.chooseTourType

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.hackaton.bonvoyage.coreFeatures.BaseFragment
import com.hackaton.bonvoyage.coreFeatures.ui.adapters.ItemSelectionAdapter
import com.hackaton.bonvoyage.databinding.CreateTourChooseTypeFragmentBinding
import com.hackaton.entity.ItemSelection
import com.hackaton.entity.enums.TourType

class ChooseTourTypeFragment: BaseFragment<CreateTourChooseTypeFragmentBinding>(CreateTourChooseTypeFragmentBinding::inflate) {

    private var selectedTourTypeList: MutableList<TourType> = arrayListOf()

    override fun onStart() {
        super.onStart()

        val itemSelectionList = arrayListOf<ItemSelection>()
        for (tourType in TourType.entries){
            itemSelectionList.add(ItemSelection(tourType.id,tourType.name) { chooseTourType(tourType) })
        }

        binding.recycler.adapter = ItemSelectionAdapter(itemSelectionList, true)
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