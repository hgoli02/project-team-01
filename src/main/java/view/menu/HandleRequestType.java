package view.menu;

import controller.exceptions.CardNameNotExists;
import view.Menu;

import java.io.IOException;
import java.util.Scanner;

public class HandleRequestType {
    public static Scanner scanner = new Scanner(System.in);
    public static Menu currentMenu = Menu.REGISTER_MENU;

    public void start() throws Exception {
        RegisterView registerView = new RegisterView();
        ProfileView profileView = new ProfileView();
        ScoreBoardView scoreBoardView = new ScoreBoardView();
        ShopView shopView = new ShopView();
        DeckView deckView = new DeckView();
        GameView gameView = new GameView();
        ImportExportView importExportView = new ImportExportView();
        MainMenu mainMenu = new MainMenu();
        while (currentMenu != Menu.EXIT) {
            String command = scanner.nextLine();
            if (currentMenu == Menu.REGISTER_MENU) {
                registerView.run(command);
            } else if (currentMenu == Menu.MAIN_MENU) {
                mainMenu.run(command);
            } else if (currentMenu == Menu.DECK_MENU) {
                deckView.run(command);
            } else if (currentMenu == Menu.PROFILE_VIEW) {
                profileView.run(command);
            } else if (currentMenu == Menu.GAME_MENU) {
                gameView.run(command);
            } else if (currentMenu == Menu.IMPORT_EXPORT) {
                importExportView.run(command);
            } else if (currentMenu == Menu.SHOP) {
                shopView.run(command);
            } else if (currentMenu == Menu.SCOREBOARD) {
                scoreBoardView.run(command);
            } else {
                throw new RuntimeException("core adaption failed!");
            }
        }
    }

}

