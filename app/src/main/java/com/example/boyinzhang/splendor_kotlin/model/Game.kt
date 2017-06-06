package com.example.boyinzhang.splendor_kotlin.model

/**
 * Created by boyinzhang on 5/31/17.
 */

class Game(val numPlayer:Int){
    var currentPlayer:Player? = null
    var players: Array<Player?> = arrayOfNulls<Player>(numPlayer)
    var gameBoard: Board? = null

    init {
        gameBoard = Board(numPlayer)
        for (i in players.indices){
            players[i] = Player(i)
        }
        currentPlayer = players[0]
    }

    /**
     * Helper function to turn to next player
     */
    fun turnToNextPlayer(){
        val index = (currentPlayer!!.id + 1) % numPlayer
        currentPlayer = players[index]
    }


}