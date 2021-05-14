package model;

import controller.RegisterController;
import model.card.Card;
import model.card.SpellCard;
import model.card.TrapCard;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private final String deckName;
    private final ArrayList<Card> mainDeck = new ArrayList<>();
    private final ArrayList<Card> sideDeck = new ArrayList<>();

    public Deck(String name) {
        this.deckName = name;
    }

    public void addCardToMainDeck(Card card) {
        mainDeck.add(card);
    }

    public void addCardToSideDeck(Card card) {
        sideDeck.add(card);
    }

    public void removeCardFromMainDeck(Card card) {
        mainDeck.remove(card);
    }

    public void removeCardFromSideDeck(Card card) {
        sideDeck.remove(card);
    }

    public boolean isDeckValid() {
        return mainDeck.size() >= 25;
    }

    public String getDeckName() {
        return deckName;
    }

    public ArrayList<Card> getMainDeck() {
        return mainDeck;
    }

    public ArrayList<Card> getSideDeck() {
        return sideDeck;
    }

    public boolean checkCardsLimit(Card card) {
        int counter = 0;
        for (Card iteratorCard : mainDeck) {
            if (iteratorCard.equals(card))
                counter++;
        }
        for (Card iteratorCard : sideDeck) {
            if (iteratorCard.equals(card))
                counter++;
        }
        if (card instanceof TrapCard) {
            if (((TrapCard) card).getLimitationStatus().equals("Limited"))
                return counter == 0 && (Collections.frequency(RegisterController.onlineUser.getPlayerCards(), card.getName())
                        - (Collections.frequency(mainDeck, Card.getCardByName(card.getName())) + Collections.frequency(sideDeck, Card.getCardByName(card.getName()))) >= 0);
        } else if (card instanceof SpellCard) {
            if (((SpellCard) card).getLimitationStatus().equals("Limited"))
                return counter == 0 && (Collections.frequency(RegisterController.onlineUser.getPlayerCards(), card.getName())
                        - (Collections.frequency(mainDeck, Card.getCardByName(card.getName())) + Collections.frequency(sideDeck, Card.getCardByName(card.getName()))) >= 0);
        }
        return counter < 3 && (Collections.frequency(RegisterController.onlineUser.getPlayerCards(), card.getName())
                - (Collections.frequency(mainDeck, Card.getCardByName(card.getName())) + Collections.frequency(sideDeck, Card.getCardByName(card.getName()))) >= 0);
    }


}
