package scisrc.mobiledev.ecommercelayout.ui

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import scisrc.mobiledev.ecommercelayout.R

class FavoritesFragment : Fragment(R.layout.fragment_favorites) {

    private lateinit var recyclerViewFavorites: RecyclerView
    private lateinit var favoritesAdapter: FavoritesAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerViewFavorites = view.findViewById(R.id.recyclerViewFavorites)
        recyclerViewFavorites.layoutManager = LinearLayoutManager(requireContext())

        // Mock ข้อมูลรายการโปรด
        val favoriteItems = listOf(
            FavoriteItem("#FFCDD2", "หูฟังบลูทูธ", "฿1,200"),
            FavoriteItem("#C8E6C9", "คีย์บอร์ดแมคคานิคอล", "฿2,500"),
            FavoriteItem("#BBDEFB", "เมาส์เกมมิ่ง", "฿800"),
            FavoriteItem("#FFECB3", "จอภาพ 144Hz", "฿5,900")
        )

        favoritesAdapter = FavoritesAdapter(favoriteItems)
        recyclerViewFavorites.adapter = favoritesAdapter
    }
}
