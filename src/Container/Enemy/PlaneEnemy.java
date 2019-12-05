package Container.Enemy;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class PlaneEnemy extends Enemy {
    public PlaneEnemy() {
        this.reward = 15;
        this.enemyHP = 200;
        this.health = 200;
        this.speed = 3 ;
        this.direction = Direction.DOWN;
    }

    public void render(GraphicsContext gc) {
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);

        ImageView iv = new ImageView(img);
        iv.setRotate(this.direction.getDegree());
        Image base = iv.snapshot(params, null);

        gc.drawImage(base, x, y);

        /*double scale = (double)health / enemyHP;
        gc.setFill(Color.RED);
        gc.fillRect(x + 15 , y + 8, 34 ,7);
        gc.setFill(Color.rgb(27,219,6));
        gc.fillRect(x +15, y + 8 , 34  * scale ,7);*/
        super.render(gc);
    }
    public static PlaneEnemy createPlane(int x , int type){
        PlaneEnemy planeEnemy = new PlaneEnemy();
        planeEnemy.i = 14;
        planeEnemy.j = - 7 ;
        planeEnemy.x = planeEnemy.i * 64 + 32;
        planeEnemy.y = (planeEnemy.j - x) * 64  ;
        switch (type){
            case 0 :
                planeEnemy.img = new Image("file:src/AssetsKit_2/PNG/Default size/towerDefense_tile270.png");
                break;
            case 1:
                planeEnemy.img = new Image("file:src/AssetsKit_2/PNG/Default size/towerDefense_tile271.png");
        }
        return planeEnemy;
    }
    public static ArrayList<PlaneEnemy> listPlanes(){
        ArrayList<PlaneEnemy> planeEnemies = new ArrayList<>();
        for(int i = 0 ; i < 2 ; i++){
            planeEnemies.add(createPlane(i, i % 2));
        }
        return planeEnemies;
    }
}
