package model;

import controller.DatabaseController;
import controller.GameController;
import model.card.Card;

import java.util.ArrayList;

public class Board {
    private ZoneSlot[] playerOneMonsterZone;
    private ZoneSlot[] playerTwoMonsterZone;
    private ZoneSlot[] playerOneSpellZone;
    private ZoneSlot[] playerTwoSpellZone;
    private ArrayList<Card> playerOneGraveYard;
    private ArrayList<Card> playerTwoGraveYard;
    private ArrayList<Card> playerOneBanishedZone;
    private ArrayList<Card> playerTwoBanishedZone;
    private ArrayList<Card> playerOneDrawZone;
    private ArrayList<Card> playerTwoDrawZone;
    private ZoneSlot playerOneFieldZone;
    private ZoneSlot playerTwoFieldZone;
    private ArrayList<Card> playerOneHand;
    private ArrayList<Card> playerTwoHand;

    {
        playerOneMonsterZone = new ZoneSlot[6];
        playerOneBanishedZone = new ArrayList<>();
        playerOneSpellZone = new ZoneSlot[6];
        playerTwoMonsterZone = new ZoneSlot[6];
        playerTwoBanishedZone = new ArrayList<>();  //TODO: 1 start index
        playerTwoSpellZone = new ZoneSlot[6];
        playerOneGraveYard = new ArrayList<>();
        playerTwoGraveYard = new ArrayList<>();
        playerOneHand = new ArrayList<>();
        playerTwoHand = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            playerOneMonsterZone[i] = new ZoneSlot();
            playerOneSpellZone[i] = new ZoneSlot();
            playerTwoMonsterZone[i] = new ZoneSlot();
            playerTwoSpellZone[i] = new ZoneSlot();
        }
    }

    public Board(Deck deck1, Deck deck2) {
        playerOneDrawZone = deck1.getMainDeck();
        playerTwoDrawZone = deck2.getMainDeck();
    }

    public void showBoard() {
        String opponentNickname = GameController.getOpponent().getNickname();
        String playerNickname = GameController.getCurrentPlayer().getNickname();
        int opponentLp = GameController.getInstance().getOpponentLp();
        int playerLp = GameController.getInstance().getCurrentLp();
        int playerHandSize;
        int opponentHandSize;
        int playerDrawZoneCards;
        int opponentDrawZoneCards;
        int playerGraveyardCards;
        int opponentGraveyardCards;
        if (GameController.getInstance().getCurrentPlayerNumber() == 1) {
            playerHandSize = playerOneHand.size();
            opponentHandSize = playerTwoHand.size();
            playerDrawZoneCards = playerOneDrawZone.size();
            opponentDrawZoneCards = playerTwoDrawZone.size();
            playerGraveyardCards = playerOneDrawZone.size();
            opponentGraveyardCards = playerTwoGraveYard.size();
        } else {
            playerHandSize = playerTwoHand.size();
            opponentHandSize = playerOneHand.size();
            playerDrawZoneCards = playerTwoDrawZone.size();
            opponentDrawZoneCards = playerOneDrawZone.size();
            playerGraveyardCards = playerTwoDrawZone.size();
            opponentGraveyardCards = playerOneGraveYard.size();
        }
        System.out.println(opponentNickname +" : "+ opponentLp);
        for (int i = 0; i < opponentHandSize; i++){
            System.out.print("\tc");
        }
        System.out.println("\n*" + opponentDrawZoneCards + "*");
        if (GameController.getInstance().getCurrentPlayerNumber() == 1){
            showGameBoard(playerGraveyardCards, opponentGraveyardCards, playerTwoSpellZone, playerTwoMonsterZone,
                    playerTwoFieldZone, playerOneFieldZone, playerOneMonsterZone, playerOneSpellZone);
        }else {
            showGameBoard(playerGraveyardCards, opponentGraveyardCards, playerOneSpellZone, playerOneMonsterZone,
                    playerOneFieldZone, playerTwoFieldZone, playerTwoMonsterZone, playerTwoSpellZone);
        }
        System.out.println("\t\t\t\t\t" +"*" +playerDrawZoneCards +"*");
        for (int i = 0; i < playerHandSize; i++){
            System.out.print("\tc");
        }
        System.out.println(playerNickname + ":" + playerLp);
    }

    public static void main(String[] args) {
        Deck deck = DatabaseController.getDeckByName("test");
        new Board(deck,deck).showBoard();
    }

    private void showGameBoard(int playerGraveyardCards, int opponentGraveyardCards, ZoneSlot[] playerOneSpellZone,
                               ZoneSlot[] playerOneMonsterZone, ZoneSlot playerOneFieldZone,
                               ZoneSlot playerTwoFieldZone, ZoneSlot[] playerTwoMonsterZone,
                               ZoneSlot[] playerTwoSpellZone) {
        for (int i = 1; i <= playerOneSpellZone.length; i++){
            System.out.print("\t" + playerOneSpellZone[i].toString());
        }
        for (int i = 1; i <= playerOneMonsterZone.length; i++){
            System.out.print("\t" + playerOneMonsterZone[i].toSting());
        }
        System.out.println("\n"+opponentGraveyardCards+"\t\t\t\t\t\t"+ playerOneFieldZone.toSting());
        System.out.println("--------------------------");
        System.out.println(playerTwoFieldZone.toSting()+"\t\t\t\t\t\t"+playerGraveyardCards);
        for (int i = 1; i <= playerTwoMonsterZone.length; i++){
            System.out.print("\t" + playerTwoMonsterZone[i].toSting());
        }
        System.out.println();
        for (int i = 1; i <= playerTwoSpellZone.length; i++){
            System.out.print("\t" + playerTwoSpellZone[i].toString());
        }
    }

    public Card getCard(String field, int number, int player) {
        switch (field) {
            case "monster":
                if (player == 1)
                    return playerOneMonsterZone[number].getCard();
                else if (player == 2)
                    return playerTwoMonsterZone[number].getCard();

                break;
            case "spell":
                if (player == 1)
                    return playerOneSpellZone[number].getCard();
                else if (player == 2)
                    return playerTwoSpellZone[number].getCard();

                break;
            case "hand":
                number--;
                if (player == 1)
                    return playerOneHand.get(number);
                else if (player == 2)
                    return playerTwoHand.get(number);
                break;
        }
        return null;
    }

    public Card getCard(String field, int player) {
        if (field.equals("field")) {
            if (player == 1)
                return playerOneFieldZone.getCard();
            else if (player == 2)
                return playerTwoFieldZone.getCard();
        }
        return null;
    }

    public int getNumberOfCardsInHand(int player) {
        if (player == 1)
            return playerOneHand.size();
        else if (player == 2)
            return playerTwoHand.size();
        return -1;
    }

}
