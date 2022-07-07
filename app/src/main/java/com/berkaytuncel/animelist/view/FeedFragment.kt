package com.berkaytuncel.animelist.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.berkaytuncel.animelist.R
import com.berkaytuncel.animelist.adapter.AnimeAdapter
import com.berkaytuncel.animelist.viewmodel.FeedViewModel
import kotlinx.android.synthetic.main.fragment_feed.*

class FeedFragment : Fragment() {

    private lateinit var viewModel: FeedViewModel
    private val animeAdapter = AnimeAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_feed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(FeedViewModel::class.java)
        viewModel.refreshData()

        animeList.layoutManager = LinearLayoutManager(context)
        animeList.adapter = animeAdapter

        /*
        fragment_button.setOnClickListener{
            val action = FeedFragmentDirections.actionFeedFragmentToAnimeFragment()
            Navigation.findNavController(it).navigate(action)
        }
         */
        observeLiveData()
    }

    fun observeLiveData() {
        viewModel.anime.observe(viewLifecycleOwner, Observer {
            it?.let {
                animeList.visibility = View.VISIBLE
                animeAdapter.updateAnimeList(it)
            }
        })

        viewModel.animeError.observe(viewLifecycleOwner, Observer {
            it?.let {
                if (it) {
                    animeError.visibility = View.VISIBLE
                } else {
                    animeError.visibility = View.GONE
                }
            }
        })

        viewModel.animeLoading.observe(viewLifecycleOwner, Observer {
            it?.let {
                if (it) {
                    animeLoading.visibility = View.VISIBLE
                    animeList.visibility = View.GONE
                    animeError.visibility = View.GONE
                } else {
                    animeLoading.visibility = View.GONE
                }
            }
        })
    }
} 