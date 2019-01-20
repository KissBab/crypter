package com.example.geocomputers.crypter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Main4Activity : AppCompatActivity() {

    private var textMorse: EditText? = null
    private var finalMorse: TextView? = null
    private var encryptMorse: Button? = null
    private var decryptMorse: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        textMorse = findViewById<View>(R.id.textMorse) as EditText
        finalMorse = findViewById<View>(R.id.finalMorse) as TextView
        encryptMorse = findViewById<View>(R.id.encryptMorse) as Button
        decryptMorse = findViewById<View>(R.id.decryptMorse) as Button

        encryptMorse!!.setOnClickListener {
            val textToConvert = textMorse!!.text.toString()
            val convertedText = morseCode.alphaToMorse(textToConvert)
            finalMorse!!.text = convertedText
        }

        decryptMorse!!.setOnClickListener {
            val textToConvert = textMorse!!.text.toString()
            val convertedText = morseCode.morseToAlpha(textToConvert)
            finalMorse!!.text = convertedText
        }
    }
}
