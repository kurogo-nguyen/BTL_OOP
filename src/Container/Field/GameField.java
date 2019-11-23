package Container.Field;

import Container.Enemy.SmallerEnemy;
import Container.Enemy.TankerEnemy;
import Container.GameObj;
import Container.Main;
import Container.Menu.Scenes;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameField extends GameStage{
    public static boolean startLevel = false;
    static int count=2;
    public static boolean startGame = false;
    public static GraphicsContext gc;
    public static List<GameObj> gameObjects = new ArrayList<>();
    public static List<Point> PointsCanNotBuild = new ArrayList<>();

    public static int level ;
    public static int lives ;
    public static int cash ;

    public static void creatGameField(Stage stage) {
        Main.scene1 = Scenes.menuGame(stage);
        stage.setScene(Main.scene1);
        level = 1;
        lives = 20;
        cash = 50;
        Timeline timeline = new Timeline();
        KeyFrame keyFrame = new KeyFrame(Duration.millis(5000), event -> {
            gameObjects.addAll(SmallerEnemy.listSoldiers());
            gameObjects.addAll(TankerEnemy.listTanks());
            if(count == 0) timeline.stop();
            count --;

        });

        timeline.getKeyFrames().add(keyFrame);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public static void setPointCanNotBuild() {
        List<String> pointCanNotBuild = new ArrayList<>(Arrays.asList("023", "025", "003", "047", "299", "048", "001", "027", "002", "004", "026", "046", "218", "244", "265", "240", "242"));
        for (int i = 0; i < MAP_SPRITES.length; i++) {
            for (int j = 0; j < MAP_SPRITES[i].length; j++) {
                if (pointCanNotBuild.contains(MAP_SPRITES[i][j])) {
                    PointsCanNotBuild.add(new Point(64 * j, 64 * i));
                }
            }
        }
    }

    public static final String[][] MAP_SPRITES = new String[][] {
            { "024", "025", "023", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "242", "240", "114", "241" },
            { "024", "025", "023", "024", "024", "003", "047", "047", "047", "047", "004", "024", "024", "024", "242", "240", "241", "241" },
            { "041", "025", "023", "024", "024", "025", "299", "001", "001", "002", "023", "024", "024", "024", "242", "240", "241", "241" },
            { "024", "025", "023", "024", "024", "025", "023", "024", "024", "025", "023", "024", "024", "024", "242", "240", "241", "109" },
            { "024", "025", "023", "024", "024", "025", "023", "045", "024", "025", "023", "024", "024", "024", "242", "240", "241", "241" },
            { "024", "025", "023", "024", "024", "025", "023", "045", "024", "025", "023", "024", "024", "024", "242", "240", "241", "241" },
            { "024", "025", "046", "047", "047", "048", "023", "024", "024", "025", "023", "024", "024", "024", "242", "240", "241", "241" },
            { "024", "026", "001", "001", "001", "001", "027", "024", "024", "025", "046", "047", "047", "047", "265", "240", "241", "098" },
            { "024", "024", "024", "024", "024", "024", "024", "024", "024", "026", "001", "001", "001", "001", "218", "244", "098", "098" },
            { "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024" },
            { "024", "024", "024", "024", "039", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024", "024" }

    };


    //diem dinh huong
    public static final Point[] wayPoints = new Point[] {
            new Point(14 * 64 + 32, 7 * 64 + 32),
            new Point(9 * 64 + 32, 7 * 64 + 32),
            new Point(9 * 64 + 32, 1 * 64 + 32),
            new Point(5 * 64 + 32, 1 * 64 + 32),
            new Point(5 * 64 + 32, 6 * 64 + 32),
            new Point(1 * 64 + 32, 6 * 64 + 32),
            new Point(1 * 64 + 32,-1 * 64 + 00),
    };

    public static double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    public static void drawMap(GraphicsContext gc) {
        for (int i = 0; i < MAP_SPRITES.length; i++) {
            for (int j = 0; j < MAP_SPRITES[i].length; j++) {
                gc.drawImage(new Image("file:src/AssetsKit_2/PNG/Default size/towerDefense_tile" + MAP_SPRITES[i][j] + ".png"), j * 64, i * 64);
            }
        }
        gc.drawImage(new Image("file:src/AssetsKit_2/PNG/Default size/towerDefense_tile137.png") , 80 + 14 * 64,  10 * 64);
        gc.drawImage(new Image("file:src/AssetsKit_2/PNG/Default size/towerDefense_tile136.png") , 128 + 14 *64, 30 + 9 * 64 );
        gc.drawImage(new Image("file:src/AssetsKit_2/PNG/Default size/towerDefense_tile134.png") , 4 * 64  + 25, 8 * 64 + 25);
        gc.drawImage(new Image("file:src/AssetsKit_2/PNG/Default size/towerDefense_tile134.png") , 6 * 64 , 9 * 64 );
        gc.drawImage(new Image("file:src/AssetsKit_2/PNG/Default size/towerDefense_tile131.png") , 11 * 64 , 0);
        gc.drawImage(new Image("file:src/AssetsKit_2/PNG/Default size/towerDefense_tile130.png") , 12 * 64 , 32 );
    }

    //update vi tri enemy
    public static void render(GraphicsContext gc) {
        drawMap(gc);
        gameObjects.forEach(g -> g.render(gc));
    }

    public static void update() {
        gameObjects.forEach(GameObj::update);
    }

    public static void reset(){
        count = 2;
        startGame = false;
        startLevel = false;
        level = 1;
        lives = 20;
        cash = 50;

        PointsCanNotBuild.removeAll(PointsCanNotBuild);
        gameObjects.removeAll(gameObjects);
        Main.scene2 = Scenes.menuGame(Main.stage);
        Main.stage.setScene(Main.scene2);

        Timeline timeline = new Timeline();
        KeyFrame keyFrame = new KeyFrame(Duration.millis(5000), event -> {
            gameObjects.addAll(SmallerEnemy.listSoldiers());
            gameObjects.addAll(TankerEnemy.listTanks());
            if(count == 0) timeline.stop();
            count --;

        });

        timeline.getKeyFrames().add(keyFrame);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
}
