package scisrc.mobiledev.ecommercelayout.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import scisrc.mobiledev.ecommercelayout.R
import scisrc.mobiledev.ecommercelayout.databinding.ItemPromotionBinding

data class PromotionItem(val imageResId: Int, val name: String)

class PromotionAdapter(private val items: List<PromotionItem>) :
    RecyclerView.Adapter<PromotionAdapter.PromotionViewHolder>() {

    class PromotionViewHolder(private val binding: ItemPromotionBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: PromotionItem) {
            binding.promotionName.text = item.name
            binding.promotionImage.setImageResource(item.imageResId) // ใช้รูปภาพแทนสี
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
