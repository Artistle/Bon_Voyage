package com.hackaton.bonvoyage.features.main.fragmentHost

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.hackaton.bonvoyage.R
import com.hackaton.bonvoyage.databinding.ActivityAppBinding
import com.hackaton.bonvoyage.databinding.ActivityMainBinding
import com.hackaton.bonvoyage.features.main.main.MainFragment
import com.hackaton.core_di.nameDeep
import com.hackaton.core_di.qualifiers.NavigationQualifiers
import org.koin.android.ext.android.inject

class MainHostFragment: AppCompatActivity() {

    private lateinit var binding: ActivityAppBinding
    private val router: Router by inject(nameDeep(NavigationQualifiers.ROUTER))
    private val holder: NavigatorHolder by inject(nameDeep(NavigationQualifiers.HOLDER))
    private val navigator: AppNavigator by lazy {
        AppNavigator(this, binding.fragmentContainerView.id)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAppBinding.inflate(layoutInflater)
        setContentView(binding.root)
        holder.setNavigator(navigator)
        router.navigateTo(FragmentScreen{ MainFragment() })

    }

}