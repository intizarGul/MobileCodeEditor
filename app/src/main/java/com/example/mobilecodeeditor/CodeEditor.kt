package com.example.mobilecodeeditor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class CodeEditor : AppCompatActivity() {
    lateinit var webBrowser:WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_code_editor)

        webBrowser = findViewById(R.id.webBrowser)

        webBrowser.loadData(intent.getStringExtra("code"),"text/html; charset=utf-8",null)
    }
}
