package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ViewSwitcher {
    private static Stage stage;

    public static void switchTo(View view){
        Pane root = null;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(ViewSwitcher.class.getResource(view.getFileName())));
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert root != null;
        switch (view){
            case SCOREBOARD : {
                new ScoreboardView().init(root);
                break;
            }
            case IMPORTEXPORT : {
                new ImportExportView().init(root);
                break;
            }
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setMaximized(false);
        stage.show();
    }

    public static void setStage(Stage primaryStage) {
        stage = primaryStage;
    }
}
