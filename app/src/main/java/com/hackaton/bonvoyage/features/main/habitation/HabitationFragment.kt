package com.hackaton.bonvoyage.features.main.habitation

import androidx.lifecycle.lifecycleScope
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.hackaton.bonvoyage.coreFeatures.BaseFragment
import com.hackaton.bonvoyage.features.main.habitation.createHabitation.chooseHabitationType.ChooseHabitationTypeFragment
import com.hackaton.bonvoyage.databinding.HabitationFragmentBinding
import com.hackaton.bonvoyage.features.main.habitation.adapters.HabitationSelectionAdapter
import com.hackaton.bonvoyage.features.main.main.adapters.MainSelectionAdapter
import com.hackaton.core_di.qualifiers.NavigationQualifiers
import com.hackaton.core_di.qualifiers.featureQualifiers.FeaturesQualifiers
import com.hackaton.entity.Habitation
import com.hackaton.entity.SelectionTour
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.core.qualifier.named
import java.util.Date

class HabitationFragment: BaseFragment<HabitationFragmentBinding>(HabitationFragmentBinding::inflate) {

    private val router: Router by inject(named(NavigationQualifiers.ROUTER_MAIN))
    private val viewModel: HabitationViewModel by inject(named(FeaturesQualifiers.HABITATION_VIEW_MODEL))

    override fun onStart() {
        super.onStart()

        viewModel.apply {
            lifecycleScope.launch {
                viewModel.habitations.collectLatest {
                    bindAdapter(it)
                }
            }
        }

        binding.btnCreateHabitation.setOnClickListener {
            router.navigateTo(ChooseHabitationTypeFragment.getInstanceProfileFragment())
        }
    }

    private fun bindAdapter(habitations: List<Habitation>) {
        val adapter = HabitationSelectionAdapter(habitations)
        binding.recycler.adapter = adapter
    }

    companion object {
        fun getInstanceProfileFragment() = FragmentScreen { HabitationFragment() }
    }
}