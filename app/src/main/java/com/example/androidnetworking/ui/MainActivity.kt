package com.example.androidnetworking.ui

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProviders
import com.example.androidnetworking.R
import com.example.androidnetworking.models.WeatherResponse
import com.example.androidnetworking.network.ApiModel
import com.example.androidnetworking.network.RetrofitBuilder
import com.example.androidnetworking.network.Status
import com.google.android.material.appbar.AppBarLayout


class MainActivity : AppCompatActivity() {


    private lateinit var searchView: SearchView
    private lateinit var searchItem: MenuItem
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Toolbar>(R.id.toolbar).inflateMenu(R.menu.menu_search)

        searchItem = findViewById<AppBarLayout>(R.id.appBar).findViewById<Toolbar>(R.id.toolbar).menu.findItem(
            R.id.search_item
        )
        searchView = searchItem.actionView as SearchView


        viewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(RetrofitBuilder)
        ).get(MainViewModel::class.java)


        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                viewModel.fetchCurrentWeather(query).observe(this@MainActivity,::onResponse)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }

        })

    }

    private fun onResponse(apiModel: ApiModel<WeatherResponse>?) {
        when(apiModel?.status){
            Status.ERROR -> {
                Toast.makeText(this, apiModel.message, Toast.LENGTH_SHORT).show()
            }
            Status.SUCCESS -> {
                Toast.makeText(this, apiModel.data?.location?.country.toString(), Toast.LENGTH_SHORT).show()
            }
            Status.LOADING -> {
                Toast.makeText(this, "loading", Toast.LENGTH_SHORT).show()
            }
        }
    }


}

