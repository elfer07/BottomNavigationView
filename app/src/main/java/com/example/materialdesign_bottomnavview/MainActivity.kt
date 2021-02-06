package com.example.materialdesign_bottomnavview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, createHomeFragment())
            .commit()
    }

    private fun createHomeFragment() = HomeFragment()
    private fun createFavoriteFragment() = FavoriteFragment()
    private fun createMapFragment() = MapFragment()
}
