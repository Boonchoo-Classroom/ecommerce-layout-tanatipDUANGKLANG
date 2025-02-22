package scisrc.mobiledev.ecommercelayout.ui.adapters

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import scisrc.mobiledev.ecommercelayout.databinding.ItemPromotionBinding

class PromotionAdapter(private val items: List<String>) :
    RecyclerView.Adapter<PromotionAdapter.PromotionViewHolder>() {

    class PromotionViewHolder(private val binding: ItemPromotionBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(name: String) {
            binding.promotionName.text = name
            binding.promotionImage.background = ColorDrawable(Color.DKGRAY) // ใช้สีแทนรูป
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PromotionViewHolder {
        val binding = ItemPromotionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PromotionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PromotionViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size
}
