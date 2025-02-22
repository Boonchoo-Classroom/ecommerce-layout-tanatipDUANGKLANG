package scisrc.mobiledev.ecommercelayout.ui

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import scisrc.mobiledev.ecommercelayout.databinding.FragmentHomeBinding
import scisrc.mobiledev.ecommercelayout.ui.adapters.ProductAdapter
import scisrc.mobiledev.ecommercelayout.ui.adapters.PromotionAdapter

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

        // ตั้งค่าแบนเนอร์ (ใช้สีแทนรูปภาพ)
        binding.bannerView.background = ColorDrawable(Color.parseColor("#FF6200EE"))

        // ตั้งค่า RecyclerView สำหรับสินค้าแนะนำ
        val recommendedProducts = listOf("สินค้า 1", "สินค้า 2", "สินค้า 3", "สินค้า 4")
        binding.recommendedProductsRecycler.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.recommendedProductsRecycler.adapter = ProductAdapter(recommendedProducts)

        // ตั้งค่า RecyclerView สำหรับโปรโมชั่น
        val promotions = listOf("โปร 1", "โปร 2", "โปร 3")
        binding.promotionsRecycler.layoutManager = LinearLayoutManager(context)
        binding.promotionsRecycler.adapter = PromotionAdapter(promotions)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
