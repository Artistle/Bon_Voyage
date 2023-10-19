package com.hackaton.bonvoyage.coreFeatures.ui.createTour.description

import android.text.Editable
import android.text.TextWatcher
import android.widget.TextView
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.hackaton.bonvoyage.coreFeatures.BaseFragment
import com.hackaton.bonvoyage.coreFeatures.ui.createTour.chooseTourType.ChooseTourTypeFragment
import com.hackaton.bonvoyage.databinding.CreateTourDescriptionFragmentBinding
import com.hackaton.bonvoyage.features.main.main.MainFragment
import com.hackaton.core_di.qualifiers.NavigationQualifiers
import org.koin.android.ext.android.inject
import org.koin.core.qualifier.named

class DescriptionFragment: BaseFragment<CreateTourDescriptionFragmentBinding>(CreateTourDescriptionFragmentBinding::inflate) {

    private val router: Router by inject(named(NavigationQualifiers.ROUTER_MAIN))

    override fun onStart() {
        super.onStart()

        binding.titleText.addTextChangedListener(CustomTextWatcher(binding))
        binding.descriptionEditText.addTextChangedListener(CustomTextWatcher(binding))
        binding.durationEditText.addTextChangedListener(CustomTextWatcher(binding))

        binding.btnNext.setOnClickListener {
        }

        binding.btnBack.setOnClickListener {
            router.navigateTo(ChooseTourTypeFragment.getInstanceProfileFragment())
        }

        binding.createTourView.btnSaveAndExit.setOnClickListener {
            router.navigateTo(FragmentScreen{ MainFragment() })
        }
    }

    class CustomTextWatcher(private val binding: CreateTourDescriptionFragmentBinding) : TextWatcher {
        override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
        override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
            binding.btnNext.isClickable = !isEmpty(binding.titleText)
                    && !isEmpty(binding.descriptionEditText)
                    && !isEmpty(binding.durationEditText)
        }
        override fun afterTextChanged(editable: Editable) {}

        private fun isEmpty(textView: TextView) : Boolean {
            return textView.getText().toString().trim().isEmpty()
        }
    }

    companion object {
        fun getInstanceProfileFragment() = FragmentScreen { DescriptionFragment() }
    }
}