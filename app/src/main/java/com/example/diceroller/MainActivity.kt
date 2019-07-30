package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    lateinit var diceImageView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener {
            Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT).show()
            rollonethousand()

        }
    }

    private fun rollDice(): Boolean {
        val dice1 = Random.nextInt(6) + 1
        val dice2 = Random.nextInt(6) + 1
        val drawableResource1 = when (dice1) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        val drawableResource2 = when (dice2) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        val diceImage1: ImageView = findViewById(R.id.dice_image)
        val diceImage2: ImageView = findViewById(R.id.dice_image_2)
        diceImage1.setImageResource(drawableResource1)
        diceImage2.setImageResource(drawableResource2)
        return dice1 == dice2

    }


    private fun rollonethousand() {
        val result: TextView = findViewById(R.id.result)
        var count = 0
        val x = 10


        for (i in 1..1000){

            if (rollDice()) {
                count = count + 1
            }
        }
        var percent = count.toDouble() / x.toDouble()


        result.text = "Score: ${percent} % "

    }

}




