package com.example.adrian.myapplication2

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.TextView

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import android.R.attr.data
import android.database.Cursor


var estadoDelJuego: String? = null
var numeroDeVeces = 0

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("create", "Se esta creando la actividad")

        super.onCreate(savedInstanceState)
        // Escoje el conten view de esta actividad
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        // Se establece el estado del juego
        establecerElEstadoDelJuego(savedInstanceState)

        // Inicializa valores
        inicializarValores()

        /*
        val courses = DataManager.Factory.courses

        val adaterCourses = ArrayAdapter<CourseInfo>(this, android.R.layout.simple_spinner_item, courses)
        adaterCourses.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCourses.adapter = adaterCourses

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        */
        boton_main.setOnClickListener { view: View? ->
            irAActividadDos()
        }

        boton_main_dos.setOnClickListener { view: View? ->
            seleccionarContacto()
        }

    }

    fun irAActividadDos() {
        val addressees = arrayOf("emailaddress@emailaddress.com", "pene@culo.com")
//        recipientArray.add("Culo")
//        recipientArray.add("Pene")
//        recipientArray.add("Teta")
//        val intent = Intent(Intent.ACTION_SEND).apply {
//            putExtra(Intent.EXTRA_EMAIL, recipientArray)
//        }
        Log.i("create", "Va a ir al correo")

        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/html"
        intent.putExtra(Intent.EXTRA_EMAIL, addressees)
        intent.putExtra(Intent.EXTRA_SUBJECT, "Subject")
        intent.putExtra(Intent.EXTRA_TEXT, "I'm email body.")
        startActivity(intent)
//        val intentDeActividadDos = Intent(this, ActividadDos::class.java)
//        startActivity(intentDeActividadDos)
    }

    fun seleccionarContacto() {
        startActivityForResult(Intent(Intent.ACTION_PICK, ContactsContract.CommonDataKinds.Phone.CONTENT_URI), PICK_CONTACT_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {
        Log.i("create", "El codigo con el que devuelve el intent es: $requestCode")
        when (requestCode) {
            PICK_CONTACT_REQUEST -> {
                Log.i("create", "el usuario ya selecciono un contacto")
                if (resultCode == RESULT_OK) {
                    Log.i("create", "El usuario ya selecciono un contacto ${intent?.data.toString()}")
                    var cursor: Cursor? = null
                    try {
                        var phoneNo: String? = null
                        var name: String? = null
                        // getData() method will have the Content Uri of the selected contact
                        val uri = intent?.data
                        //Query the content uri
                        cursor = contentResolver.query(uri, null, null, null, null)
                        cursor!!.moveToFirst()
                        // column index of the phone number
                        val phoneIndex = cursor!!.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)
                        // column index of the contact name
                        val nameIndex = cursor!!.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)
                        phoneNo = cursor!!.getString(phoneIndex)
                        name = cursor!!.getString(nameIndex)
                        Log.i("create", "Nombre ${name}")
                        Log.i("create", "Numero de telefono ${phoneNo}")
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }

                }
                if (resultCode == RESULT_CANCELED) {
                    Log.i("create", "Algo salio mal")
                }
            }
        }
    }

    companion object {
        internal val PICK_CONTACT_REQUEST = 0
    }

    override fun onStart() {
        super.onStart()
        Log.i("create", "Se esta starteando la actividad")
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        Log.i("create", "Se esta restorando la instancia de la actividad")
        texto_central.text = savedInstanceState?.getString("GAME_STATE_KEY")
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        outState?.run {
            Log.i("create", "Se esta guardando el estado de la instancia de esta actividad")
            numeroDeVeces++
            putString("GAME_STATE_KEY", "$estadoDelJuego $numeroDeVeces")
        }
        // call superclass to save any view hierarchy
        super.onSaveInstanceState(outState)
    }

    fun inicializarValores() {
        texto_central.text = estadoDelJuego
    }

    override fun onResume() {
        super.onResume()
        Log.i("create", "Resumiendo, iniciando recursos como la camara por ejemplo")
    }

    override fun onPause() {
        super.onPause()
        Log.i("create", "Pausando, momento para liberar la memoria y recursos")
    }

    fun establecerElEstadoDelJuego(savedInstanceState: Bundle?) {
        if (estadoDelJuego == null) {
            estadoDelJuego = "Adrian"
            savedInstanceState?.putString("GAME_STATE_KEY", estadoDelJuego)
            Log.i("create", "Estado del juego $estadoDelJuego")
        }
    }

    override fun onStop() {
        super.onStop()
        Log.i("create", "Se esta parando la actividad aqui se debe de liberar todos los recursos de interfaz, tambien es un buen lugar para almacenar informacion no volatil")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("create", "Va a destruirse la vista, adios a todos")
    }
}


// emulator -avd Nexus_5_API_24