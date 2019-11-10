package Container.Menu ;

import Container.Field.GameField;
import Container.Main;
import Container.Menu.MenuButton;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;


public class GameMenu extends Parent {
    public GameMenu() {

        VBox menu0 = new VBox(10);
        VBox menu1 = new VBox(10);

        menu0.setTranslateX(550);
        menu0.setTranslateY(300);

        menu1.setTranslateX(550);
        menu1.setTranslateY(300);

        final int offset = 1500;

        menu1.setTranslateX(offset);

        MenuButton btnStart = new MenuButton("START GAME");
        btnStart.setOnMouseClicked(event -> {
            Main.scene = Scenes.gameTowerDF();
            Main.stage.setScene(Main.scene);
            GameField.startGame = true;
        });


        MenuButton btnOptions = new MenuButton("OPTIONS");
        btnOptions.setOnMouseClicked(event -> {
            getChildren().add(menu1);

            TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu0);
            tt.setToX(menu0.getTranslateX() - offset);

            TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu1);
            tt1.setToX(menu0.getTranslateX());

            tt.play();
            tt1.play();

            tt.setOnFinished(e -> {
                getChildren().remove(menu0);
            });
        });
        MenuButton btnHelp = new MenuButton("HELP");

        MenuButton btnExit = new MenuButton("QUIT");
        btnExit.setOnMouseClicked(e -> {
            System.exit(0);
        });

        MenuButton btnBack = new MenuButton("BACK");
        btnBack.setOnMouseClicked(event -> {
            getChildren().add(menu0);

            TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu1);
            tt.setToX(menu1.getTranslateX() + offset);

            TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu0);
            tt1.setToX(menu1.getTranslateX());

            tt.play();
            tt1.play();

            tt.setOnFinished(e -> {
                getChildren().remove(menu1);
            });
        });

        MenuButton btnSound = new MenuButton("SOUND");
        MenuButton btnVideo = new MenuButton("VIDEO");

        menu0.getChildren().addAll(btnStart, btnOptions, btnHelp, btnExit);
        menu1.getChildren().addAll(btnBack, btnSound, btnVideo);

        getChildren().add(menu0);
    }
}