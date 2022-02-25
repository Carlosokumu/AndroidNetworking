package com.example.androidnetworking.ui

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProviders
import coil.load
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
    private lateinit var weatherIcon: ImageView
    private lateinit var txtWeather: TextView
    private lateinit var tempF: TextView
    private lateinit var tempC: TextView


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

        weatherIcon = findViewById(R.id.imageIcon)
        txtWeather = findViewById(R.id.txtWeather)
        tempF = findViewById(R.id.tempF)
        tempC = findViewById(R.id.tempC)

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
                val data = apiModel.data
                weatherIcon.load("https:" + apiModel.data?.current?.condition?.icon)

                txtWeather.text = data?.current?.condition?.text
                tempC.text = data?.current?.temp_c.toString()
                tempF.text = data?.current?.temp_f.toString()
            }
            Status.LOADING -> {
                Toast.makeText(this, "Loading", Toast.LENGTH_SHORT).show()
            }
        }
    }


}

