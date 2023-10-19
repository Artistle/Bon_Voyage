package com.hackaton.bonvoyage.features.main.main.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hackaton.bonvoyage.R
import com.hackaton.bonvoyage.databinding.ItemMainSelectionTourBinding
import com.hackaton.entity.SelectionTour

class MainSelectionAdapter(
    private val selections: ArrayList<SelectionTour>
): RecyclerView.Adapter<MainSelectionAdapter.MainSelectionViewHolder>() {

    private lateinit var binding: ItemMainSelectionTourBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainSelectionViewHolder {
        binding = ItemMainSelectionTourBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainSelectionViewHolder(binding)
    }

    override fun getItemCount(): Int = selections.size

    override fun onBindViewHolder(holder: MainSelectionViewHolder, position: Int) {
        holder.bindData(selections[position])
    }

    inner class MainSelectionViewHolder(binding: ItemMainSelectionTourBinding): RecyclerView.ViewHolder(binding.root) {

        fun bindData(tour: SelectionTour) {
            binding.sectionTourTitle.text = tour.title


            /**
             * MOCK
             */
            binding.sectionTourImage.setImageResource(R.drawable.img)
        }
    }
}