package com.aster.android.feature.home.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.aster.android.feature.home.fragment.MatchBothFragment
import com.aster.android.feature.home.fragment.MatchFragment

class HomeViewPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    val fragments : List<Fragment>
    init {
        fragments = listOf(MatchFragment(),MatchBothFragment())
    }
    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }


}