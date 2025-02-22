package scisrc.mobiledev.ecommercelayout

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import scisrc.mobiledev.ecommercelayout.databinding.ActivityMainBinding
import scisrc.mobiledev.ecommercelayout.ui.CartFragment
import scisrc.mobiledev.ecommercelayout.ui.FavoritesFragment
import scisrc.mobiledev.ecommercelayout.ui.HomeFragment
import scisrc.mobiledev.ecommercelayout.ui.ProductListFragment
import scisrc.mobiledev.ecommercelayout.ui.ProfileFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup toolbar
        setSupportActionBar(binding.toolbar)

        // Initialize navigation
        drawerLayout = binding.drawerLayout

        // Add hamburger icon
        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            binding.toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        // Handle NavigationView item clicks
        binding.navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, HomeFragment())
                        .commit()
                }
                R.id.nav_product_list -> {
                    // Replace with ProductListFragment
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, ProductListFragment())
                        .commit()
                }
                R.id.nav_cart -> {
                    // Replace with CartFragment
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, CartFragment())
                        .commit()
                }
                R.id.nav_profile -> {
                    // Replace with ProfileFragment
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, ProfileFragment())
                        .commit()
                }
                R.id.nav_favorites -> {
                    // Replace with FavoritesFragment
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, FavoritesFragment())
                        .commit()
                }
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }


        // Load default fragment
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, HomeFragment())
                .commit()
            binding.navView.setCheckedItem(R.id.nav_home)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}