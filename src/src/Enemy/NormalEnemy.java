package src.Enemy;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class NormalEnemy extends Enemy{


   public void render(GraphicsContext gc){
       SnapshotParameters params = new SnapshotParameters();
       params.setFill(Color.TRANSPARENT);

       ImageView iv = new ImageView(img);
       iv.setRotate(this.direction.getDegree());
       Image base = iv.snapshot(params, null);

       gc.drawImage(base, x, y);
   }

   public static NormalEnemy createSoldier(int x){
       NormalEnemy normalEnemy = new NormalEnemy();
       normalEnemy.i = 14;
       normalEnemy.j = 1;
       normalEnemy.direction = Direction.DOWN;
       normalEnemy.speed = 10;
       normalEnemy.x = 64* normalEnemy.i +32;
       normalEnemy.y = 64* normalEnemy.j -x;
       normalEnemy.img = new Image("file:src/AssetsKit_2/PNG/Default size/towerDefense_tile245.png");
       normalEnemy.health = 100;
       normalEnemy.armor = 1;

       return normalEnemy;
   }

//    public static ArrayList<NormalEnemy> listSoldiers(){
//       ArrayList<NormalEnemy> normalEnemies = new ArrayList<>();
//
//    }

}


