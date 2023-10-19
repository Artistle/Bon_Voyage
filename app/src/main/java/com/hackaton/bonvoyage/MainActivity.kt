package com.hackaton.bonvoyage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.hackaton.bonvoyage.databinding.ActivityMainBinding
import com.hackaton.bonvoyage.features.auth.signIn.SignInFragment
import com.hackaton.bonvoyage.features.main.fragmentHost.MainHostFragment
import com.hackaton.core_di.nameDeep
import com.hackaton.core_di.qualifiers.NavigationQualifiers
import com.hackaton.entity.AuthState
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModel<MainViewModel>()
    private val router: Router by inject(nameDeep(NavigationQualifiers.ROUTER))
    private val holder: NavigatorHolder by inject(nameDeep(NavigationQualifiers.HOLDER))
    private val navigator: AppNavigator by lazy {
        customNavigator()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        holder.setNavigator(navigator)
    }

    override fun onStart() {
        super.onStart()
        viewModel.apply {
            loadState()
            stateFlow.observe(this@MainActivity, ::startDestination)
        }
    }

    private fun startDestination(authState: AuthState) {

        when(authState) {
            AuthState.AUTHORIZED -> startActivity(Intent(this, MainHostFragment::class.java))
            AuthState.UNAUTHORIZED -> router.newRootScreen(SignInFragment.getInstanceSignInFragment())
        }
    }

    private fun customNavigator(): AppNavigator = object : AppNavigator(this, binding.fragmentContainerView.id) {

        override fun setupFragmentTransaction(
            screen: FragmentScreen,
            fragmentTransaction: FragmentTransaction,
            currentFragment: Fragment?,
            nextFragment: Fragment
        ) {

            fragmentTransaction.setCustomAnimations(
                R.anim.slide_enter_from_right, R.anim.slide_exit_to_left,
                R.anim.slide_enter_from_left, R.anim.slide_exit_to_right
            )
        }

        override fun applyCommands(commands: Array<out Command>) {
            super.applyCommands(commands)
        }
    }

    override fun onStop() {
        holder.removeNavigator()
        super.onStop()
    }
}