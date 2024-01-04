package com.aster.android.feature.home.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import com.aster.android.R
import com.aster.android.base.BaseFragment
import com.aster.android.databinding.FragmentMatchBinding
import com.aster.android.feature.home.repository.HomeRepository
import com.aster.android.feature.home.viewmodel.HomeViewModel
import com.aster.android.feature.home.viewmodel.factory.HomeViewModelFactory

class MatchFragment : BaseFragment<FragmentMatchBinding>(R.layout.fragment_match) {

    private val homeRepository: HomeRepository by lazy {
        HomeRepository()
    }

    private val homeViewModelFactory: HomeViewModelFactory by lazy {
        HomeViewModelFactory(homeRepository, editor)
    }

    private val homeViewModel: HomeViewModel by lazy {
        ViewModelProvider(this, homeViewModelFactory)[HomeViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.matchFragment = this

        binding.searchMatch.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }

            override fun onQueryTextSubmit(query: String?): Boolean {

                if (query != null){
                    Log.d("TEST","s"+query)
                    /*val fragment = fragmentManager?.findFragmentById(R.id.vp_home) as? HomeFragment
                    fragment?.performSearch(query)*/
                    homeViewModel.getMatching(query)
                }
                return true
            }

        })


    }
}