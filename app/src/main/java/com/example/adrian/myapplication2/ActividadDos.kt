package com.example.adrian.myapplication2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_actividad_dos.*

class ActividadDos : AppCompatActivity() {

    var nombreBoton = "Atras"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad_dos)
        boton_dos.text = nombreBoton

        val s = intent.getStringExtra("nombreBoton")
        val c = intent.getStringExtra(Intent.EXTRA_TEXT)
        Log.i("create", "El string sacado es: $s")
        Log.i("create", "El string sacado del mail es: $c")
        boton_dos.setOnClickListener { view: View? ->
            irAActividadMain()
        }
    }

    fun irAActividadMain() {
        val intentMainActivity = Intent(this, MainActivity::class.java)
        startActivity(intentMainActivity)
    }
}
