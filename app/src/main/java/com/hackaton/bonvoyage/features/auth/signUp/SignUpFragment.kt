package com.hackaton.bonvoyage.features.auth.signUp

import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.lifecycleScope
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.hackaton.bonvoyage.coreFeatures.BaseFragment
import com.hackaton.bonvoyage.databinding.SignUpFragmentBinding
import com.hackaton.bonvoyage.features.auth.fillProfile.FillProfileFragment
import com.hackaton.bonvoyage.features.auth.signIn.SignInFragment
import com.hackaton.core_di.nameDeep
import com.hackaton.core_di.qualifiers.NavigationQualifiers
import com.hackaton.core_di.qualifiers.featureQualifiers.FeaturesQualifiers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignUpFragment: BaseFragment<SignUpFragmentBinding>(SignUpFragmentBinding::inflate) {

    private val viewModel: SignUpViewModel by viewModel(nameDeep(FeaturesQualifiers.SIGN_UP_VIEW_MODEL))
    private val router: Router by inject(nameDeep(NavigationQualifiers.ROUTER))

    override fun onStart() {
        super.onStart()
        binding.apply {
            passwordEditText.addTextChangedListener { reCheckEnabledSignUp() }
            phoneEditText.addTextChangedListener { reCheckEnabledSignUp() }
            retryPasswordEditText.addTextChangedListener { reCheckEnabledSignUp() }
            btnSignUp.setOnClickListener { defaultSignUp() }
            btnSignIn.setOnClickListener { router.navigateTo(SignInFragment.getInstanceSignInFragment()) }
        }

        viewModel.apply {
            lifecycleScope.launch {
                signUnResult.collectLatest {
                    if (it) router.navigateTo(FillProfileFragment.getInstanceFillProfileFragment())
                }
            }
        }
    }

    private fun defaultSignUp() {
        val phone = binding.phoneEditText.text.toString()
        val password = binding.passwordEditText.text.toString()
        viewModel.createUser(phoneNumber = phone, password = password)
    }

    private fun reCheckEnabledSignUp() {
        binding.btnSignUp.isEnabled =
            !binding.passwordEditText.text.isNullOrEmpty() && !binding.phoneEditText.text.isNullOrEmpty() && !binding.retryPasswordEditText.text.isNullOrEmpty()
    }

    companion object {

        fun getInstanceSignUpFragment() = FragmentScreen { SignUpFragment() }
    }
}