package com.hackaton.bonvoyage.features.main.main

import com.github.terrakok.cicerone.Router
import com.hackaton.bonvoyage.coreFeatures.BaseFragment
import com.hackaton.bonvoyage.coreFeatures.ui.createTour.chooseTourType.ChooseTourTypeFragment
import com.hackaton.bonvoyage.databinding.MainFragmentBinding
import com.hackaton.bonvoyage.features.main.main.adapters.MainSelectionAdapter
import com.hackaton.core_di.nameDeep
import com.hackaton.core_di.qualifiers.NavigationQualifiers
import com.hackaton.entity.SelectionTour
import org.koin.android.ext.android.inject

class MainFragment: BaseFragment<MainFragmentBinding>(MainFragmentBinding::inflate) {

    private val router: Router by inject(nameDeep(NavigationQualifiers.ROUTER_MAIN))

    override fun onStart() {
        super.onStart()

        binding.recycler.adapter = MainSelectionAdapter(
            arrayListOf(SelectionTour("title", "url"),SelectionTour("title", "url"),SelectionTour("title", "url"),SelectionTour("title", "url"),SelectionTour("title", "url"))
        )

        binding.btnSelectTour.setOnClickListener {

        }

        binding.btnBecomeAGuide.setOnClickListener {
            router.navigateTo(ChooseTourTypeFragment.getInstanceProfileFragment())
        }
    }
}