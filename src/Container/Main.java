package Container ;

import Container.Field.GameField;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;


import static Container.Field.GameField.creatGameField;
import static Container.Menu.Scenes.gameTowerDF;

public class Main extends Application {
    public static Scene scene1, scene2;
    public static GraphicsContext gc;
    public static Stage stage;

    public void start(Stage stage) {
        stage.setTitle("Tower defense");
        creatGameField(stage);
        scene2 = gameTowerDF();
        stage.setScene(scene1);
        stage.show();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                    GameField.render(gc);
                    GameField.update();
            }
        };
        timer.start();

    }
}










