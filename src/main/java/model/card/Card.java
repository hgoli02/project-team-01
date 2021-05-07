package model.card;

import com.google.gson.annotations.Expose;
import controller.Spell;
import model.commands.Command;
import model.commands.FieldCard;
import model.commands.PotOfGreed;
import model.commands.Terrafoming;

import java.util.ArrayList;
import java.util.TreeMap;

public abstract class Card {
    private static TreeMap<String, Card> allCards = new TreeMap<>();
    private String name;
    private String description;
    private int price;
    protected String type = "type";
    @Expose(serialize = false, deserialize = false)
    protected ArrayList<Command> commands = new ArrayList<>();

    public Card(String name, String description, int price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public void doActions() throws Exception {
        for (Command command : commands) {
            command.run();
        }
    }

    public void addCommands(Command command) {
        if (commands == null) {
            commands = new ArrayList<>();
        }
        commands.add(command);
    }

    public static Card getCardByName(String name) {
        if (allCards.containsKey(name)) {
            return allCards.get(name);
        }
        return null;
    }

    public int getPrice() {
        return price;
    }

    public static TreeMap<String, Card> getAllCards() {
        return allCards;
    }

    public static void addCardToDatabase(Card card) {
        allCards.put(card.getName(), card);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void addCommandsToCard() {
        if (this.getName().equals(Spell.POT_OF_GREED.toString()))
            addCommands(new PotOfGreed());
        else if (this.getName().equals(Spell.TERRAFORMING.toString()))
            addCommands(new Terrafoming());
        else if (this.getName().equals(Spell.UMIIRUKA.toString()) ||
                this.getName().equals(Spell.YAMI.toString()) || this.getName().equals(Spell.FOREST.toString()) ||
                this.getName().equals(Spell.CLOSED_FOREST.toString()))
            addCommands(new FieldCard());
    }

    public void setCommands(ArrayList<Command> commands) {
        ArrayList<Command> commands1 = new ArrayList<>();
    }
}
