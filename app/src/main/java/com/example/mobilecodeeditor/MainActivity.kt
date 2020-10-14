package com.example.mobilecodeeditor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AutoCompleteTextView
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var playGroundCode:AutoCompleteTextView
    lateinit var runCode:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        playGroundCode = findViewById(R.id.playGroundCode)
        runCode = findViewById(R.id.runCode)

        runCode.setOnClickListener {
            executeCode()
        }
    }

    private fun executeCode() {
        val intent = Intent(MainActivity@this,CodeEditor::class.java)
        intent.putExtra("code",playGroundCode.text.toString())
        startActivity(intent)
    }
}