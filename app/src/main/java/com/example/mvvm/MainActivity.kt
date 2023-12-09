package com.example.mvvm


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm.R

class MainActivity : AppCompatActivity() {

    private lateinit var vm: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        vm = ViewModelProvider(this, MainViewModelFactory(this)).get(MainViewModel::class.java)
        val dataTextView = findViewById<TextView>(R.id.dataTextView)
        val dataEditView = findViewById<EditText>(R.id.dataEditText)
        val sendButton = findViewById<Button>(R.id.sendButton)
        val receiveButton = findViewById<Button>(R.id.receiveButton)

        sendButton.setOnClickListener{
            val textEdit = dataEditView.text.toString()
            dataTextView.text = vm.save(textEdit)
        }

        receiveButton.setOnClickListener {

            dataTextView.text = vm.load()
        }
    }
}