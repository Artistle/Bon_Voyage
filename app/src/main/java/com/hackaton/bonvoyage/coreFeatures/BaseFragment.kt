package com.hackaton.bonvoyage.coreFeatures

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.hackaton.core_di.nameDeep
import com.hackaton.core_di.qualifiers.Qualifiers
import com.hackaton.core_di.qualifiers.featureQualifiers.FeaturesQualifiers
import org.koin.android.ext.android.getKoin
import org.koin.android.ext.android.inject
import kotlin.reflect.KClass

abstract class BaseFragment<VB : ViewBinding>(
    private val inflateMethod: (LayoutInflater, ViewGroup?, Boolean) -> VB
) : Fragment() {

    private var _binding: VB? = null
    val binding: VB by lazy { _binding!! }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = inflateMethod.invoke(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}