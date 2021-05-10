package model.card;

import com.google.gson.annotations.Expose;
import com.sun.org.apache.xpath.internal.operations.Neg;
import controller.Effect;
import model.commands.*;

import java.util.ArrayList;
import java.util.TreeMap;

public abstract class Card {
    private static final TreeMap<String, Card> allCards = new TreeMap<>();
    private final String name;
    private final String description;
    private final int price;
    protected String type = "type";
    @Expose(serialize = false, deserialize = false)
    protected ArrayList<Command> commands = new ArrayList<>();

    public Card(String name, String description, int price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public ArrayList<Command> getCommands() {
        return commands;
    }

    public void doActions() throws Exception {
        for (Command command : commands) {
            command.run();
        }
    }

    public void doContinuousActions() throws Exception {
        for (Command command : commands) {
            command.runContinuous();
        }
    }

    public boolean canActivate() throws Exception {
        for (Command command : commands) {
            if (command.canActivate()){
                return true;
            }
        }
        return false;
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
        if (this.getName().equals(Effect.POT_OF_GREED.toString())) {
            addCommands(new PotOfGreed());
        } else if (this.getName().equals(Effect.RAIGEKI.toString())) {
            addCommands(new Raigeki());
        } else if (this.getName().equals(Effect.MYSTICAL_SPACE_TYPHOON.toString())) {
            addCommands(new MysticalSpaceTyphoon());
        } else if (this.getName().equals(Effect.MONSTER_REBORN.toString())) {
            addCommands(new MonsterReborn());
        } else if (this.getName().equals(Effect.TWIN_TWISTERS.toString())) {
            addCommands(new TwinTwisters());
        } else if (this.getName().equals(Effect.HARPIES_FEATHER_DUSTER.toString())) {
            addCommands(new HarpiesFeatherDuster());
        } else if (this.getName().equals(Effect.DARK_HOLE.toString())) {
            addCommands(new DarkHole());
        } else if (this.getName().equals(Effect.BLACK_PENDANT.toString())) {
            addCommands(new EquipNormal());
        } else if (this.getName().equals(Effect.MAGNUM_SHIELD.toString())) {
            addCommands(new EquipWarrior());
        } else if (this.getName().equals(Effect.UNITED_WE_STAND.toString())) {
            addCommands(new EquipNormal());
        } else if (this.getName().equals(Effect.SWORD_OF_DESTRUCTION.toString())) {
            addCommands(new EquipFiend());
        } else if (this.getName().equals(Effect.TERRAFORMING.toString()))
            addCommands(new Terrafoming());
        else if (this.getName().equals(Effect.UMIIRUKA.toString()) ||
                this.getName().equals(Effect.YAMI.toString()) || this.getName().equals(Effect.FOREST.toString()) ||
                this.getName().equals(Effect.CLOSED_FOREST.toString()))
            addCommands(new FieldCard());
        else if (this.getName().equals(Effect.CHANGE_OF_HEART.toString()))
            addCommands(new ChangeOfHeart());
        else if (this.getName().equals(Effect.SUPPLY_SQUAD.toString()))
            addCommands(new SupplySquad());
        else if (this.getName().equals(Effect.NEGATE_ATTACK.toString()))
            addCommands(new NegateAttack());
    }

}
