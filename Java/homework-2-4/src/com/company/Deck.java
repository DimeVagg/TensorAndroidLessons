package com.company;

import java.util.*;

public class Deck {
    private ArrayList<Card> cards;

    private Deck(boolean withJokers) {
        cards = new ArrayList(54);
        for (int suit = 0; suit < Card.SUIT_ARRAY.length; suit++) {
            for (int rank = 0; rank < Card.RANK_ARRAY.length - 1; rank++) {
                cards.add(new Card(rank, suit));
            }
        }
        if(withJokers) {
            // добавим джокеров
            cards.add(new Card(13, 1));
            cards.add(new Card(13, 2));
        }
    }

    public static Deck CreateDeckWithJokers() {
        return new Deck(true);
    }

    public static Deck CreateDeckWithoutJokers() {
        return new Deck(false);
    }

    public int size() {
        return cards.size();
    }

    public static Card getRandomCard(Deck deck) {
        Random rand = new Random();
        int index = rand.nextInt(deck.size() + 1);
        Card card = deck.cards.get(index);
        deck.cards.remove(index);
        return card;
    }

    public void print()
    {
        System.out.println(cards.size());
        for (Card cCard : cards) {
            System.out.println(Card.RANK_ARRAY[cCard.rank] + " of " + Card.SUIT_ARRAY[cCard.suit]);
        }
    }

    public void insertCard(Card card) {
        if( cards.contains(card) ) {
            System.out.println("Такая карта есть в колоде");
            return;
        }
        System.out.println("Добавлена карта: " + card.toString());
        cards.add(card);
    }

    public void shuffle() {
        Random rand = new Random();
        for (int i = this.cards.size() - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            Card tmp = this.cards.get(j);
            this.cards.set(j, this.cards.get(i));
            this.cards.set(i, tmp);
        }
    }

    public boolean empty() {
        return cards.size() == 0;
    }

    public Card takeTopCard()
    {
        if (this.empty())
            throw new ArrayIndexOutOfBoundsException("Колода пуста");
        Card card = this.cards.get(0);
        this.cards.remove(0);
        return card;
    }

    public void sortDeck() {
        Collections.sort(this.cards);
    }

}
