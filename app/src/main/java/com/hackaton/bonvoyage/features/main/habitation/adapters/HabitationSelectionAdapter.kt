package com.hackaton.bonvoyage.features.main.habitation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hackaton.bonvoyage.R
import com.hackaton.bonvoyage.databinding.ItemHabitationSelectionBinding
import com.hackaton.entity.Habitation

class HabitationSelectionAdapter(
    private val selections: ArrayList<Habitation>
): RecyclerView.Adapter<HabitationSelectionAdapter.HabitationSelectionViewHolder>() {

    private lateinit var binding: ItemHabitationSelectionBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HabitationSelectionViewHolder {
        binding = ItemHabitationSelectionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HabitationSelectionViewHolder(binding)
    }

    override fun getItemCount(): Int = selections.size

    override fun onBindViewHolder(holder: HabitationSelectionViewHolder, position: Int) {
        holder.bindData(selections[position])
    }

    inner class HabitationSelectionViewHolder(binding: ItemHabitationSelectionBinding): RecyclerView.ViewHolder(binding.root) {

        fun bindData(habitation: Habitation) {
            binding.habitationNameTitle.text = habitation.name
            binding.numberOfRoomsText.text = "${habitation.numberOfRooms}-комн. кв."
            binding.floorText.text = "${habitation.floor}/${habitation.maxFloorInBuilding} этаж"
            binding.homeOwnerNameText.text = habitation.ownerName

            /**
             * MOCK
             */
            binding.freeDateText.text = "${habitation.startDate}-${habitation.endDate}"
            binding.previewImage.setImageResource(R.drawable.house_preview_mock)
            binding.homeOwnerImage.setImageResource(R.drawable.home_owner_icon_mock)

            binding.btnBook.setOnClickListener {

            }
        }
    }
}