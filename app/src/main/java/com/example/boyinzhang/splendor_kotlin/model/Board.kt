package com.example.boyinzhang.splendor_kotlin.model

import java.util.*

/**
 * Created by boyinzhang on 5/30/17.
 */

class Board(val numPlayer: Int){
    var nobles: Array<Noble?> = arrayOfNulls<Noble>(numPlayer+1)
    var cards: Array<Array<Card?>> = Array(NUM_CARD_RANK){ arrayOfNulls<Card>(NUM_CARD_PER_RANK)}
    var decks:Array<Deck> = Array(NUM_CARD_RANK){ Deck() }
    var availableGems:GemInfo = GemInfo(INIT_GEM_NUM)
    var availableGold:Int = INIT_GOLD_NUM

    init {
        initialBoard()
    }

    /**
     * This function is used to initialize all the elements in the board
     */
    fun initialBoard() {
        initialLowRankCards()
        initialMedianRankCards()
        initialHighRankCards()
        shuffleCards()
        intitialNobles()
        initialCardOnBoard()
    }

    private fun initialCardOnBoard() {
        for (i in 0..NUM_CARD_RANK - 1) {
            for (j in 0..NUM_CARD_PER_RANK - 1) {
                this.cards[i][j] = this.decks[i].cards[0]
                decks[i].cards.removeAt(0)
            }
        }
    }

    /**
     * Used to initial all noble cards
     */
    private fun intitialNobles() {
        val nobleCards = ArrayList<Noble>()
        nobleCards.add(Noble(0, 4, 0, 4, 0))
        nobleCards.add(Noble(3, 0, 3, 3, 0))
        nobleCards.add(Noble(0, 4, 0, 0, 4))
        nobleCards.add(Noble(3, 3, 0, 0, 3))
        nobleCards.add(Noble(4, 0, 4, 0, 0))
        nobleCards.add(Noble(0, 3, 3, 3, 0))
        nobleCards.add(Noble(0, 0, 4, 4, 0))
        nobleCards.add(Noble(3, 0, 3, 0, 3))
        nobleCards.add(Noble(4, 0, 0, 0, 4))
        nobleCards.add(Noble(0, 3, 0, 3, 3))
        Collections.shuffle(nobleCards)
        for (i in 0..numPlayer + 1 - 1) {
            this.nobles[i] = nobleCards[i]
        }
    }

    /**
     * Used to initial high rank cards
     */
    private fun initialHighRankCards() {
        this.decks[2].cards.add(Card(3, GemInfo(3, 3, 3, 0, 5), Gem.RUBY))
        this.decks[2].cards.add(Card(4, GemInfo(0, 6, 0, 3, 3), Gem.RUBY))
        this.decks[2].cards.add(Card(4, GemInfo(0, 7, 0, 0, 0), Gem.RUBY))
        this.decks[2].cards.add(Card(5, GemInfo(0, 7, 0, 3, 0), Gem.RUBY))

        this.decks[2].cards.add(Card(3, GemInfo(3, 3, 5, 3, 0), Gem.RUBY))
        this.decks[2].cards.add(Card(4, GemInfo(6, 0, 3, 0, 3), Gem.RUBY))
        this.decks[2].cards.add(Card(4, GemInfo(7, 0, 0, 0, 0), Gem.RUBY))
        this.decks[2].cards.add(Card(5, GemInfo(7, 0, 0, 0, 3), Gem.RUBY))

        this.decks[2].cards.add(Card(3, GemInfo(3, 5, 0, 3, 3), Gem.ONYX))
        this.decks[2].cards.add(Card(4, GemInfo(0, 3, 3, 6, 0), Gem.ONYX))
        this.decks[2].cards.add(Card(4, GemInfo(0, 0, 0, 7, 0), Gem.ONYX))
        this.decks[2].cards.add(Card(5, GemInfo(0, 0, 3, 7, 0), Gem.ONYX))

        this.decks[2].cards.add(Card(3, GemInfo(5, 0, 3, 3, 3), Gem.EMERALD))
        this.decks[2].cards.add(Card(4, GemInfo(0, 7, 0, 0, 0), Gem.EMERALD))
        this.decks[2].cards.add(Card(4, GemInfo(3, 3, 0, 0, 6), Gem.EMERALD))
        this.decks[2].cards.add(Card(5, GemInfo(0, 3, 0, 0, 7), Gem.EMERALD))

        this.decks[2].cards.add(Card(3, GemInfo(0, 3, 3, 5, 3), Gem.DIAMOND))
        this.decks[2].cards.add(Card(4, GemInfo(3, 0, 6, 3, 0), Gem.DIAMOND))
        this.decks[2].cards.add(Card(4, GemInfo(0, 0, 7, 0, 0), Gem.DIAMOND))
        this.decks[2].cards.add(Card(5, GemInfo(3, 0, 7, 0, 0), Gem.DIAMOND))
    }

    /**
     * used to initial median rank cards
     */
    private fun initialMedianRankCards() {
        this.decks[1].cards.add(Card(1, GemInfo(0, 3, 3, 0, 2), Gem.SAPPHIRE))
        this.decks[1].cards.add(Card(1, GemInfo(0, 2, 0, 3, 2), Gem.SAPPHIRE))
        this.decks[1].cards.add(Card(2, GemInfo(2, 0, 4, 1, 0), Gem.SAPPHIRE))
        this.decks[1].cards.add(Card(2, GemInfo(5, 0, 0, 0, 3), Gem.SAPPHIRE))
        this.decks[1].cards.add(Card(2, GemInfo(0, 0, 0, 0, 5), Gem.SAPPHIRE))
        this.decks[1].cards.add(Card(3, GemInfo(0, 0, 0, 0, 6), Gem.SAPPHIRE))

        this.decks[1].cards.add(Card(1, GemInfo(3, 2, 0, 0, 2), Gem.ONYX))
        this.decks[1].cards.add(Card(1, GemInfo(3, 3, 2, 0, 0), Gem.ONYX))
        this.decks[1].cards.add(Card(2, GemInfo(0, 3, 0, 5, 0), Gem.ONYX))
        this.decks[1].cards.add(Card(2, GemInfo(0, 4, 0, 2, 1), Gem.ONYX))
        this.decks[1].cards.add(Card(2, GemInfo(5, 0, 0, 0, 0), Gem.ONYX))
        this.decks[1].cards.add(Card(3, GemInfo(0, 0, 6, 0, 0), Gem.ONYX))

        this.decks[1].cards.add(Card(1, GemInfo(2, 0, 2, 0, 3), Gem.EMERALD))
        this.decks[1].cards.add(Card(1, GemInfo(3, 2, 0, 3, 0), Gem.EMERALD))
        this.decks[1].cards.add(Card(2, GemInfo(0, 3, 0, 0, 5), Gem.EMERALD))
        this.decks[1].cards.add(Card(2, GemInfo(4, 0, 1, 0, 2), Gem.EMERALD))
        this.decks[1].cards.add(Card(2, GemInfo(0, 5, 0, 0, 0), Gem.EMERALD))
        this.decks[1].cards.add(Card(3, GemInfo(0, 6, 0, 0, 0), Gem.EMERALD))

        this.decks[1].cards.add(Card(1, GemInfo(2, 2, 3, 0, 0), Gem.RUBY))
        this.decks[1].cards.add(Card(1, GemInfo(0, 0, 3, 2, 3), Gem.RUBY))
        this.decks[1].cards.add(Card(2, GemInfo(3, 0, 5, 0, 0), Gem.RUBY))
        this.decks[1].cards.add(Card(2, GemInfo(0, 0, 5, 0, 0), Gem.RUBY))
        this.decks[1].cards.add(Card(2, GemInfo(1, 2, 0, 0, 4), Gem.RUBY))
        this.decks[1].cards.add(Card(3, GemInfo(0, 0, 0, 6, 0), Gem.RUBY))

        this.decks[1].cards.add(Card(1, GemInfo(0, 3, 2, 2, 0), Gem.DIAMOND))
        this.decks[1].cards.add(Card(1, GemInfo(2, 0, 0, 3, 3), Gem.DIAMOND))
        this.decks[1].cards.add(Card(2, GemInfo(0, 1, 2, 4, 0), Gem.DIAMOND))
        this.decks[1].cards.add(Card(2, GemInfo(0, 0, 0, 5, 0), Gem.DIAMOND))
        this.decks[1].cards.add(Card(2, GemInfo(0, 0, 3, 5, 0), Gem.DIAMOND))
        this.decks[1].cards.add(Card(3, GemInfo(6, 0, 0, 0, 0), Gem.DIAMOND))
    }

    /**
     * used to initial low rank cards
     */
    private fun initialLowRankCards() {
        //diamond
        this.decks[0].cards.add(Card(0, GemInfo(0, 0, 2, 0, 2), Gem.DIAMOND))
        this.decks[0].cards.add(Card(1, GemInfo(0, 4, 0, 0, 0), Gem.DIAMOND))
        this.decks[0].cards.add(Card(0, GemInfo(0, 1, 1, 1, 1), Gem.DIAMOND))
        this.decks[0].cards.add(Card(0, GemInfo(0, 2, 1, 0, 2), Gem.DIAMOND))
        this.decks[0].cards.add(Card(0, GemInfo(0, 2, 1, 1, 1), Gem.DIAMOND))
        this.decks[0].cards.add(Card(0, GemInfo(0, 0, 0, 0, 3), Gem.DIAMOND))
        this.decks[0].cards.add(Card(0, GemInfo(3, 0, 1, 0, 1), Gem.DIAMOND))
        this.decks[0].cards.add(Card(0, GemInfo(0, 0, 1, 2, 0), Gem.DIAMOND))
        //emerald
        this.decks[0].cards.add(Card(0, GemInfo(0, 0, 0, 2, 2), Gem.EMERALD))
        this.decks[0].cards.add(Card(0, GemInfo(1, 1, 0, 0, 3), Gem.EMERALD))
        this.decks[0].cards.add(Card(0, GemInfo(0, 0, 2, 2, 1), Gem.EMERALD))
        this.decks[0].cards.add(Card(0, GemInfo(1, 0, 1, 1, 1), Gem.EMERALD))
        this.decks[0].cards.add(Card(0, GemInfo(2, 0, 0, 0, 1), Gem.EMERALD))
        this.decks[0].cards.add(Card(0, GemInfo(0, 0, 0, 3, 0), Gem.EMERALD))
        this.decks[0].cards.add(Card(0, GemInfo(1, 0, 2, 1, 1), Gem.EMERALD))
        this.decks[0].cards.add(Card(1, GemInfo(0, 0, 4, 0, 0), Gem.EMERALD))
        //onyx
        this.decks[0].cards.add(Card(0, GemInfo(1, 1, 0, 1, 2), Gem.ONYX))
        this.decks[0].cards.add(Card(0, GemInfo(0, 3, 0, 0, 0), Gem.ONYX))
        this.decks[0].cards.add(Card(0, GemInfo(2, 0, 0, 1, 2), Gem.ONYX))
        this.decks[0].cards.add(Card(0, GemInfo(0, 1, 1, 3, 0), Gem.ONYX))
        this.decks[0].cards.add(Card(0, GemInfo(2, 2, 0, 0, 0), Gem.ONYX))
        this.decks[0].cards.add(Card(0, GemInfo(1, 1, 0, 1, 1), Gem.ONYX))
        this.decks[0].cards.add(Card(0, GemInfo(0, 2, 0, 1, 0), Gem.ONYX))
        this.decks[0].cards.add(Card(1, GemInfo(0, 0, 0, 0, 4), Gem.ONYX))
        //ruby
        this.decks[0].cards.add(Card(0, GemInfo(0, 1, 0, 0, 2), Gem.RUBY))
        this.decks[0].cards.add(Card(0, GemInfo(2, 0, 0, 2, 0), Gem.RUBY))
        this.decks[0].cards.add(Card(0, GemInfo(2, 1, 2, 0, 0), Gem.RUBY))
        this.decks[0].cards.add(Card(0, GemInfo(2, 1, 1, 0, 1), Gem.RUBY))
        this.decks[0].cards.add(Card(0, GemInfo(3, 0, 0, 0, 0), Gem.RUBY))
        this.decks[0].cards.add(Card(0, GemInfo(1, 0, 3, 1, 0), Gem.RUBY))
        this.decks[0].cards.add(Card(0, GemInfo(1, 1, 1, 0, 1), Gem.RUBY))
        this.decks[0].cards.add(Card(1, GemInfo(4, 0, 0, 0, 0), Gem.RUBY))
        //sapphire
        this.decks[0].cards.add(Card(0, GemInfo(0, 3, 0, 1, 1), Gem.SAPPHIRE))
        this.decks[0].cards.add(Card(0, GemInfo(0, 2, 2, 0, 0), Gem.SAPPHIRE))
        this.decks[0].cards.add(Card(0, GemInfo(1, 2, 0, 2, 0), Gem.SAPPHIRE))
        this.decks[0].cards.add(Card(0, GemInfo(1, 1, 1, 1, 0), Gem.SAPPHIRE))
        this.decks[0].cards.add(Card(0, GemInfo(1, 0, 2, 0, 0), Gem.SAPPHIRE))
        this.decks[0].cards.add(Card(0, GemInfo(0, 0, 3, 0, 0), Gem.SAPPHIRE))
        this.decks[0].cards.add(Card(0, GemInfo(1, 1, 1, 2, 0), Gem.SAPPHIRE))
        this.decks[0].cards.add(Card(1, GemInfo(0, 0, 0, 4, 0), Gem.SAPPHIRE))
    }

    private fun shuffleCards() {
        for (deck in this.decks) {
            Collections.shuffle(deck.cards)
        }
    }
}