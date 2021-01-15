package com.example.softuser

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.softuser.fragments.AboutUSFragment
import com.example.softuser.fragments.AddStudentFragment
import com.example.softuser.fragments.HomeFragment

class MainActivity : AppCompatActivity() {
    private lateinit var ihome : TextView
    private lateinit var iaddstudent : TextView
    private lateinit var iaboutus : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ihome = findViewById(R.id.ihome)
        iaddstudent = findViewById(R.id.iaddstudent)
        iaboutus = findViewById(R.id.iaboutus)

        ihome.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.linearcontainer, HomeFragment())
                addToBackStack(null)
                commit()
            }
        }
        iaddstudent.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.linearcontainer, AddStudentFragment())
                addToBackStack(null)
                commit()
            }
        }
        iaboutus.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.linearcontainer, AboutUSFragment())
                addToBackStack(null)
                commit()
            }
        }
    }
}