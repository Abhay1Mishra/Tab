package com.example.tab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadFragment(Home())
        var bottomNav = findViewById<BottomNavigationView>(R.id.bottom_nav)
        bottomNav.setOnNavigationItemReselectedListener {
            when(it.itemId){
                R.id.home -> {
                    loadFragment(Home())
                    return@setOnNavigationItemReselectedListener
                }
                R.id.dashbode ->
                {
                    loadFragment(dash())
                    return@setOnNavigationItemReselectedListener
                }
                R.id.notifi -> {
                    loadFragment(notify())
                    return@setOnNavigationItemReselectedListener
                }
                else -> false
            }
        }

    }
    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}