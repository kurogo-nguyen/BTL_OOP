package Container.Tower;


import Container.Menu.Audio;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class NormalTower extends Tower{

    public NormalTower(double x , double y){
        this.shootingRange = 200;
        this.damage = 10;
        this.x = x;
        this.y = y;
        this.img = new Image("file:src/AssetsKit_2/PNG/Default size/towerDefense_tile181.png");
        this.gunImg = new Image("file:src/AssetsKit_2/PNG/Default size/towerDefense_tile249.png");
    }
    public Bullet creatBullet(double x , double y , double rotation){
        Bullet bullet = super.creatBullet(x , y , rotation);
        bullet.img = new Image("file:src/AssetsKit_2/PNG/Default size/towerDefense_tile272.png");
        return bullet;
    }
//    public static Tower createNormalTower(double X , double Y) {
//        Tower tower = new NormalTower();
//        tower.x = X;
//        tower.y = Y;
//        tower.img = new Image("file:src/AssetsKit_2/PNG/Default size/towerDefense_tile181.png");
//        tower.gunImg = new Image("file:src/AssetsKit_2/PNG/Default size/towerDefense_tile249.png");
//        return tower;
//    }
    public void render(GraphicsContext gc){
        super.render(gc);
    }

    public void update() {
        super.update();

    }
}