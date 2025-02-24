package scisrc.mobiledev.ecommercelayout.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import scisrc.mobiledev.ecommercelayout.R
import scisrc.mobiledev.ecommercelayout.databinding.FragmentHomeBinding
import scisrc.mobiledev.ecommercelayout.ui.adapters.ProductAdapter
import scisrc.mobiledev.ecommercelayout.ui.adapters.PromotionAdapter
import scisrc.mobiledev.ecommercelayout.ui.adapters.ProductItem
import scisrc.mobiledev.ecommercelayout.ui.adapters.PromotionItem

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // ตั้งค่าแบนเนอร์ (ใช้รูปภาพแทนสี)
        binding.bannerView.setImageResource(R.drawable.banner)

        // ตั้งค่า RecyclerView สำหรับสินค้าแนะนำ
        val recommendedProducts = listOf(
            ProductItem(R.drawable.keyboard, "Keyboard Pro"),
            ProductItem(R.drawable.monitor, "Monitor 144hz"),
            ProductItem(R.drawable.mouse, "Mouse Logitech X"),
            ProductItem(R.drawable.speaker, "Speaker 4.0")
        )
        binding.recommendedProductsRecycler.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.recommendedProductsRecycler.adapter = ProductAdapter(recommendedProducts)

        // ตั้งค่า RecyclerView สำหรับโปรโมชั่น
        val promotions = listOf(
            PromotionItem(R.drawable.mousepad, "Mousepad ลด 50%"),
            PromotionItem(R.drawable.mouse, "Mouse ลด 80%"),
            PromotionItem(R.drawable.keyboard, "Keyboard ลด 99%")
        )
        binding.promotionsRecycler.layoutManager = LinearLayoutManager(context)
        binding.promotionsRecycler.adapter = PromotionAdapter(promotions)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
