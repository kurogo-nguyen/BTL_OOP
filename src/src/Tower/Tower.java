package src.Tower;

import javafx.scene.SnapshotParameters;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Rotate;
import src.Field.GameField;
import src.GameObj;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class Tower extends GameObj {
    int rateOfFire;
    int damage;
    int shootingRange = 64*3;
    Image gunImg;
    double Degree;
    int target=-1;

    public void render(GraphicsContext gc) {
        gc.drawImage(img, x, y);
        rotateGun(gc);
    }

    void rotateGun(GraphicsContext gc){
        findTarget();
        if(hasTarget()) {
            gc.save();
            calculateDegree();
            gc.translate(x+32, y+32);
            gc.rotate(Degree);
            gc.translate(-x-32,-y-32);
            gc.drawImage(gunImg, x, y);
            gc.restore();
//            shot();
        } else
            gc.drawImage(gunImg, x, y);
    }
    void calculateDegree(){
        double angle =Math.toDegrees(Math.atan((GameField.enemies.get(target).y - y)/(GameField.enemies.get(target).x-x)));
        if(GameField.enemies.get(target).x>=x){
                Degree=90+angle;
        }else {
                Degree = angle + 270;
        }
    }
    boolean isInRange(double enemyX, double enemyY){
        if(GameField.distance(x, y, enemyX, enemyY)<=shootingRange)
            return true;
        else
            return false;
    }
    void shot(){
        Bullet bullet= new Bullet(x, y);
        GameField.gameObjects.add(bullet);
//        bullet.speedX= (int) ((GameField.enemies.get(target).x-x)/5);
//        bullet.speedY= (int) ((GameField.enemies.get(target).y-y)/5);
    }

    void findTarget(){
        for (int k = 0; k <GameField.enemies.size() ; k++) {
            if(isInRange(GameField.enemies.get(k).x, GameField.enemies.get(k).y)){
                target=k;
                return;
            }
        }
        target=-1;
    }

    boolean hasTarget(){
        if(target!=-1)
            return true;
        else
            return false;
    }

    public void update() {
//        findTarget();
//        if(hasTarget())
//            shot();
    }
}

