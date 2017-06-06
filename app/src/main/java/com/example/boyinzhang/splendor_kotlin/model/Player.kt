package com.example.boyinzhang.splendor_kotlin.model

import java.lang.Math.max

/**
 * Created by boyinzhang on 5/31/17.
 */

class Player(val id:Int){
    var score: Int
    var gems: GemInfo
    var cards: GemInfo
    var gold: Int
    var reservedCards: MutableCollection<Card?>
    init {
        score = 0
        gold = 0
        reservedCards = mutableSetOf()
        cards = GemInfo(0)
        gems = GemInfo(0)
    }

    

    /**
     * Collect the gems according to the currently chosen gems by the current player
     */
    fun collectGems(collectedGems:GemInfo):Boolean{
        if (!checkCollectValidation(collectedGems))
            return false
        gems.addGems(collectedGems)
        Player.gameBoard?.availableGems!!.reduceGems(collectedGems)
        return true
    }

    fun checkCollectValidation(collectedGems:GemInfo):Boolean{
        if(collectedGems.totalGems()> MAX_COLLECT_GEMS) return false
        else if (collectedGems.totalGems()== MAX_COLLECT_GEMS
                &&(collectedGems.diamond>= MAX_COLLECT_SAME_TYPE
                || collectedGems.emerald>=MAX_COLLECT_SAME_TYPE
                || collectedGems.onyx>=MAX_COLLECT_SAME_TYPE
                || collectedGems.ruby>=MAX_COLLECT_SAME_TYPE
                || collectedGems.sapphire>=MAX_COLLECT_SAME_TYPE)) return false
        else if(this.gems.totalGems()+this.gold+collectedGems.totalGems()> MAX_HOLD_GEMS) return false
        for(i in 0..4){
            if(Player.gameBoard?.availableGems!!.getByIndex(i)<collectedGems.getByIndex(i)) return false
        }
        return true

    }

    /**
     * Trying to buy the card according to the user selection.
     */
    fun buyCard(newCard:Card, isReserved:Boolean):Boolean{
        // Cannot buy the card reserved by other players
        if(isReserved && !reservedCards.contains(newCard)) return false

        var requiredGem = newCard.developmentCost
        var restGem = newCard.developmentCost
        //requiredGem is the gem we need to pay for this card
        requiredGem.reduceGems(this.cards)
        //restGem is the number of gems we still need to buy this card when we spend all of our gems
        restGem.reduceGems(this.cards)
        restGem.reduceGems(this.gems)

        //if the restGem is negative, then we have enough this kind of gem, so set it to 0.
        restGem.setGems(max(restGem.diamond, 0), max(restGem.emerald, 0), max(restGem.onyx, 0), max(restGem.ruby, 0), max(restGem.sapphire, 0))
        requiredGem.setGems(max(requiredGem.diamond, 0), max(requiredGem.emerald, 0), max(requiredGem.onyx, 0), max(requiredGem.ruby, 0), max(requiredGem.sapphire, 0))

        //if the restGem is smaller than the number of golds, we can use golds to pay the rest gems.
        if (restGem.diamond + restGem.emerald + restGem.onyx + restGem.ruby + restGem.sapphire <= gold) {
            this.gems.reduceGems(requiredGem)
            this.gold -= restGem.diamond + restGem.emerald + restGem.onyx + restGem.ruby + restGem.sapphire
            Player.gameBoard!!.availableGold += (restGem.diamond + restGem.emerald + restGem.onyx + restGem.ruby + restGem.sapphire)
            requiredGem.reduceGems(restGem)
            gameBoard!!.availableGems.addGems(requiredGem)
            this.gems.setGems(max(this.gems.diamond, 0), max(this.gems.emerald, 0), max(this.gems.onyx, 0), max(this.gems.ruby, 0), max(this.gems.sapphire, 0))
            if (isReserved) {
                if (reservedCards.contains(newCard)) {
                    reservedCards.remove(newCard)
                    addNewCard(newCard)
                    return true
                }
            } else {
                addNewCard(newCard)
                return true
            }
        }
        return false
    }

    private fun  addNewCard(newCard: Card) {
        val deltaGemInfo = newCard.targetGem.getDeltaGemInfo()
        this.cards.addGems(deltaGemInfo)
        this.score += newCard.score
    }

    /**
     * The game logic to reserve a card from the game board according to the player's selection
     */
    fun reserveCards(newCard:Card): Boolean{
        if(reservedCards.size>=3 || Player.gameBoard!!.availableGold <=1 ) return false
        this.reservedCards.add(newCard)
        this.gold += 1
        Player.gameBoard!!.availableGold -= 1
        return true
    }

    fun recruitAvailableNobles(){
        for (noble in Player.gameBoard!!.nobles){
            if (noble != null) {
                if(!noble.isRecruited && noble.isSatisfied(this.cards)){
                    noble.isRecruited = true
                    this.score += noble.score
                }
            }
        }
    }

    companion object {
        var gameBoard: Board? = null
    }
}