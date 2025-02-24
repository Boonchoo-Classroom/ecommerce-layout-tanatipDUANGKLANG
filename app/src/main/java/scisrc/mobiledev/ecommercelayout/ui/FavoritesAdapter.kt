package scisrc.mobiledev.ecommercelayout.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import scisrc.mobiledev.ecommercelayout.R

// ใช้ imageResId แทน colorHex
data class FavoriteItem(val imageResId: Int, val name: String, val price: String)

class FavoritesAdapter(private val favoriteItems: List<FavoriteItem>) :
    RecyclerView.Adapter<FavoritesAdapter.FavoritesViewHolder>() {

    class FavoritesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageProduct: ImageView = view.findViewById(R.id.imageProduct)
        val textName: TextView = view.findViewById(R.id.textProductName)
        val textPrice: TextView = view.findViewById(R.id.textProductPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_favorite, parent, false)
        return FavoritesViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavoritesViewHolder, position: Int) {
        val item = favoriteItems[position]
        holder.imageProduct.setImageResource(item.imageResId) // ใช้รูปภาพจาก drawable
        holder.textName.text = item.name
        holder.textPrice.text = item.price
    }

    override fun getItemCount() = favoriteItems.size
}
