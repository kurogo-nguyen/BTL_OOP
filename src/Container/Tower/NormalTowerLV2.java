package Container.Tower;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class NormalTowerLV2 extends Tower {
    public NormalTowerLV2() {
        cost=20;
        this.shootingRange = 4*64;
        this.img = new Image("file:src/AssetsKit_2/PNG/Default size/towerDefense_tile182.png");
        this.gunImg = new Image("file:src/AssetsKit_2/PNG/Default size/towerDefense_tile250.png");
    }
    public NormalTowerLV2(double x , double y){
        cost=20;
        this.selling = 30 ;
        this.shootingRange = 4*64;
        this.damage = 50;
        this.x = x;
        this.y = y;
        this.img = new Image("file:src/AssetsKit_2/PNG/Default size/towerDefense_tile182.png");
        this.gunImg = new Image("file:src/AssetsKit_2/PNG/Default size/towerDefense_tile250.png");
    }
    public Bullet creatBullet(double x , double y , double rotation){
        Bullet bullet = super.creatBullet(x , y , rotation);
        bullet.img = new Image("file:src/AssetsKit_2/PNG/Default size/towerDefense_tile274.png");
        return bullet;
    }
    public static Tower createNormalTower(double X , double Y) {
        Tower tower = new NormalTower();
        tower.x = X;
        tower.y = Y;
        tower.img = new Image("file:src/AssetsKit_2/PNG/Default size/towerDefense_tile182.png");
        tower.gunImg = new Image("file:src/AssetsKit_2/PNG/Default size/towerDefense_tile250.png");
        return tower;
    }
    public void render(GraphicsContext gc){
        super.render(gc);
    }

    public void update() {
        super.update();

    }
    public void upgrade(){

    }

    @Override
    public Image infoImage() {
        return new Image("file:src/AssetsKit_2/cannon2.png");
    }
}
