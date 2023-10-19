package com.hackaton.bonvoyage.coreFeatures.ui.adapters

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.hackaton.bonvoyage.R
import com.hackaton.bonvoyage.databinding.ItemSelectionButtonBinding
import com.hackaton.entity.ItemSelection

class ItemSelectionAdapter(
    private val selections: ArrayList<ItemSelection>
): RecyclerView.Adapter<ItemSelectionAdapter.ItemSelectionViewHolder>() {

    private lateinit var binding: ItemSelectionButtonBinding

    private var selectedItemSelectionViewHolder: ItemSelectionViewHolder? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemSelectionViewHolder {
        binding = ItemSelectionButtonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemSelectionViewHolder(binding)
    }

    override fun getItemCount(): Int = selections.size

    override fun onBindViewHolder(holder: ItemSelectionViewHolder, position: Int) {
        holder.bindData(selections[position])
    }

    inner class ItemSelectionViewHolder(binding: ItemSelectionButtonBinding): RecyclerView.ViewHolder(binding.root) {

        fun bindData(itemSelection: ItemSelection) {
            binding.button.text = itemSelection.title
            binding.button.setOnClickListener {
                if(selectedItemSelectionViewHolder != null){
                    selectedItemSelectionViewHolder!!.select(false)
                }
                selectedItemSelectionViewHolder = this
                selectedItemSelectionViewHolder!!.select(true)

                itemSelection.onClickFunc
            }
        }

        @SuppressLint("ResourceAsColor")
        fun select(select: Boolean) {
            val color: Int = if(select){
                R.color.active_item_selection
            } else{
                R.color.inactive_item_selection
            }

            ViewCompat.setBackgroundTintList(binding.button, ColorStateList.valueOf(color))
        }
    }
}