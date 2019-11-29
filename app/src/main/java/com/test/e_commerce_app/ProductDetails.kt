package com.test.e_commerce_app

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.product_details.*

class ProductDetails: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.product_details)

        val title = intent.getStringExtra("Title")
        val price = intent.getStringExtra("price")
        val img = intent.getStringExtra("photo")
        product_name.text = title
       // price_detail.text = price
        //photo = img
        availability.setOnClickListener {
            AlertDialog.Builder(this)
                    .setMessage("Hey, $title is in Stock")
                    .setPositiveButton("OK") { p0, p1 ->

                    }
                    .create()
                    .show()
        }
    }
}