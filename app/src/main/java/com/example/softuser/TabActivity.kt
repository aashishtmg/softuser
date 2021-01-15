package com.example.softuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.softuser.adapter.ViewPagerAdapter
import com.example.softuser.fragments.AboutUSFragment
import com.example.softuser.fragments.AddStudentFragment
import com.example.softuser.fragments.HomeFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class TabActivity : AppCompatActivity() {
    private lateinit var lstTitle: ArrayList<String>
    private lateinit var lstFragments : ArrayList<Fragment>
    private lateinit var viewpager : ViewPager2
    private lateinit var tablayout : TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab)
        viewpager = findViewById(R.id.viewpager)
        tablayout = findViewById(R.id.tablayout)

        populatelist()
        val adapter = ViewPagerAdapter(lstFragments,supportFragmentManager,lifecycle)
        viewpager.adapter = adapter
        TabLayoutMediator(tablayout,viewpager) { tab,position ->
            tab.text = lstTitle[position]
        }.attach()
    }
    private fun populatelist() {
        lstTitle = ArrayList<String>()
        lstTitle.add("Home")
        lstTitle.add("Add Student")
        lstTitle.add("Aboutus")
        lstFragments.add(HomeFragment())
        lstFragments.add(AddStudentFragment())
        lstFragments.add((AboutUSFragment()))
    }
}