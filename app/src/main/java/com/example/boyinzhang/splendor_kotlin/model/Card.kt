package com.example.boyinzhang.splendor_kotlin.model

/**
 * Created by boyinzhang on 5/30/17.
 */

class Card(val score:Int, var developmentCost:GemInfo, val targetGem:Gem){
    var isReserved:Boolean = false
    var rank:Int? = null
    var index:Int? = null


}
