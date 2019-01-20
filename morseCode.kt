package com.example.geocomputers.crypter

import java.util.HashMap

object morseCode {

    internal var ALPHA = arrayOf(
        "a",
        "b",
        "c",
        "d",
        "e",
        "f",
        "g",
        "h",
        "i",
        "j",
        "k",
        "l",
        "m",
        "n",
        "o",
        "p",
        "q",
        "r",
        "s",
        "t",
        "u",
        "v",
        "w",
        "x",
        "y",
        "z",
        "1",
        "2",
        "3",
        "4",
        "5",
        "6",
        "7",
        "8",
        "9",
        "0",
        "!",
        ",",
        "?",
        ".",
        "'"
    )
    internal var MORSE = arrayOf(
        ".-",
        "-...",
        "-.-.",
        "-..",
        ".",
        "..-.",
        "--.",
        "....",
        "..",
        ".---",
        "-.-",
        ".-..",
        "--",
        "-.",
        "---",
        ".--.",
        "--.-",
        ".-.",
        "...",
        "-",
        "..-",
        "...-",
        ".--",
        "-..",
        "-.--",
        "--..",
        ".----",
        "..---",
        "...--",
        "....-",
        ".....",
        "-....",
        "--...",
        "---..",
        "----.",
        "-----",
        "-.-.--",
        "--..--",
        "..--..",
        ".-.-.-",
        ".----."
    )

    var ALPHA_TO_MORSE = HashMap<String, String>()
    var MORSE_TO_ALPHA = HashMap<String, String>()

    init {
        var i = 0
        while (i < ALPHA.size && i < MORSE.size) {
            ALPHA_TO_MORSE[ALPHA[i]] = MORSE[i]
            MORSE_TO_ALPHA[MORSE[i]] = ALPHA[i]
            i++
        }
    }

    fun morseToAlpha(morseCode: String): String {
        val builder = StringBuilder()
        val words = morseCode.trim { it <= ' ' }.split("  ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()

        for (word in words) {
            for (letter in word.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()) {
                val alpha = MORSE_TO_ALPHA[letter]
                builder.append(alpha)
            }
            builder.append(" ")
        }
        return builder.toString().toUpperCase()
    }

    fun alphaToMorse(englishCode: String): String {
        val builder = StringBuilder()
        val words = englishCode.trim { it <= ' ' }.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()

        for (word in words) {
            var i = 0
            while (1 < word.length) {
                val morse = ALPHA_TO_MORSE[word.substring(i, i + 1).toLowerCase()]
                builder.append(morse).append(" ")
                i++
            }
            builder.append(" ")
        }
        return builder.toString()
    }
}
