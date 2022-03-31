package com.company

import java.util.*

class Card(val rank: Rank, val suit: Suit) : Comparable<Card> {

    var maxRank: Rank = Rank.Two
    init {

    }

    override fun equals(other: Any?): Boolean {
        if (other !is Card) return false
        if (other === this) return true
        val tempCard = other
        return tempCard.rank == rank && tempCard.suit == suit
    }

    override fun hashCode(): Int {
        return Objects.hash(rank, suit)
    }

    override fun toString(): String {
        return rank.toString() + " of " + suit.toString()
    }

    override operator fun compareTo(other: Card): Int {
        if (suit < other.suit) {
            return -1
        }
        if (suit > other.suit) {
            return 1
        }
        if (rank < other.rank) {
            return -1
        }
        return if (rank > other.rank) {
            1
        } else 0
    }

    companion object {
        enum class Suit{
            Clubs,
            Diamonds,
            Spades,
            Hearts}

        enum class Rank {
            Two,
            Three,
            Four,
            Five,
            Six,
            Seven,
            Eight,
            Nine,
            Ten,
            Jack,
            Queen,
            King,
            Ace,
            Joker
        }
    }
}