package com.example.android4_5.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android4_5.R
import com.example.android4_5.databinding.FragmentRickAndMortyBinding
import com.example.android4_5.ui.adapter.RickAndMortyAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RickAndMortyFragment : Fragment(R.layout.fragment_rick_and_morty) {
    private val binding by viewBinding(FragmentRickAndMortyBinding::bind)
    private val viewModel by viewModels<RickAndMortyViewModel>()
    private val rickAndMortyAdapter = RickAndMortyAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupObserver()
    }

    private fun initialize() {
        binding.rvRickAndMorty.adapter = rickAndMortyAdapter
    }

    private fun setupObserver() {
        viewModel.locationCharacter.observe(viewLifecycleOwner) {
            rickAndMortyAdapter.submitList(it)
        }
    }
}