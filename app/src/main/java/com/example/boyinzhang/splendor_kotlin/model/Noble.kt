package com.example.boyinzhang.splendor_kotlin.model

/**
 * Created by boyinzhang on 5/30/17.
 */

class Noble(diamond: Int, emerald: Int, onyx: Int, ruby: Int, sapphire: Int) {
    val score:Int = NOBLE_SCORE
    val threshold:GemInfo
    var isRecruited:Boolean

    init {
        isRecruited = false
        threshold = GemInfo(diamond,emerald,onyx,ruby,sapphire)
    }

    fun isSatisfied(playerCard : GemInfo):Boolean{
        for (i in 0..4){
            if (playerCard.getByIndex(i)<threshold.getByIndex(i)) return false
        }
        return true
    }
}