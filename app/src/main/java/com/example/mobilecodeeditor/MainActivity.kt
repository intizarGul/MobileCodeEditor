package com.example.mobilecodeeditor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
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

   //create the menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
      menuInflater.inflate(R.menu.main,menu)

        return true
    }

    //create the item selection
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val htmlTemplate = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<style>\n" +
                "body {background-color: powderblue;}\n" +
                "h1   {color: blue;}\n" +
                "p    {color: red;}\n" +
                "</style>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<h1>This is a heading</h1>\n" +
                "<p>This is a paragraph.</p>\n" +
                "\n" +
                "</body>\n" +
                "</html>"

        when(item.itemId){
            R.id.ItemInsertHTML ->{
                playGroundCode.setText(htmlTemplate)
                return true
            }
            R.id.itemRun -> {
                executeCode()
                return true
            }
            R.id.itemClear -> {
            playGroundCode.setText("")
            }
            R.id.itemExit -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}