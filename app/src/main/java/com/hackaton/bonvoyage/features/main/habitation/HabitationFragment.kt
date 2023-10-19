package com.hackaton.bonvoyage.features.main.habitation

import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.hackaton.bonvoyage.coreFeatures.BaseFragment
import com.hackaton.bonvoyage.features.main.habitation.chooseHabitationType.ChooseHabitationTypeFragment
import com.hackaton.bonvoyage.databinding.HabitationFragmentBinding
import com.hackaton.bonvoyage.features.main.habitation.adapters.HabitationSelectionAdapter
import com.hackaton.bonvoyage.features.main.main.adapters.MainSelectionAdapter
import com.hackaton.core_di.qualifiers.NavigationQualifiers
import com.hackaton.entity.Habitation
import com.hackaton.entity.SelectionTour
import org.koin.android.ext.android.inject
import org.koin.core.qualifier.named
import java.util.Date

class HabitationFragment: BaseFragment<HabitationFragmentBinding>(HabitationFragmentBinding::inflate) {

    private val router: Router by inject(named(NavigationQualifiers.ROUTER_MAIN))

    override fun onStart() {
        super.onStart()

        binding.recycler.adapter = HabitationSelectionAdapter(
            arrayListOf(
                Habitation("title", "url", 1, 10, 11, "Date()", "Date()", "Alex icon", "Alex"),
                Habitation("title", "url", 1, 10, 11, "Date()", "Date()", "Alex icon", "Alex"),
                Habitation("title", "url", 1, 10, 11, "Date()", "Date()", "Alex icon", "Alex")
            )
        )

        binding.btnCreateHabitation.setOnClickListener {
            router.navigateTo(ChooseHabitationTypeFragment.getInstanceProfileFragment())
        }
    }
    companion object {
        fun getInstanceProfileFragment() = FragmentScreen { HabitationFragment() }
    }
}