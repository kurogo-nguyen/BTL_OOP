package Container.Tower;

import Container.GameObj;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import java.util.ArrayList;
import java.util.List;

public class Bullet extends GameObj {
    public static List<Bullet> bullets = new ArrayList<>();
    protected int rateOfFire;
    public Bullet(){}
    public Bullet(double x , double y , double rotation) {
        this.rateOfFire = 15;
        this.img = new Image("file:src/AssetsKit_2/PNG/Default size/towerDefense_tile272.png");
        this.x = x;
        this.y = y;
        this.rotation = rotation;
    }

    public void render(GraphicsContext gc){
        gc.drawImage(this.img , this.x , this.y);
    }
    public void update(){
        this.x += rateOfFire * Math.cos(Math.toRadians(rotation - 90));
        this.y += rateOfFire * Math.sin(Math.toRadians(rotation - 90));
    }

}
