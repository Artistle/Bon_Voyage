package com.hackaton.bonvoyage.coreFeatures.ui.createTour.description

import android.text.Editable
import android.text.TextWatcher
import android.widget.TextView
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.hackaton.bonvoyage.coreFeatures.BaseFragment
import com.hackaton.bonvoyage.databinding.CreateTourDescriptionFragmentBinding

class DescriptionFragment: BaseFragment<CreateTourDescriptionFragmentBinding>(CreateTourDescriptionFragmentBinding::inflate) {

    override fun onStart() {
        super.onStart()

        binding.titleText.addTextChangedListener(CustomTextWatcher(binding))
        binding.descriptionEditText.addTextChangedListener(CustomTextWatcher(binding))
        binding.durationEditText.addTextChangedListener(CustomTextWatcher(binding))
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