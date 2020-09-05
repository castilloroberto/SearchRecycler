package com.roberto.searchrecycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recipeList = Model.getRecipesFromFile("data.json", this)
        val adapter = MyAdapter(recipeList,this )


        rv_recyclerView.layoutManager = LinearLayoutManager(this)
        rv_recyclerView.adapter = adapter

    }
}