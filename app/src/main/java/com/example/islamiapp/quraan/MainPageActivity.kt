package com.example.islamiapp.quraan
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.islamiapp.R
import com.example.islamiapp.fragments.HadethFragment
import com.example.islamiapp.fragments.QuraanFragment
import com.example.islamiapp.fragments.RadioFragment
import com.example.islamiapp.fragments.TasbehFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
class MainPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.navigation_bar)
        if (savedInstanceState == null) {
            bottomNavigationView.selectedItemId = R.id.quraan
            supportFragmentManager.beginTransaction()
                .replace(R.id.main, QuraanFragment())
                .commit()
        }
        bottomNavigationView.setOnItemSelectedListener { item ->
            var selectedFragment: Fragment? = null
            when (item.itemId) {
                R.id.quraan -> selectedFragment = QuraanFragment()
                R.id.hadeth -> selectedFragment = HadethFragment()
                R.id.sebha -> selectedFragment = TasbehFragment()
                R.id.radio -> selectedFragment = RadioFragment()
            }
            supportFragmentManager.beginTransaction()
                .replace(R.id.main, selectedFragment!!)
                .commit()
            true
        }
    }
}