package com.example.spinnerk

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var spnPaises:Spinner
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        iniciarComponentes()
        spnPaises.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val strModal = "Selecciono el pais " + parent!!.getItemAtPosition(position).toString()
                Toast.makeText(this@MainActivity, strModal, Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun iniciarComponentes(){
        spnPaises = findViewById<Spinner>(R.id.spnPaises)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, resources.getStringArray(R.array.arrayPaises))
        spnPaises.adapter = adapter
    }
}