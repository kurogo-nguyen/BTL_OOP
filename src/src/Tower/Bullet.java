package src.Tower;


import src.Field.GameField;
import src.GameObj;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import java.util.List;


public class Bullet extends GameObj {
    int rateOfFire;
    int damage;
    int shootingRange;
    int speed;
    List<Bullet> bullets;

    @Override
    public void render(GraphicsContext gc) {

    }

    @Override
    public void update() {
        x+=speed;
        y+=speed;
    }
    public Bullet(){
        img=new Image("file:src/AssetsKit_2/PNG/Default size/towerDefense_tile272.png");
        speed=10;
        x=50;
        y=50;
    }
    void creatNormalBullet(){
//        Circle bullet = new Circle(2, Color.YELLOW);
        Bullet a= new Bullet();
        bullets.add(a);
    }
    boolean isCollision(){
//        for(GameObj i: GameField.gameObjects){
//            if(x==i.x && y==i.y){
//                i.heath
//            }
//        }
    }

}
