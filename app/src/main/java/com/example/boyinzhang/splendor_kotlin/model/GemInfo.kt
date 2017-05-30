package com.example.boyinzhang.splendor_kotlin.model

/**
 * Created by boyinzhang on 5/30/17.
 */

data class GemInfo(var diamond: Int, var emerald:Int, var onyx:Int, var ruby:Int, var sapphire:Int){

    constructor(commonNum:Int) : this(commonNum,commonNum,commonNum,commonNum,commonNum)

    fun updateGems(deltaDiamond:Int, deltaEmerald:Int, deltaOnyx:Int, deltaRuby:Int, deltaSapphire:Int){
        this.diamond += deltaDiamond
        this.emerald += deltaEmerald
        this.onyx += deltaOnyx
        this.ruby +=deltaRuby
        this.sapphire += deltaSapphire
    }

    fun setGems(diamond:Int, emerald:Int, onyx:Int, ruby:Int, sapphire:Int){
        this.diamond = diamond
        this.emerald = emerald
        this.onyx = onyx
        this.ruby = ruby
        this.sapphire = sapphire
    }


    fun resetGems(){
        setGems(0,0,0,0,0);
    }

}