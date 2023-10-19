package com.hackaton.bonvoyage.features.auth.fillProfile

import android.content.Intent
import androidx.lifecycle.lifecycleScope
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.hackaton.bonvoyage.MainViewModel
import com.hackaton.bonvoyage.coreFeatures.BaseFragment
import com.hackaton.bonvoyage.databinding.FillProfileDataFragmentBinding
import com.hackaton.bonvoyage.features.main.fragmentHost.MainHostFragment
import com.hackaton.core_di.nameDeep
import com.hackaton.core_di.qualifiers.NavigationQualifiers
import com.hackaton.core_di.qualifiers.featureQualifiers.FeaturesQualifiers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class FillProfileFragment :
    BaseFragment<FillProfileDataFragmentBinding>(FillProfileDataFragmentBinding::inflate) {

    private val viewModel: FillProfileViewModel by viewModel(nameDeep(FeaturesQualifiers.FILL_PROFILE_VIEW_MODEL))
    private val router: Router by inject(nameDeep(NavigationQualifiers.ROUTER))

    override fun onStart() {
        super.onStart()
        binding.btnNext.setOnClickListener { finishFillData() }
        viewModel.apply {
            lifecycleScope.launch {
                fillProfileResult.collectLatest {
                    if (it) startActivity(Intent(context, MainHostFragment::class.java))
                }
            }
        }
    }

    private fun finishFillData() {
        val name = binding.nameEditText.text.toString()
        val lastname = binding.lastnameEditText.text.toString()
        viewModel.createUser(name, lastname)
    }

    companion object {

        fun getInstanceFillProfileFragment() = FragmentScreen { FillProfileFragment() }
    }
}