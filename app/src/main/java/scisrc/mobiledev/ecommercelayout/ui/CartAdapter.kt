package scisrc.mobiledev.ecommercelayout.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import scisrc.mobiledev.ecommercelayout.R

data class CartItem(val imageResId: Int, val name: String, val price: String, val quantity: Int)

class CartAdapter(private val cartItems: List<CartItem>) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    class CartViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageProduct: ImageView = view.findViewById(R.id.imageProduct)
        val textName: TextView = view.findViewById(R.id.textProductName)
        val textPrice: TextView = view.findViewById(R.id.textProductPrice)
        val textQuantity: TextView = view.findViewById(R.id.textProductQuantity)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cart, parent, false)
        return CartViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val item = cartItems[position]
        holder.imageProduct.setImageResource(item.imageResId)
        holder.textName.text = item.name
        holder.textPrice.text = item.price
        holder.textQuantity.text = "จำนวน: ${item.quantity}"
    }

    override fun getItemCount() = cartItems.size
}
