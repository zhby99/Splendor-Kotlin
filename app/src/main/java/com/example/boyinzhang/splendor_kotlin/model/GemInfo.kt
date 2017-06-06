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

    fun getByIndex(index:Int):Int{
        when(index){
            0 -> this.diamond
            1 -> this.emerald
            2 -> this.onyx
            3 -> this.ruby
            4 -> this.sapphire
        }
        return -1;
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

    fun addGems(deltaGems:GemInfo){
        this.diamond+=deltaGems.diamond
        this.emerald+=deltaGems.emerald
        this.onyx+=deltaGems.onyx
        this.ruby+=deltaGems.ruby
        this.sapphire+=deltaGems.sapphire
    }

    fun reduceGems(deltaGems:GemInfo){
        this.diamond-=deltaGems.diamond
        this.emerald-=deltaGems.emerald
        this.onyx-=deltaGems.onyx
        this.ruby-=deltaGems.ruby
        this.sapphire-=deltaGems.sapphire
    }

    fun totalGems():Int{
        return this.diamond+this.emerald+this.onyx+this.ruby+this.sapphire
    }

    fun numOfNonZeroTypes():Int{
        return boolToInt(this.diamond>0)+
                boolToInt(this.emerald>0)+
                boolToInt(this.onyx>0)+
                boolToInt(this.ruby>0)+
                boolToInt(this.sapphire>0)
    }

    fun boolToInt(bool:Boolean):Int{
        if(bool) return 1
        else return 0
    }

}