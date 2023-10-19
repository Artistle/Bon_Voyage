package com.hackaton.bonvoyage.features.main.fragmentHost

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.hackaton.bonvoyage.R
import com.hackaton.bonvoyage.databinding.ActivityAppBinding
import com.hackaton.bonvoyage.features.main.habitation.HabitationFragment
import com.hackaton.bonvoyage.features.main.main.MainFragment
import com.hackaton.bonvoyage.features.main.profile.ProfileFragment
import com.hackaton.core_di.nameDeep
import com.hackaton.core_di.qualifiers.NavigationQualifiers
import com.hackaton.entity.request.HabitationRequest
import org.koin.android.ext.android.inject
import java.io.File

class MainHostActivity: AppCompatActivity() {

    private lateinit var binding: ActivityAppBinding
    private val router: Router by inject(nameDeep(NavigationQualifiers.ROUTER_MAIN))
    private val holder: NavigatorHolder by inject(nameDeep(NavigationQualifiers.HOLDER_MAIN))
    private val navigator: AppNavigator by lazy {
        customNavigator()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAppBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupBottomNavigationListener()
        holder.setNavigator(navigator)
        router.navigateTo(FragmentScreen{ MainFragment() })
    }

    private fun setupBottomNavigationListener() {
        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.main -> {
                    router.navigateTo(FragmentScreen{ MainFragment() })
                    true
                }
                R.id.account -> { true }
                R.id.habitation -> {
                    router.navigateTo(HabitationFragment.getInstanceProfileFragment())
                    true
                }
                R.id.messenger -> { true }
                R.id.profile -> {
                    router.navigateTo(ProfileFragment.getInstanceProfileFragment())
                    true
                }
                else -> true
            }
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
}