package com.company;

import java.util.Objects;

public class Card implements Comparable<Card>{
    public int rank;
    public int suit;

    public static String[] SUIT_ARRAY = { "Clubs", "Diamonds", "Spades", "Hearts" };

    public static String[] RANK_ARRAY = { "2", "3", "4", "5", "6", "7", "8",
                                          "9", "10", "Jack", "Queen", "King", "Ace", "Joker" };
    public static int maxRank = 0;

    public Card() {
        rank = 1;
        suit = 1;
        if(rank > maxRank)
            maxRank = rank;
    }

    public static boolean checkCard(Card card) {
        return checkCard(card.rank, card.suit);
    }

    public static boolean checkCard(int cRank, int cSuit) {
        if( cSuit < 0 || cSuit > SUIT_ARRAY.length - 1 ) {
            System.out.println("Wrong suit given");
            return false;
        }
        if( cRank < 0 || cRank > RANK_ARRAY.length - 1 ) {
            System.out.println("Wrong rank given");
            return false;
        }
        return true;
    }

    public Card(int fRank, int fSuit) {
        if( !checkCard(fRank, fSuit) ) {
            throw new ArrayIndexOutOfBoundsException("Unable to create card");
        }
        rank = fRank;
        suit = fSuit;
        if(rank > maxRank)
            maxRank = rank;
    }

    public Card(int fSuit) {
        this(maxRank + 1, fSuit);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (!(obj instanceof Card))
            return false;
        if (obj == this)
            return true;

        Card tCard = (Card)obj;
        return tCard.rank == this.rank && tCard.suit == this.suit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.rank, this.suit);
    }

    @Override
    public String toString() {
        return RANK_ARRAY[rank] + " of " + SUIT_ARRAY[suit];
    }

    @Override
    public int compareTo(Card fCard) {
        if (this.suit < fCard.suit) {
            return -1;
        }
        if (this.suit > fCard.suit) {
            return 1;
        }
        if (this.rank < fCard.rank) {
            return -1;
        }
        if (this.rank > fCard.rank) {
            return 1;
        }
        return 0;
    }

}
