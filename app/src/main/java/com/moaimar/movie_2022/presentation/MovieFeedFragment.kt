package com.moaimar.movie_2022.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.faltenreich.skeletonlayout.Skeleton
import com.faltenreich.skeletonlayout.applySkeleton
import com.moaimar.movie_2022.R
import com.moaimar.movie_2022.databinding.FragmentMovieFeedBinding
import com.moaimar.movie_2022.presentation.adapter.MovieAdapter

class MovieFeedFragment : Fragment() {
    private var skeleton: Skeleton? = null
    private var binding: FragmentMovieFeedBinding? = null
    private val movieAdapter = MovieAdapter()
    private val viewModel by lazy {
        MovieFactory().getMovieFeedViewModel(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieFeedBinding.inflate(inflater)
        setupView()
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        viewModel.loadMovieFeed()
    }

    private fun setupView() {
        binding?.apply {
            listMovies.apply {
                adapter = movieAdapter
                layoutManager =
                    LinearLayoutManager(
                        requireContext(),
                        LinearLayoutManager.VERTICAL,
                        false
                    )
                movieAdapter.setOnClickItem {
                    navigateToMovieDetail(it)
                }
                skeleton = applySkeleton(R.layout.item_movie_feed,6)
            }
        }
    }

    private fun setupObservers() {
        val movieFeedSubscriber = Observer<MovieFeedViewModel.MovieUiState> {
            if(it.isLoading){
                skeleton?.showSkeleton()
            }else{
                skeleton?.showOriginal()
                movieAdapter.setDataItems(it.movieFeed)
            }
        }
        viewModel.movieFeedPublisher.observe(viewLifecycleOwner, movieFeedSubscriber)
    }
    private fun navigateToMovieDetail(movieId:String){
        findNavController().navigate(
            MovieFeedFragmentDirections.actionMovieFeedToMovieDetail(movieId)
        )
    }
}