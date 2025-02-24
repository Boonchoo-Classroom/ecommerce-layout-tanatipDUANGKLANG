package scisrc.mobiledev.ecommercelayout.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import scisrc.mobiledev.ecommercelayout.R

class ProductDetailFragment : Fragment(R.layout.fragment_product_detail) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textProductName = view.findViewById<TextView>(R.id.textProductName)
        val textProductPrice = view.findViewById<TextView>(R.id.textProductPrice)
        val textProductCategory = view.findViewById<TextView>(R.id.textProductCategory)
        val textProductDescription = view.findViewById<TextView>(R.id.textProductDescription)
        val btnBack = view.findViewById<Button>(R.id.btnBack)
        val btnAddToCart = view.findViewById<Button>(R.id.btnAddToCart)

        // ดึงข้อมูลหมวดหมู่จาก arguments
        val categoryName = arguments?.getString("category_name") ?: "ไม่ระบุ"

        // Mock ข้อมูลสินค้า
        val mockProductName = "สินค้าในหมวดหมู่ $categoryName"
        val mockProductPrice = "฿1,990"
        val mockProductDescription = "สินค้าคุณภาพสูง เหมาะสำหรับการใช้งานในชีวิตประจำวัน ผลิตจากวัสดุที่ทนทานและมีดีไซน์สวยงาม"

        // ตั้งค่าข้อมูลใน UI
        textProductName.text = mockProductName
        textProductPrice.text = mockProductPrice
        textProductCategory.text = "หมวดหมู่: $categoryName"
        textProductDescription.text = mockProductDescription

        // ตั้งค่าปุ่มย้อนกลับ
        btnBack.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        // ตั้งค่าปุ่มเพิ่มลงตะกร้า
        btnAddToCart.setOnClickListener {
            Toast.makeText(requireContext(), "เพิ่ม $mockProductName ลงตะกร้าแล้ว", Toast.LENGTH_SHORT).show()
        }
    }
}
