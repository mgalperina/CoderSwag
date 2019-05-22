package com.mgalperina.coderswag.Controller

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.ArrayAdapter
import android.widget.Toast
import com.mgalperina.coderswag.Adapters.CategoryAdapter
import com.mgalperina.coderswag.Adapters.CategoryRecycleAdapter
import com.mgalperina.coderswag.Model.Category
import com.mgalperina.coderswag.R
import com.mgalperina.coderswag.Services.DataService
import com.mgalperina.coderswag.Utilities.EXTRA_CATEGORY
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var  adapter : CategoryRecycleAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = CategoryRecycleAdapter(this, DataService.categories) { category ->
            val productIntent = Intent(this, ProductsActivity::class.java)
            productIntent.putExtra(EXTRA_CATEGORY, category.title)
            startActivity(productIntent)

        }
        category_listview.adapter = adapter

        val layoutManager = LinearLayoutManager(this)
        category_listview.layoutManager = layoutManager
        category_listview.setHasFixedSize(true)




        }
    }





