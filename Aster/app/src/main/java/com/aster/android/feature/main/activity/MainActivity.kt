package com.aster.android.feature.main.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.aster.android.R
import com.aster.android.base.BaseActivity
import com.aster.android.databinding.ActivityMainBinding
import com.aster.android.feature.feed.fragment.FeedFragment
import com.aster.android.feature.home.fragment.HomeFragment
import com.aster.android.feature.myPage.fragment.MyPageFragment
import com.aster.android.feature.ranking.fragment.RankingFragment

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initNavigationBar()
    }

    private fun initNavigationBar() {
        supportFragmentManager.beginTransaction().replace(R.id.menu_frame_layout, HomeFragment())
            .commit()

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.main_menu_home -> {
                    replaceFragment(HomeFragment())
                }
                R.id.main_menu_ranking -> {
                    replaceFragment(RankingFragment())
                }
                R.id.main_menu_feed -> {
                    replaceFragment(FeedFragment())
                }
                R.id.main_menu_myPage -> {
                    replaceFragment(MyPageFragment())
                }
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment): Int {
        return supportFragmentManager.beginTransaction().replace(R.id.menu_frame_layout, fragment)
            .commitAllowingStateLoss()
    }
}