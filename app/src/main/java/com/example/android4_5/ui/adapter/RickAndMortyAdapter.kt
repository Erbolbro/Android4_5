package com.example.android4_5.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.android4_5.databinding.ItemRickAndMortyBinding
import com.example.android4_5.ui.model.CharacterAndLocationResponse

class RickAndMortyAdapter :
    ListAdapter<CharacterAndLocationResponse, RickAndMortyAdapter.RickAndMortyViewHolder>(
        DiffUtilCallback()
    ) {

    class RickAndMortyViewHolder(private val binding: ItemRickAndMortyBinding) :
        ViewHolder(binding.root) {
        fun onBind(data: CharacterAndLocationResponse) = with(binding) {
            Glide.with(itemView.context)
                .load(data.image)
                .into(ivItem)
            tvItem.text = data.name
            tvLocation.text = data.location
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RickAndMortyViewHolder {
        return RickAndMortyViewHolder(
            ItemRickAndMortyBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: RickAndMortyViewHolder, position: Int) {
        getItem(position).let {
            holder.onBind(it)
        }
    }


    companion object {
        class DiffUtilCallback : DiffUtil.ItemCallback<CharacterAndLocationResponse>() {

            override fun areItemsTheSame(
                oldItem: CharacterAndLocationResponse, newItem: CharacterAndLocationResponse
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: CharacterAndLocationResponse, newItem: CharacterAndLocationResponse
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}