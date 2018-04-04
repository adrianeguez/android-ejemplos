package com.example.adrian.myapplication2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter

import kotlinx.android.synthetic.main.activity_note_list.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.content_note_list.*

class NoteListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_list)
        setSupportActionBar(toolbar)
        initializeDisplayContent()
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }


    }

    private fun initializeDisplayContent() {
        var notes: ArrayList<NoteInfo> = DataManager.Factory.notes
        val adaterNotes = ArrayAdapter<NoteInfo>(this, android.R.layout.simple_list_item_1, notes)
        list_notes.adapter = adaterNotes
        list_notes.onItemClickListener = AdapterView.OnItemClickListener { parent: AdapterView<*>?,
                                                                           view: View?,
                                                                           position: Int,
                                                                           id: Long ->
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

}
