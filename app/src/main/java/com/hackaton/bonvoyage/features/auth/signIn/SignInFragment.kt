package com.hackaton.bonvoyage.features.auth.signIn

import android.content.Intent
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.lifecycleScope
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.hackaton.bonvoyage.coreFeatures.BaseFragment
import com.hackaton.bonvoyage.databinding.SignInFragmentBinding
import com.hackaton.bonvoyage.features.auth.signUp.SignUpFragment
import com.hackaton.bonvoyage.features.main.fragmentHost.MainHostFragment
import com.hackaton.core_di.nameDeep
import com.hackaton.core_di.qualifiers.NavigationQualifiers
import com.hackaton.core_di.qualifiers.featureQualifiers.SignInQualifier
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignInFragment : BaseFragment<SignInFragmentBinding>(SignInFragmentBinding::inflate) {

    private val viewModel: SignInViewModel by viewModel(nameDeep(SignInQualifier.SIGN_IN_VIEW_MODEL))
    private val router: Router by inject(nameDeep(NavigationQualifiers.ROUTER))

    override fun onStart() {
        super.onStart()

        viewModel.apply {
            lifecycleScope.launch {
                signInResult.collectLatest { signInResult ->
                    routeToMain()
                }
            }
        }
        binding.apply {
            passwordEditText.addTextChangedListener { reCheckEnabledSignIn() }
            phoneEditText.addTextChangedListener { reCheckEnabledSignIn() }
            btnSignUp.setOnClickListener { defaultSignIn() }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.signInDefault("+79000000000", "password")
    }

    private fun defaultSignIn() {
        val phone = binding.phoneEditText.text.toString()
        val password = binding.passwordEditText.text.toString()
        viewModel.signInDefault(phone, password)
    }

    private fun signInByVtb() {

    }

    private fun signInByGos() {

    }

    private fun routeToMain() {
        Toast.makeText(context, "Success", Toast.LENGTH_LONG).show()
        startActivity(Intent(context, MainHostFragment::class.java))
    }

    private fun reCheckEnabledSignIn() {
        binding.signIn.isEnabled =
            !binding.passwordEditText.text.isNullOrEmpty() && !binding.phoneEditText.text.isNullOrEmpty()
    }

    companion object {

        fun getInstanceSignInFragment() = FragmentScreen { SignInFragment() }
    }
}