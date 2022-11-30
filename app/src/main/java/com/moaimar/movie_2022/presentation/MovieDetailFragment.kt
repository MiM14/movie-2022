package com.moaimar.movie_2022.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.moaimar.app.extensions.loadUrl
import com.moaimar.movie_2022.databinding.FragmentMovieDetailBinding
import com.moaimar.movie_2022.domain.GetMovieDetailUseCase

class MovieDetailFragment : Fragment() {
    private var binding: FragmentMovieDetailBinding? = null
    private val viewModel by lazy {
        MovieFactory().getMovieDetailViewModel(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieDetailBinding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpObservers()
        viewModel?.loadMovieDetail(getMovieId())
    }

    private fun setUpObservers() {
        val movieDetailSubscriber =
            Observer<MovieDetailViewModel.MovieDetailUiState> { uiState ->
                uiState.movieDetail?.let {
                    bind(it)
                }

            }
        viewModel?.movieDetailPublisher?.observe(viewLifecycleOwner,movieDetailSubscriber)
    }
    private fun getMovieId(): String = arguments?.getString("movieId")!!

    private fun bind(model:GetMovieDetailUseCase.MovieDetail){
        binding?.apply {
            mainImage.loadUrl(model.poster)
            title.text = model.title
            year.text = model.year
            genre.text = model.genre
            rating.text = model.rating
            plot.text = model.plot
        }
    }
}