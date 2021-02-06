package com.example.materialdesign_bottomnavview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, createHomeFragment())
            .commit()

        setUpBottomNavigation()
    }

    private fun setUpBottomNavigation() {
        bottomNavigationView = findViewById(R.id.bottomNavView)
        bottomNavigationView.setOnNavigationItemSelectedListener {
            val transaction = supportFragmentManager
                    .beginTransaction()

            val fragment = when (it.itemId) {
                R.id.itemHome -> createHomeFragment()
                R.id.itemFavorite -> createFavoriteFragment()
                R.id.itemMap -> createMapFragment()
                else -> createHomeFragment()
            }

            transaction
                    .replace(R.id.container, fragment)
                    .commit()
            true
        }

    }

    private fun createHomeFragment() = HomeFragment()
    private fun createFavoriteFragment() = FavoriteFragment()
    private fun createMapFragment() = MapFragment()
}
