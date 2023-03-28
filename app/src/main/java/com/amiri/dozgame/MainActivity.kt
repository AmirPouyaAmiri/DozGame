package com.amiri.dozgame

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun click(v: View) {
        var id: Int = 0
        val select = v as Button

        //Set ID for each button
        when (select.id) {
            R.id.btn1 -> id = 1
            R.id.btn2 -> id = 2
            R.id.btn3 -> id = 3
            R.id.btn4 -> id = 4
            R.id.btn5 -> id = 5
            R.id.btn6 -> id = 6
            R.id.btn7 -> id = 7
            R.id.btn8 -> id = 8
            R.id.btn9 -> id = 9
        }
        startGame(id, select)
    }

    //region Specifying players and active players
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var activePlayer = 1

    //endregion

    fun startGame(id: Int, select: Button) {
        if (activePlayer == 1) {
            select.text = "X"
            select.setBackgroundColor(Color.YELLOW)
            player1.add(id)
            activePlayer = 2
        } else {
            select.text = "O"
            select.setBackgroundColor(Color.GREEN)
            player2.add(id)
            activePlayer = 1
        }
        select.isEnabled = false


        if (winner() == 1) {
            Toast.makeText(this, "player 1 wins!!!", Toast.LENGTH_LONG).show()
            disableAllButtons()
        } else if (winner() == 2) {
            Toast.makeText(this, "player 2 wins!!!", Toast.LENGTH_LONG).show()
            disableAllButtons()

        }
    }

    fun disableAllButtons() {
        findViewById<Button>(R.id.btn1).isEnabled = false
        findViewById<Button>(R.id.btn2).isEnabled = false
        findViewById<Button>(R.id.btn3).isEnabled = false
        findViewById<Button>(R.id.btn4).isEnabled = false
        findViewById<Button>(R.id.btn5).isEnabled = false
        findViewById<Button>(R.id.btn6).isEnabled = false
        findViewById<Button>(R.id.btn7).isEnabled = false
        findViewById<Button>(R.id.btn8).isEnabled = false
        findViewById<Button>(R.id.btn9).isEnabled = false
    }

    fun winner(): Int {

        //Code of different modes which player won
        //region player 1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            return 1
        }
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            return 1
        }
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            return 1
        }
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            return 1
        }
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            return 1
        }
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            return 1
        }
        if (player1.contains(1) && player1.contains(5) && player1.contains(9)) {
            return 1
        }
        if (player1.contains(3) && player1.contains(5) && player1.contains(7)) {
            return 1
        }
        //endregion

        //region player 2
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            return 2
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            return 2
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            return 2
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            return 2
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            return 2
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            return 2
        }
        if (player2.contains(1) && player2.contains(5) && player2.contains(9)) {
            return 2
        }
        if (player2.contains(3) && player2.contains(5) && player2.contains(7)) {
            return 2
        }

        //endregion


        return 0
    }

    fun exit(v: View) {
        val select = v as Button
        when (select.id) {
            R.id.btnExit -> finish()
        }
    }

    fun restart(v: View) {
        val select = v as Button
        when (select.id) {
            R.id.btnReset -> recreate()
        }
    }
}