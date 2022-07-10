package com.berkaytuncel.animelist.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.berkaytuncel.animelist.R
import com.berkaytuncel.animelist.viewmodel.AnimeViewModel
import kotlinx.android.synthetic.main.fragment_anime.*

class AnimeFragment : Fragment() {

    private lateinit var viewModel: AnimeViewModel

    private var animeUuid = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_anime, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(AnimeViewModel::class.java)
        viewModel.getDataFromRoom()

        arguments?.let {
            animeUuid = AnimeFragmentArgs.fromBundle(it).animeUuid
        }

        observeLiveData()
    }

    private fun observeLiveData() {
        viewModel.animeLiveData.observe(viewLifecycleOwner, Observer {
            it?.let {
                animeName.text = it.data[animeUuid].title //animeName
                animeEpisodes.text = it.data[animeUuid].episodes.toString() //animeEpisodes
                animeStatus.text = it.data[animeUuid].status.toString() //animeStatus
                animeDuration.text = it.data[animeUuid].duration //animeDuration
                animeScore.text = it.data[animeUuid].score.toString() //animeScore
                //animeThemes.text = it.animeThemes
            }
        })
    }
}