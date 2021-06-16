package controller;

import endpoint.Main;
import model.Board;
import model.card.Card;
import model.card.CardType;
import model.card.MonsterCard;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.menu.HandleRequestType;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class GameControllerTest {


    private InputStream sysInBackup;
    private ByteArrayInputStream in;
    private Board board;
    private GameController gameController;

    @BeforeEach
    public void init() throws Exception {
        gameController = GameController.getInstance();
        DatabaseController.loadGameCards();
    }

    @Test
    @DisplayName("field spell umiiruka")
    void test1() throws Exception {
        String input = new String(Files.readAllBytes(Paths.get("src/test/java/controller/field_test.txt")));
        sysInBackup = System.in;
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        HandleRequestType.scanner = new Scanner(System.in);
        Main.main(new String[1]);
        board = GameController.getInstance().getGameBoard();
        gameController = GameController.getInstance();
        gameController.selectPlayerCard("monster", 4);
        assertEquals(gameController.getZoneSlotSelectedCard().getAttack(), 800);
        assertEquals(gameController.getZoneSlotSelectedCard().getDefence(), 1400);
        gameController.selectOpponentCard("monster", 3);
        assertEquals(gameController.getZoneSlotSelectedCard().getAttack(), 800);
        assertEquals(gameController.getZoneSlotSelectedCard().getDefence(), 1400);
        gameController.selectPlayerCard("hand", 4);
        gameController.setCard();
        gameController.selectPlayerCard("field");
        assertNotNull(gameController.selectedCard.getCard());
        gameController.selectPlayerCard("monster", 4);
        assertEquals(gameController.getZoneSlotSelectedCard().getAttack(), 1300);
        assertEquals(gameController.getZoneSlotSelectedCard().getDefence(), 1000);
        gameController.selectOpponentCard("monster", 3);
        assertEquals(gameController.getZoneSlotSelectedCard().getAttack(), 1300);
        assertEquals(gameController.getZoneSlotSelectedCard().getDefence(), 1000);
    }

    @Test
    @DisplayName("field spell Yami")
    void test13() throws Exception {
        String input = new String(Files.readAllBytes(Paths.get("src/test/java/controller/field_test2.txt")));
        sysInBackup = System.in;
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        HandleRequestType.scanner = new Scanner(System.in);
        Main.main(new String[1]);
        board = GameController.getInstance().getGameBoard();
        gameController = GameController.getInstance();
        gameController.selectPlayerCard("monster", 4);
        assertEquals(gameController.getZoneSlotSelectedCard().getAttack(), 300);
        assertEquals(gameController.getZoneSlotSelectedCard().getDefence(), 500);
        gameController.selectOpponentCard("monster", 3);
        assertEquals(gameController.getZoneSlotSelectedCard().getAttack(), 1300);
        assertEquals(gameController.getZoneSlotSelectedCard().getDefence(), 1000);
        gameController.selectPlayerCard("hand", 4);
        gameController.setCard();
        gameController.selectPlayerCard("field");
        assertNotNull(gameController.selectedCard.getCard());
        gameController.selectPlayerCard("monster", 4);
        assertEquals(gameController.getZoneSlotSelectedCard().getAttack(), 100);
        assertEquals(gameController.getZoneSlotSelectedCard().getDefence(), 300);
        gameController.selectOpponentCard("monster", 3);
        System.out.println(gameController.getSelectedCard().getCard().getName());
        assertEquals(gameController.getZoneSlotSelectedCard().getAttack(), 1500);
        assertEquals(gameController.getZoneSlotSelectedCard().getDefence(), 1200);
    }

    @Test
    @DisplayName("field spell Forest")
    void test14() throws Exception {
        String input = new String(Files.readAllBytes(Paths.get("src/test/java/controller/field_test3.txt")));
        sysInBackup = System.in;
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        HandleRequestType.scanner = new Scanner(System.in);
        Main.main(new String[1]);
        board = GameController.getInstance().getGameBoard();
        gameController = GameController.getInstance();
        gameController.selectPlayerCard("monster", 4);
        assertEquals(gameController.getZoneSlotSelectedCard().getAttack(), 1200);
        assertEquals(gameController.getZoneSlotSelectedCard().getDefence(), 800);
        gameController.selectOpponentCard("monster", 3);
        assertEquals(gameController.getZoneSlotSelectedCard().getAttack(), 450);
        assertEquals(gameController.getZoneSlotSelectedCard().getDefence(), 600);
        gameController.selectPlayerCard("hand", 4);
        gameController.setCard();
        gameController.selectPlayerCard("field");
        assertNotNull(gameController.selectedCard.getCard());
        gameController.selectOpponentCard("monster", 3);
        assertEquals(gameController.getZoneSlotSelectedCard().getAttack(), 650);
        assertEquals(gameController.getZoneSlotSelectedCard().getDefence(), 800);
        gameController.selectPlayerCard("monster", 4);
        assertEquals(gameController.getZoneSlotSelectedCard().getAttack(), 1400);
        assertEquals(gameController.getZoneSlotSelectedCard().getDefence(), 1000);
    }

    @Test
    @DisplayName("field spell Closed Forest")
    void test15() throws Exception {
        String input = new String(Files.readAllBytes(Paths.get("src/test/java/controller/field_test4.txt")));
        sysInBackup = System.in;
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        HandleRequestType.scanner = new Scanner(System.in);
        Main.main(new String[1]);
        board = GameController.getInstance().getGameBoard();
        gameController = GameController.getInstance();
        gameController.selectPlayerCard("monster", 3);
        assertEquals(gameController.getZoneSlotSelectedCard().getAttack(), 1200);
        assertEquals(gameController.getZoneSlotSelectedCard().getDefence(), 800);
        gameController.selectPlayerCard("hand", 7);
        gameController.setCard();
        gameController.selectPlayerCard("field");
        assertNotNull(gameController.selectedCard.getCard());
        gameController.selectPlayerCard("monster", 3);
        assertEquals(gameController.getZoneSlotSelectedCard().getAttack(), 1300);
        assertEquals(gameController.getZoneSlotSelectedCard().getDefence(), 800);
    }

    @Test
    @DisplayName("twin twisters")
    void test2() throws Exception {
        String input = new String(Files.readAllBytes(Paths.get("src/test/java/controller/twin_twisters.txt")));
        sysInBackup = System.in;
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        HandleRequestType.scanner = new Scanner(System.in);
        Main.main(new String[1]);
        board = GameController.getInstance().getGameBoard();
        gameController = GameController.getInstance();
        assertEquals(board.getPlayerOneGraveYard().size(), 2);
        assertEquals(board.getPlayerTwoGraveYard().size(), 2);
        ArrayList<String> names = new ArrayList<>();
        for (Card card : board.getPlayerTwoGraveYard()) {
            names.add(card.getName());
        }
        assertTrue(names.contains("Twin Twisters"));

    }

    @Test
    @DisplayName("scanner")
    void test3() throws Exception {
        String input = new String(Files.readAllBytes(Paths.get("src/test/java/controller/scanner_test.txt")));
        sysInBackup = System.in;
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        HandleRequestType.scanner = new Scanner(System.in);
        Main.main(new String[1]);
        board = GameController.getInstance().getGameBoard();
        gameController = GameController.getInstance();
        assertEquals(gameController.getZoneSlotSelectedCard().getAttack(), 1200);
        assertEquals(gameController.getZoneSlotSelectedCard().getDefence(), 700);
        assertEquals(gameController.getZoneSlotSelectedCard().getCard().getName(), "Baby dragon");
    }

    @Test
    @DisplayName("negateAttack")
    void negate() throws Exception {
        String input = new String(Files.readAllBytes(Paths.get("src/test/java/controller/negateAttack")));
        sysInBackup = System.in;
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        HandleRequestType.scanner = new Scanner(System.in);
        Main.main(new String[1]);
        board = GameController.getInstance().getGameBoard();
        gameController = GameController.getInstance();
        assertEquals(8000, gameController.getOpponentLp());
        assertNull(gameController.getGameBoard().getPlayerSpellZone(2)[1].getCard());
    }

    @Test
    @DisplayName("mind crush")
    void test5() throws Exception {
        String input = new String(Files.readAllBytes(Paths.get("src/test/java/controller/mind_crush.txt")));
        sysInBackup = System.in;
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        HandleRequestType.scanner = new Scanner(System.in);
        Main.main(new String[1]);
        board = GameController.getInstance().getGameBoard();
        gameController = GameController.getInstance();
        assertEquals(board.getPlayerOneGraveYard().size(), 1);
        assertEquals(board.getPlayerTwoGraveYard().size(), 1);
        assertEquals(board.getPlayerTwoGraveYard().get(0).getName(), "Battle warrior");
        assertEquals(board.getPlayerOneGraveYard().get(0).getName(), "Mind Crush");
        assertNull(board.getPlayerSpellZone(1)[2].getCard());
    }

    @Test
    @DisplayName("mind crush2")
    void test6() throws Exception {
        String input = new String(Files.readAllBytes(Paths.get("src/test/java/controller/mind_crush2.txt")));
        sysInBackup = System.in;
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        HandleRequestType.scanner = new Scanner(System.in);
        Main.main(new String[1]);
        board = GameController.getInstance().getGameBoard();
        gameController = GameController.getInstance();
        assertNull(board.getPlayerSpellZone(1)[2].getCard());
        assertEquals(board.getPlayerOneHand().size(), 2);
    }

    @Test
    @DisplayName("Texchanger")
    void test4() throws Exception {
        String input = new String(Files.readAllBytes(Paths.get("src/test/java/controller/texchanger.txt")));
        sysInBackup = System.in;
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        HandleRequestType.scanner = new Scanner(System.in);
        Main.main(new String[1]);
        board = GameController.getInstance().getGameBoard();
        gameController = GameController.getInstance();
        assertEquals(gameController.getZoneSlotSelectedCard().getAttack(), 200);
        assertEquals(gameController.getZoneSlotSelectedCard().getDefence(), 2000);
        assertEquals(gameController.getZoneSlotSelectedCard().getCard().getName(), "Bitron");
        assertEquals(gameController.getOpponentLp(), 8000);
    }

    @Test
    @DisplayName("change of heart")
    void test7() throws Exception {
        String input = new String(Files.readAllBytes(Paths.get("src/test/java/controller/change_of_heart.txt")));
        sysInBackup = System.in;
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        HandleRequestType.scanner = new Scanner(System.in);
        Main.main(new String[1]);
        board = GameController.getInstance().getGameBoard();
        gameController = GameController.getInstance();
        assertNull(board.getPlayerTwoMonsterZone()[2].getCard());
        assertEquals(board.getPlayerOneMonsterZone()[4].getCard().getName(), "Alexandrite Dragon");
        assertEquals(board.getPlayerSpellZone(1)[2].getCard().getName(), "Change of Heart");
        for (int i = 0; i < 6; i++) {
            gameController.nextPhase();
        }
        assertNull(board.getPlayerOneMonsterZone()[4].getCard());
        assertEquals(board.getPlayerTwoMonsterZone()[2].getCard().getName(), "Alexandrite Dragon");
        assertNull(board.getPlayerSpellZone(1)[2].getCard());

    }

    @Test
    @DisplayName("man of heart")
    void test8() throws Exception {
        String input = new String(Files.readAllBytes(Paths.get("src/test/java/controller/man_eater_bug.txt")));
        sysInBackup = System.in;
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        HandleRequestType.scanner = new Scanner(System.in);
        Main.main(new String[1]);
        board = GameController.getInstance().getGameBoard();
        gameController = GameController.getInstance();
        assertNull(board.getPlayerTwoMonsterZone()[3].getCard());
    }

    @Test
    @DisplayName("terraforming")
    void test9() throws Exception {
        String input = new String(Files.readAllBytes(Paths.get("src/test/java/controller/terraforming.txt")));
        sysInBackup = System.in;
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        HandleRequestType.scanner = new Scanner(System.in);
        Main.main(new String[1]);
        gameController = GameController.getInstance();
        board = gameController.getGameBoard();
        assertEquals(board.getPlayerOneGraveYard().size(), 1);
        assertEquals(board.getPlayerOneGraveYard().get(0).getName(), "Terraforming");
        assertEquals(board.getPlayerOneHand().get(4).getName(), "Umiiruka");
    }

    @Test
    @DisplayName("dark hole")
    void test10() throws Exception {
        String input = new String(Files.readAllBytes(Paths.get("src/test/java/controller/darkhole.txt")));
        sysInBackup = System.in;
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        HandleRequestType.scanner = new Scanner(System.in);
        Main.main(new String[1]);
        gameController = GameController.getInstance();
        board = gameController.getGameBoard();
        assertEquals(board.numberOfMonsterCards(1), 0);
        assertEquals(board.numberOfMonsterCards(2), 0);
    }

    @Test
    @DisplayName("raigeki")
    void test11() throws Exception {
        String input = new String(Files.readAllBytes(Paths.get("src/test/java/controller/raigeki.txt")));
        sysInBackup = System.in;
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        HandleRequestType.scanner = new Scanner(System.in);
        Main.main(new String[1]);
        gameController = GameController.getInstance();
        board = gameController.getGameBoard();
        assertEquals(board.numberOfMonsterCards(2), 0);
        assertNotEquals(board.numberOfMonsterCards(1), 0);
    }

    @Test
    @DisplayName("set cards")
    void test12() throws Exception {
        String input = new String(Files.readAllBytes(Paths.get("src/test/java/controller/set_cards.txt")));
        sysInBackup = System.in;
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        HandleRequestType.scanner = new Scanner(System.in);
        Main.main(new String[1]);
        gameController = GameController.getInstance();
        board = gameController.getGameBoard();
        assertEquals(board.numberOfSpellAndTrapCards(2), 2);
        assertEquals(board.numberOfSpellAndTrapCards(1), 2);
        assertEquals(board.getPlayerSpellZone(1)[1].getCard().getName(), "Pot of Greed");
        assertEquals(board.getPlayerSpellZone(1)[2].getCard().getName(), "Trap Hole");
        assertEquals(board.getPlayerSpellZone(2)[1].getCard().getName(), "Pot of Greed");
        assertEquals(board.getPlayerSpellZone(2)[2].getCard().getName(), "Trap Hole");
    }

    @Test
    @DisplayName("black pendant")
    void blackT() throws Exception {
        String input = new String(Files.readAllBytes(Paths.get("src/test/java/controller/blackPendant.txt")));
        in = new ByteArrayInputStream(input.getBytes());
        HandleRequestType.scanner = new Scanner(in);
        Main.main(new String[1]);
        int original = ((MonsterCard) gameController.getGameBoard().getPlayerOneMonsterZone()[1].getCard()).getAttack();
        int boost = gameController.getGameBoard().getPlayerOneMonsterZone()[1].getAttack();
        assertEquals(boost - original, 500);
    }

    @Test
    @DisplayName("gate guardian")
    void gate() throws Exception {
        String input = new String(Files.readAllBytes(Paths.get("src/test/java/controller/gate.txt")));
        in = new ByteArrayInputStream(input.getBytes());
        HandleRequestType.scanner = new Scanner(in);
        Main.main(new String[1]);
        board = gameController.getGameBoard();
        assertEquals(board.getPlayerMonsterZone(1)[1].getCard().getName(), "Gate Guardian");
    }

    @Test
    @DisplayName("ritual")
    void ritual() throws Exception {
        String input = new String(Files.readAllBytes(Paths.get("src/test/java/controller/ritual")));
        in = new ByteArrayInputStream(input.getBytes());
        HandleRequestType.scanner = new Scanner(in);
        Main.main(new String[1]);
        board = gameController.getGameBoard();
        assertSame(((MonsterCard) (board.getPlayerOneMonsterZone()[1].getCard())).getCardType(), CardType.RITUAL);
    }

    @Test
    @DisplayName("monster reborn")
    void reborn() throws Exception {
        String input = new String(Files.readAllBytes(Paths.get("src/test/java/controller/reborn.txt")));
        in = new ByteArrayInputStream(input.getBytes());
        HandleRequestType.scanner = new Scanner(in);
        Main.main(new String[1]);
        board = gameController.getGameBoard();
        assertEquals("Monster Reborn", board.getPlayerTwoGraveYard().get(0).getName());
        assertEquals(5, board.getCardInMonsterZone(2).size());
    }

    @Test
    @DisplayName("magic jammer")
    void testJammmm() throws Exception {
        String input = new String(Files.readAllBytes(Paths.get("src/test/java/controller/magicJammer")));
        in = new ByteArrayInputStream(input.getBytes());
        HandleRequestType.scanner = new Scanner(in);
        Main.main(new String[1]);
        board = gameController.getGameBoard();
        assertEquals(0,board.getCardInSpellZone(1).size());
        assertEquals(0,board.getCardInSpellZone(2).size());
    }

    @AfterEach
    @DisplayName("cleanUp")
    void reset() throws IOException {
        gameController.endJunit();
        System.setIn(sysInBackup);
        in.close();
    }

}