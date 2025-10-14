package com.petshield.app.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.petshield.app.databinding.ItemPetBinding
import com.petshield.app.model.Pet

class PetsAdapter : RecyclerView.Adapter<PetsAdapter.VH>() {

    private val items = ArrayList<Pet>()

    fun submitList(list: List<Pet>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val binding = ItemPetBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VH(binding)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val pet = items[position]
        holder.bind(pet)
    }

    override fun getItemCount(): Int = items.size

    class VH(private val b: ItemPetBinding) : RecyclerView.ViewHolder(b.root) {
        fun bind(p: Pet) {
            b.tvName.text = p.name
            b.tvDetails.text = "${p.species} • ${p.breed} • ${p.ageMonths} months"

        }
    }
}
