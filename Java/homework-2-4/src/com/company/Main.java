package com.company;

import java.lang.System;
import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        // 2.
        System.out.println("2.");

        Card myCard1 = new Card();
        System.out.println("a. " + myCard1.toString() + " - конструктор по умолчанию");

        Card myCard2 = new Card(5,3);
        System.out.println("b. " + myCard2.toString() + " - конструктор с 2 параметрами");

        Card myCard3 = new Card(3);
        Card myCard4 = new Card(10,3);
        Card myCard5 = new Card(2);
        System.out.println("c. ");
        System.out.println("\t" + myCard3.toString() + " - конструктор с 1 параметром");
        System.out.println("\t" + myCard4.toString() + " - обновляем maxRank");
        System.out.println("\t" + myCard5.toString() + " - конструктор с 1 параметром и rank = maxRank + 1");


        // 3.
        System.out.println("3.");
        System.out.println("a. " + Card.checkCard(myCard4));
        System.out.println("b. "+ myCard1.equals(myCard3));
        System.out.println("c. "+ myCard1.compareTo(myCard3));

        // создали колоду
        System.out.println("4.");

        Deck deckWithJokers = Deck.CreateDeckWithJokers();
        System.out.println("Колода с джокерами: " + deckWithJokers.size());
        Deck deckWithoutJokers = Deck.CreateDeckWithoutJokers();
        System.out.println("Колода без джокеров: " + deckWithoutJokers.size());
        System.out.println("случайная карта из стандартной колоды:");
        System.out.println("\t" + Deck.getRandomCard(deckWithoutJokers).toString());
        System.out.println("Колода с джокерами: " + deckWithoutJokers.size());

        // сортировка колоды
        deckWithJokers.sortDeck();
        // перемешивание колоды
        deckWithJokers.shuffle();
        Random rand = new Random();

        //раздаем произвольное количество карт
        ArrayList<Card> table = new ArrayList<Card>();
        int cardsToTableCount = rand.nextInt(deckWithJokers.size() + 1);
        for(int i = 0; i < cardsToTableCount - 1; i++) {
            Card card = deckWithJokers.takeTopCard();
            table.add(card);
        }
        System.out.println("В колоде сейчас: " + deckWithJokers.size());
        int cardsToReturn = rand.nextInt(table.size() + 1);
        for(int i = cardsToReturn - 1; i >= 0; i--) {
            Card tableCard = table.get(i);
            table.remove(i);
            deckWithJokers.insertCard(tableCard);
        }
        // Пробуем добавить карту в колоду дважды
        Card toReturnTwice = new Card(1,1);
        deckWithJokers.insertCard(toReturnTwice);

        // раздаем все карты
        do {
            deckWithJokers.takeTopCard();
        } while( !deckWithJokers.empty() );
    }
}
