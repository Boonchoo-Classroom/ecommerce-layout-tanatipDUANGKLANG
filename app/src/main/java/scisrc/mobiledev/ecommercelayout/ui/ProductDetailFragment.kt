package scisrc.mobiledev.ecommercelayout.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import scisrc.mobiledev.ecommercelayout.R

class ProductDetailFragment : Fragment(R.layout.fragment_product_detail) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textProductDetail = view.findViewById<TextView>(R.id.textProductDetail)
        val btnBack = view.findViewById<Button>(R.id.btnBack)

        val categoryName = arguments?.getString("category_name") ?: "ไม่ระบุ"
        textProductDetail.text = "รายละเอียดสินค้าในหมวดหมู่: $categoryName"

        // ตั้งค่าปุ่มย้อนกลับ
        btnBack.setOnClickListener {
            parentFragmentManager.popBackStack() // กลับไปยังหน้าก่อนหน้า
        }
    }
}
