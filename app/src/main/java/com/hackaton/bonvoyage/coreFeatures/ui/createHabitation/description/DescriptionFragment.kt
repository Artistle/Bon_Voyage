package com.hackaton.bonvoyage.coreFeatures.ui.createHabitation.description

import android.text.Editable
import android.text.TextWatcher
import android.widget.TextView
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.hackaton.bonvoyage.coreFeatures.BaseFragment
import com.hackaton.bonvoyage.databinding.CreateHabitationDescriptionFragmentBinding
import com.hackaton.bonvoyage.features.main.habitation.HabitationFragment
import com.hackaton.bonvoyage.features.main.habitation.createHabitation.chooseHabitationType.ChooseHabitationTypeFragment
import com.hackaton.core_di.qualifiers.NavigationQualifiers
import org.koin.android.ext.android.inject
import org.koin.core.qualifier.named


class DescriptionFragment: BaseFragment<CreateHabitationDescriptionFragmentBinding>(CreateHabitationDescriptionFragmentBinding::inflate) {

    private val router: Router by inject(named(NavigationQualifiers.ROUTER_MAIN))

    override fun onStart() {
        super.onStart()

        binding.titleText.addTextChangedListener(CustomTextWatcher(binding))
        binding.descriptionEditText.addTextChangedListener(CustomTextWatcher(binding))

        binding.btnNext.setOnClickListener {
        }

        binding.btnBack.setOnClickListener {
            router.navigateTo(ChooseHabitationTypeFragment.getInstanceProfileFragment())
        }

        binding.createHabitationView.btnSaveAndExit.setOnClickListener {
            router.navigateTo(HabitationFragment.getInstanceProfileFragment())
        }
    }

    class CustomTextWatcher(private val binding: CreateHabitationDescriptionFragmentBinding) : TextWatcher {
        override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
        override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
            binding.btnNext.isClickable = !isEmpty(binding.titleText)
                    && !isEmpty(binding.descriptionEditText)
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