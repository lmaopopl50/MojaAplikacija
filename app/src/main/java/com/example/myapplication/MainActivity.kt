package com.example.mojaaplikacija

import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private var trenutnoVode = 0
    private val dnevniCilj = 2000 // dnevni cilj (2000 ml)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        val textViewProgress = findViewById<TextView>(R.id.textViewProgress)
        val gumbDodajVodo = findViewById<Button>(R.id.btnAddWater)

        progressBar.max = dnevniCilj
        progressBar.progress = trenutnoVode
        textViewProgress.text = "$trenutnoVode / $dnevniCilj ml"

        gumbDodajVodo.setOnClickListener {
            dodajVodo(250, progressBar, textViewProgress)
        }
    }

    private fun dodajVodo(kolicina: Int, progressBar: ProgressBar, textView: TextView) {
        trenutnoVode += kolicina
        if (trenutnoVode > dnevniCilj) trenutnoVode = dnevniCilj

        progressBar.progress = trenutnoVode.toInt()
        textView.text = "$trenutnoVode / $dnevniCilj ml"
    }
}

