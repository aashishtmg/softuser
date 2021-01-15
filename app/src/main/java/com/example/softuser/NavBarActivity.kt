package com.example.softuser

import android.os.Bundle
import android.widget.LinearLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.softuser.ui.dashboard.DashboardFragment
import com.example.softuser.ui.home.HomeFragment
import com.example.softuser.ui.notifications.NotificationsFragment
import com.google.android.material.tabs.TabLayout

class NavBarActivity : AppCompatActivity() {
    private lateinit var btmnavview:BottomNavigationView
    private lateinit var linearconainer:LinearLayout
    var lstStudent = ArrayList<student>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nav_bar)
        btmnavview=findViewById(R.id.nav_view)
        linearconainer=findViewById(R.id.nav_host_fragment)

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.nav_host_fragment,HomeFragment())
            addToBackStack(null)
            commit()
        }
        btmnavview.setOnNavigationItemReselectedListener {
            when (it.itemId) {
                R.id.navigation_home -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.nav_host_fragment, HomeFragment())
                        addToBackStack(null)
                        commit()
                    }
                    true
                }
                R.id.navigation_addstudent -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.nav_host_fragment, DashboardFragment())
                        addToBackStack(null)
                        commit()
                    }
                    true
                }
                R.id.navigation_aboutus -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.nav_host_fragment, NotificationsFragment())
                        addToBackStack(null)
                        commit()
                    }
                    true
                }
                else -> false
            }
        }
        loadStudent()

    }

    private fun loadStudent() {
        lstStudent.add(student(0, "Aashish Tamang", "Kathmandu", "22", "https://pbs.twimg.com/profile_images/778694462218174464/2dhhdbli.jpg","Male"))
    }
}