package com.test.e_commerce_app

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.test.e_commerce_app.model.Product
import android.view.View
import android.view.ViewParent
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class ProductsAdapter(private val products: List<Product>) : RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, ViewType: Int): ViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_row, parent, false)

        val holder = ViewHolder(view)
        view.setOnClickListener {
            val intent = Intent(parent.context, ProductDetails()::class.java)
            intent.putExtra("Title",products[holder.adapterPosition].title)
            intent.putExtra("price",products[holder.adapterPosition].price)
            parent.context.startActivity(intent)

        }
        return holder
    }

    override fun getItemCount() = products.size


    override fun onBindViewHolder(holder: ProductsAdapter.ViewHolder, position: Int) {
        val product = products[position]
        Picasso.get().load(product.photoUrl).into(holder.image)
        holder.title.text = product.title
        holder.price.text = product.price.toString()
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.photo)
        val title: TextView = itemView.findViewById(R.id.title)
        val price: TextView = itemView.findViewById(R.id.price)
    }
}