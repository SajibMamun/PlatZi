package com.example.platzi.ui.productadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.platzi.data.models.product.ProductResponseItem
import com.example.platzi.databinding.AllproductitemBinding

class productadapter():ListAdapter<ProductResponseItem, productadapter.ProductViewHolder> (COMPARATOR) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(
            AllproductitemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        )
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {

        getItem(position).let {
            holder.binding.productTitle.text = it.title
            holder.binding.productDescription.text = it.description
            holder.binding.productPrice.text = "Price : $${it.price}"

            it.images?.get(0)?.let { img_url ->
                holder.binding.productImage.load(img_url)
            }





            it.category?.let { ctg ->
                holder.binding.categoryName.text = ctg.name
            }

        }


    }

    class ProductViewHolder(val binding: AllproductitemBinding) :
        RecyclerView.ViewHolder(binding.root)

    companion object {

        val COMPARATOR = object : DiffUtil.ItemCallback<ProductResponseItem>() {
            override fun areItemsTheSame(
                oldItem: ProductResponseItem, newItem: ProductResponseItem
            ): Boolean {

                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: ProductResponseItem, newItem: ProductResponseItem
            ): Boolean {
                return oldItem.id == newItem.id
            }
        }


    }
}