package com.example.androidproject.presenter.ui.details

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.androidproject.R
import com.example.androidproject.databinding.FragmentAnimeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class AnimeFragment : Fragment() {
    private lateinit var binding: FragmentAnimeBinding
    private val vm by viewModel<AnimeDetailsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnimeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeLiveData()
        vm.setTitle(requireArguments().getString(TITLE_KEY, DEFAULT))
        init()
    }

    private fun init() {
        binding.apply {
            animeTitle.text = vm.title.value
            animeDescription.text = requireArguments().getString(DESCRIPTION_KEY, DEFAULT)
            val pictureUrl = requireArguments().getString(PICTURE_URL_KEY, DEFAULT)

            Glide.with(requireContext())
                .load(pictureUrl).transform(RoundedCorners(10))
                .error(R.drawable.ic_launcher_foreground)
                .placeholder(R.drawable.progress_bar_default)
                .into(animeImage)

        }
    }

    private fun observeLiveData(){
        vm.title.observe(viewLifecycleOwner) { newTitle ->
            (requireActivity() as AppCompatActivity).supportActionBar?.title = newTitle
        }
    }


    companion object {
        const val TITLE_KEY = "TITLE"
        const val DESCRIPTION_KEY = "DESC"
        const val PICTURE_URL_KEY = "PICTURE"
        const val DEFAULT = "ERROR"
    }
}