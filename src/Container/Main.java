package Container ;

import Container.Field.GameField;
import javafx.animation.Animation;
import Container.Field.Point;
import Container.Menu.*;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static Container.Field.GameField.creatGameField;
import static Container.Menu.Scenes.gameTowerDF;
import static Container.Menu.Scenes.menuGame;

public class Main extends Application {
    public static Scene scene1, scene2;
    public static GraphicsContext gc;

    public void start(Stage stage) {
        stage.setTitle("Tower defense");
        creatGameField(stage);
        scene2 = gameTowerDF();
        stage.setScene(scene1);
        stage.show();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                if (GameField.startGame) {
                    GameField.render(gc);
                    GameField.update();
                }
            }
        };
        timer.start();

    }
}










