package Container.Menu ;

import Container.Field.GameField;
import Container.Field.Parameter;
import Container.Main;
import javafx.animation.TranslateTransition;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class GameMenu extends Parent implements Parameter {
    public GameMenu() {

        VBox menu0 = new VBox(10);
        VBox menu1 = new VBox(10);

        menu0.setTranslateX(550);
        menu0.setTranslateY(300);

        menu1.setTranslateX(550);
        menu1.setTranslateY(300);

        final int offset = screenWidth+1;

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

        MenuButton btnHighScore = new MenuButton("High Score");
        btnHighScore.setOnMouseClicked(mouseEvent -> {
            Image imageHighScore = new Image("file:resource/image/highScoreImage.png",screenWidth, screenHeight,false,false);
            ImageView ivHighScore = new ImageView(imageHighScore);

//            File file = new File("resource/HighScore.txt");
            try {
//                FileOutputStream fileOutputStream =new FileOutputStream(file);
//                String b="Huy          1000\n" +
//                         "Duc Anh       500";
//                fileOutputStream.write(b.getBytes());
                FileInputStream fileInputStream = new FileInputStream("resource/HighScore.txt");
                String a =new String();
                int charIndex = fileInputStream.read();
                while (charIndex!=-1){
                    a+=(char)charIndex;
                    charIndex=fileInputStream.read();
                }
                Text text = new Text(screenWidth/2, screenHeight/3, a);
                text.setStyle("-fx-font: 31 arial ; -fx-fill: #0026e7;");
                btnBack.setLayoutX(screenWidth/2-125);
                btnBack.setLayoutY(500);
                btnBack.setOnMouseClicked(mouseEvent1 -> {
                    getChildren().removeAll(ivHighScore,text, btnBack);
                });
                getChildren().addAll(ivHighScore,text, btnBack);
                System.out.println(a);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        MenuButton btnSound = new MenuButton("SOUND");
        MenuButton btnVideo = new MenuButton("VIDEO");

        menu0.getChildren().addAll(btnStart, btnOptions, btnHighScore, btnExit);
        menu1.getChildren().addAll(btnBack, btnSound, btnVideo);

        getChildren().add(menu0);
    }
}