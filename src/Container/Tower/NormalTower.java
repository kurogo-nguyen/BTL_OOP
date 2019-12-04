package Container.Tower;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import Container.GameEntity;

public class NormalTower extends Tower{

    public static Tower createNormalTower(double X , double Y) {
        Tower tower = new NormalTower();
        tower.x = X;
        tower.y = Y;
        tower.img = new Image("file:src/AssetsKit_2/PNG/Default size/towerDefense_tile181.png");
        tower.gunImg = new Image("file:src/AssetsKit_2/PNG/Default size/towerDefense_tile249.png");
        return tower;
    }
    public void update() {

    }
}