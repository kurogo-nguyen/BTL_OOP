package Container.Enemy;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class BossEnemy extends Enemy{

    public Image gunImg;

    public void render(GraphicsContext gc){
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);

        ImageView iv = new ImageView(img);
        iv.setRotate(this.direction.getDegree());
        Image base = iv.snapshot(params, null);

        ImageView iv2 = new ImageView(gunImg);
        iv2.setRotate(this.direction.getDegree());
        Image gun = iv2.snapshot(params, null);

        gc.drawImage(base, x, y);
        gc.drawImage(gun, x, y);
    }

    public static BossEnemy createSoldier(int x){
        BossEnemy bossEnemy = new BossEnemy();
        bossEnemy.i = 14;
        bossEnemy.j = 1;
        bossEnemy.x = bossEnemy.i*64 +32;
        bossEnemy.y = bossEnemy.j *64 - x;
        bossEnemy.health = 1000;
        bossEnemy.armor = 5;
        bossEnemy.speed = 50;
        bossEnemy.img = new Image("file:src/AssetsKit_2/PNG/Default size/towerDefense_tile268.png");
        bossEnemy.gunImg = new Image("file:src/AssetsKit_2/PNG/Default size/towerDefense_tile291.png");
        return bossEnemy;
    }






}
