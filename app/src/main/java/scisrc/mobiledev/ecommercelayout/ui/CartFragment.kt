package scisrc.mobiledev.ecommercelayout.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import scisrc.mobiledev.ecommercelayout.R

class CartFragment : Fragment(R.layout.fragment_cart) {

    private lateinit var recyclerViewCart: RecyclerView
    private lateinit var cartAdapter: CartAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerViewCart = view.findViewById(R.id.recyclerViewCart)
        recyclerViewCart.layoutManager = LinearLayoutManager(requireContext())

        // Mock ข้อมูลสินค้าในตะกร้า (ใช้รูปภาพแทน)
        val cartItems = listOf(
            CartItem(R.drawable.headphone, "หูฟังบลูทูธ", "฿1,200", 1),
            CartItem(R.drawable.keyboard, "คีย์บอร์ดแมคคานิคอล", "฿2,500", 1),
            CartItem(R.drawable.mouse, "เมาส์เกมมิ่ง", "฿800", 2)
        )

        cartAdapter = CartAdapter(cartItems)
        recyclerViewCart.adapter = cartAdapter
    }
}
