package Container.Menu;

import Container.Field.GameField;
import Container.Main;
import javafx.animation.TranslateTransition;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;

public class GameMenu extends Parent {
    public GameMenu(Stage stage) {

        VBox menu0 = new VBox(10);
        VBox menu1 = new VBox(10);

        menu0.setTranslateX(550);
        menu0.setTranslateY(300);

        menu1.setTranslateX(550);
        menu1.setTranslateY(300);

        final int offset = 1500;

        menu1.setTranslateX(offset);

        menuButton btnStart = new menuButton("START GAME");
        btnStart.setPrefSize(250,40);
        btnStart.setStyle("-fx-font: 25 arial; -fx-base: #94f4f7;");
        btnStart.setOnMouseClicked(event -> {
            String a = "src/AssetsKit_1/sounds/8_music.mp3";
            Media music = new Media(new File(a).toURI().toString());
            MediaPlayer m = new MediaPlayer(music);
            m.play();
            GameField.startGame=true;
            stage.setScene(Main.scene2);
        });


        menuButton btnOptions = new menuButton("OPTIONS");
        btnOptions.setPrefSize(250,40);
        btnOptions.setStyle("-fx-font: 25 arial; -fx-base: #94f4f7;");
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

        menuButton btnHelp = new menuButton("HELP");
        btnHelp.setPrefSize(250,40);
        btnHelp.setStyle("-fx-font: 25 arial; -fx-base: #94f4f7;");

        menuButton btnExit = new menuButton("QUIT");
        btnExit.setPrefSize(250,40);
        btnExit.setStyle("-fx-font: 25 arial; -fx-base: #94f4f7;");
        btnExit.setOnMouseClicked(e -> {
            System.exit(0);
        });

        menuButton btnBack = new menuButton("BACK");
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

        menuButton btnSound = new menuButton("SOUND");
        menuButton btnVideo = new menuButton("VIDEO");

        menu0.getChildren().addAll(btnStart, btnOptions, btnHelp, btnExit);
        menu1.getChildren().addAll(btnBack, btnSound, btnVideo);

        getChildren().add(menu0);
    }
}