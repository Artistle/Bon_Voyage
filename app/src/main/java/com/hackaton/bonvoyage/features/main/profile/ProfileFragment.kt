package com.hackaton.bonvoyage.features.main.profile

import androidx.lifecycle.lifecycleScope
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.hackaton.bonvoyage.coreFeatures.BaseFragment
import com.hackaton.bonvoyage.databinding.ProfileFragmentBinding
import com.hackaton.core_di.nameDeep
import com.hackaton.core_di.qualifiers.NavigationQualifiers
import com.hackaton.core_di.qualifiers.featureQualifiers.FeaturesQualifiers
import com.hackaton.entity.Profile
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class ProfileFragment: BaseFragment<ProfileFragmentBinding>(ProfileFragmentBinding::inflate) {

    private val viewModel: ProfileViewModel by inject(nameDeep(FeaturesQualifiers.PROFILE_VIEW_MODEL))
    private val router: Router by inject(nameDeep(NavigationQualifiers.ROUTER_MAIN))

    override fun onStart() {
        super.onStart()
        lifecycleScope.launch {
            viewModel.apply {
                profile.collectLatest { profile ->
                    bindProfileData(profile)
                }
            }
        }
    }

    private fun bindProfileData(profile: Profile) {
        binding.profileName.text = "${profile.name ?: ""} ${profile.lastname ?: ""}"
    }
    companion object {

        fun getInstanceProfileFragment() = FragmentScreen { ProfileFragment() }
    }
}