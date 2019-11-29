package src.Tower;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import src.Enemy.Enemy;
import src.Field.GameField;
import src.GameObj;

import java.util.List;


public class Bullet extends GameObj {
    int rateOfFire;
    int damage;
    int speedX;
    int speedY;
    List<Bullet> bullets;

    @Override
    public void render(GraphicsContext gc) {
        gc.drawImage(img, x, y);
    }

    @Override
    public void update() {
//        x+=speedX;
//        y+=speedY;
    }
    Bullet(double towerX, double towerY){
        img=new Image("file:src/AssetsKit_2/PNG/Default size/towerDefense_tile272.png");
        x=towerX;
        y=towerY;
    }

//    void creatNormalBullet(){
////        Circle bullet = new Circle(2, Color.YELLOW);
//        Bullet a= new Bullet();
//        bullets.add(a);
//    }
    boolean isCollision(){
        for(Enemy i: GameField.enemies)
            if (x == i.x && y == i.y)   return true;
        return false;
    }

}
