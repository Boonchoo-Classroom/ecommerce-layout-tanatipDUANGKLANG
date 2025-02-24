package scisrc.mobiledev.ecommercelayout.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import scisrc.mobiledev.ecommercelayout.R

class ProductListFragment : Fragment(R.layout.fragment_product_list) {

    private lateinit var recyclerView: RecyclerView
    private val categoryList = listOf(
        "อุปกรณ์เครื่องเขียน",
        "เครื่องใช้ไฟฟ้า",
        "อุปกรณ์กีฬา",
        "อุปกรณ์ไอที",
        "เสื้อผ้า",
        "ของใช้ในบ้าน"
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerViewCategories)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = CategoryAdapter(categoryList)
    }

    private inner class CategoryAdapter(private val categories: List<String>) :
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
            private val textCategoryName: TextView = itemView.findViewById(R.id.textCategoryName)

            fun bind(category: String) {
                textCategoryName.text = category
                itemView.setOnClickListener {
                    openProductDetail(category)
                }
            }
        }
    }

    private fun openProductDetail(categoryName: String) {
        val fragment = ProductDetailFragment().apply {
            arguments = Bundle().apply {
                putString("category_name", categoryName)
            }
        }

        parentFragmentManager.commit {
            replace(R.id.fragment_container, fragment)
            addToBackStack(null)
        }
    }
}
