package scisrc.mobiledev.ecommercelayout.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import scisrc.mobiledev.ecommercelayout.R

class ProductListFragment : Fragment(R.layout.fragment_product_list) {

    private lateinit var recyclerView: RecyclerView
    private lateinit var categoryAdapter: CategoryAdapter

    private val categoryList = listOf(
        CategoryItem(R.drawable.headphone, "หูฟังเกมมิ่ง"),
        CategoryItem(R.drawable.mouse, "เมาส์เกมมิ่ง"),
        CategoryItem(R.drawable.keyboard, "คีย์บอร์ดเกมมิ่ง"),
        CategoryItem(R.drawable.monitor, "จอเกมมิ่ง"),
        CategoryItem(R.drawable.mousepad, "แผ่นรองเมาส์"),
        CategoryItem(R.drawable.speaker, "ลำโพง")
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerViewCategories)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        categoryAdapter = CategoryAdapter(categoryList)
        recyclerView.adapter = categoryAdapter
    }

    private fun openProductDetail(categoryName: String) {
        val fragment = ProductDetailFragment().apply {
            arguments = Bundle().apply {
                putString("category_name", categoryName)
            }
        }

        // ใช้ beginTransaction() แทน commit {} ถ้ายังพบ error
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }

    data class CategoryItem(val imageResId: Int, val name: String)

    private inner class CategoryAdapter(private val categories: List<CategoryItem>) :
        RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_category, parent, false)
            return CategoryViewHolder(view)
        }

        override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
            holder.bind(categories[position])
        }

        override fun getItemCount() = categories.size

        inner class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            private val imageCategory: ImageView = itemView.findViewById(R.id.imageCategory)
            private val textCategoryName: TextView = itemView.findViewById(R.id.textCategoryName)

            fun bind(category: CategoryItem) {
                imageCategory.setImageResource(category.imageResId)
                textCategoryName.text = category.name
                itemView.setOnClickListener {
                    openProductDetail(category.name)
                }
            }
        }
    }
}
