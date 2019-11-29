package com.test.e_commerce_app

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.view.GravityCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import com.test.e_commerce_app.model.Product

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.main.*
import org.jetbrains.anko.appcompat.v7.toolbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar())

        supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, MainFragment())
                .commit()

        nav_view.setNavigationItemSelectedListener {
            when(it.itemId){

                R.id.home -> {
                    supportFragmentManager.beginTransaction()
                            .replace(R.id.frameLayout, MainFragment())
                            .commit()
                }
                R.id.jean -> {
                    supportFragmentManager.beginTransaction()
                            .replace(R.id.frameLayout, JeansFragment())
                            .commit()
                }
            }
            it.isChecked = true
            drawerLayout.closeDrawers()
            true
        }

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp)
        }


    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        drawerLayout.openDrawer(GravityCompat.START)
        return true
        //return super.onOptionsItemSelected(item)
    }
}
