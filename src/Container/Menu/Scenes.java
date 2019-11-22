package Container.Menu ;

import Container.Main;
import Container.SettingStartGame.SettingStart;
import javafx.animation.FadeTransition;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import Container.GameObj;

import java.util.ArrayList;
import java.util.List;

public class Scenes {
    public static Scene menuGame(Stage stage){
        Pane root = new Pane();
        root.setPrefSize(18 * 64 + 250, 12 * 64);

        Image img = new Image("file:src/AssetsKit_2/gameStart.jpg");

        ImageView imgView = new ImageView(img);
        imgView.setFitWidth(18 * 64 + 250);
        imgView.setFitHeight(12 * 64);

        GameMenu gameMenu = new GameMenu(stage);
        //gameMenu.setVisible(true);
        root.getChildren().addAll(imgView, gameMenu);
        Scene scene = new Scene(root);
        return scene;

    }

    public static Scene gameTowerDF(){
        List<GameObj> gameObjects = new ArrayList<>();
        Canvas canvas = new Canvas(64 * 18 + 250, 64 * 12);
        Main.gc = canvas.getGraphicsContext2D();
        Group root = new Group();
        SettingStart settingStart = new SettingStart();
        root.getChildren().addAll(canvas, settingStart);
        Scene scene = new Scene(root);
        return scene ;
    }

}
