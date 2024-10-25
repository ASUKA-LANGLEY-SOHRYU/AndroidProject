package com.example.androidproject.presenter.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.androidproject.R
import com.example.androidproject.databinding.FragmentListBinding
import com.example.androidproject.presenter.adapter.AnimeListAdapter
import com.example.androidproject.presenter.adapter.SpaceItemDecorator
import com.example.androidproject.presenter.model.AnimeListItem
import com.example.androidproject.presenter.ui.details.AnimeFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private lateinit var adapter: AnimeListAdapter
    private val vm by viewModel<ListViewModel>()

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAnimeList()
        observeLiveData()
        //TODO: Загрузка новых аниме после пролистывания
        //TODO: Поиск
        //TODO: Больше инфы в AnimeFragment
    }

    private fun initAnimeList(){
        adapter = AnimeListAdapter()
        adapter.setOnButtonClickListener(object : AnimeListAdapter.OnButtonClickListener{
            override fun onButtonClick(position: Int) {
                onAnimeDetailsClick(position)
            }
        })
        binding.animeList.adapter = adapter
        binding.animeList.addItemDecoration(SpaceItemDecorator(40))
    }

    private fun observeLiveData(){
        vm.animeListItems.observe(viewLifecycleOwner, Observer(::onAnimeDownloaded))
    }


    private fun onAnimeDownloaded(value: MutableList<AnimeListItem>){
        adapter.setAnime(value)
        if (value.isNotEmpty()){
            binding.progressBar.visibility = View.GONE
            binding.animeList.visibility = View.VISIBLE
        }
    }

    private fun onAnimeDetailsClick(id: Int){
        val title = vm.animeListItems.value?.get(id)?.title ?: "Err"
        val pictureURL = vm.animeListItems.value?.get(id)?.smallImageUrl ?: "Err"
        val description = (vm.animeListItems.value?.get(id)?.description ?: "Err")
        val bundle = bundleOf(
            AnimeFragment.TITLE_KEY to title,
            AnimeFragment.PICTURE_URL_KEY to pictureURL,
            AnimeFragment.DESCRIPTION_KEY to description
        )
        findNavController().navigate(R.id.action_navigation_home_to_animeFragment, bundle)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}