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
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Main extends Application {
    public static Stage stage;
    public static Scene scene;
    public static GraphicsContext gc;

    public void start(Stage primarystage) {
        stage = primarystage;
        GameField gameField = new GameField();
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
        stage.show();

    }

}










