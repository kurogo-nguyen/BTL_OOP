package Container.Menu ;

import Container.Field.GameField;
import Container.Field.Parameter;
import Container.Main;
import Container.Player;
import Container.SettingStartGame.SettingItem;
import Container.SettingStartGame.SettingStart;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import Container.GameObj;

import java.util.ArrayList;
import java.util.List;

public class Scenes implements Parameter {
    public static Text scoreText = new Text();
    public static Group root ;
    public static SettingItem gameFactors ;
    public static Scene menuGame(){
        Pane root = new Pane();
        root.setPrefSize(screenWidth, screenHeight);

        Image img = new Image("file:src/AssetsKit_2/gameStart.jpg");

        ImageView imgView = new ImageView(img);
        imgView.setFitWidth(screenWidth);
        imgView.setFitHeight(screenHeight);

        GameMenu gameMenu = new GameMenu();
        //gameMenu.setVisible(true);
        Audio.PlayBackgroundMusic(root);
        root.getChildren().addAll(imgView, gameMenu);
        Scene scene = new Scene(root);
        return scene;

    }

    public static Scene gameTowerDF(){
        List<GameObj> gameObjects = new ArrayList<>();
        Canvas canvas = new Canvas(64 * 18 + 250, 64 * 12);
        Main.gc = canvas.getGraphicsContext2D();
        root = new Group();

        gameFactors = new SettingItem(GameField.level , Player.lives , Player.cash);
        gameFactors.setTranslateX(0);
        gameFactors.setTranslateY(11 * 64);
        SettingStart settingStart = new SettingStart();
        root.getChildren().addAll(canvas , settingStart , gameFactors );
        Scene scene = new Scene(root);
        return scene ;
    }
    public static Scene gameOver(){
        Pane root = new Pane();
        root.setPrefSize(1366 , 768);
        Image img = new Image("file:src/AssetsKit_2/gameOver.png");
        ImageView imgView = new ImageView(img);
        imgView.setFitWidth(1366);
        imgView.setFitHeight(768);
        root.getChildren().addAll(imgView);
        Scene scene = new Scene(root);
        scene.setCursor(Cursor.HAND);
        scene.setOnMouseClicked(e ->{
            if(e.getSceneX() > 567 && e.getSceneX() < 800 && e.getSceneY() > 360 && e.getSceneY() < 405){
                Main.scene = Scenes.gameTowerDF();
                Main.stage.setScene(Main.scene);
                GameField.startGame = true;
            }
            if(e.getSceneX() > 567 && e.getSceneX() < 800 && e.getSceneY() > 435 && e.getSceneY() < 484){
                System.exit(0);
            }
        });
        return scene;
    }

}
