package scisrc.mobiledev.ecommercelayout.ui

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

        // Mock ข้อมูลรายการโปรด (ใช้รูปภาพจาก drawable)
        val favoriteItems = listOf(
            FavoriteItem(R.drawable.headphone, "หูฟังบลูทูธ", "฿1,200"),
            FavoriteItem(R.drawable.keyboard, "คีย์บอร์ดแมคคานิคอล", "฿2,500"),
            FavoriteItem(R.drawable.mouse, "เมาส์เกมมิ่ง", "฿800"),
            FavoriteItem(R.drawable.monitor, "จอภาพ 144Hz", "฿5,900")
        )

        favoritesAdapter = FavoritesAdapter(favoriteItems)
        recyclerViewFavorites.adapter = favoritesAdapter
    }
}
