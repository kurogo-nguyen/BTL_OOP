package Container.Tower;

import Container.Enemy.Enemy;
import Container.Field.GameField;
import Container.GameObj;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.SnapshotParameters;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public abstract class Tower extends GameObj {
    public static List<Tower> towers = new ArrayList<>();
    protected int damage;
    boolean check = true;
    protected Bullet b = new Bullet();
    protected Image gunImg;
    protected Enemy target;
    protected double shootingRange;
    protected int selling ;


    protected int rateOfFire=10;
    public static GraphicsContext gc;
    public int cost;
    Tower towerUpgrade;

    boolean withinFiringRange = false;

    public void render(GraphicsContext gc) {
//        SnapshotParameters params = new SnapshotParameters();
//        params.setFill(Color.TRANSPARENT);
//
//        ImageView iv = new ImageView(gunImg);
//        iv.setRotate(this.rotation);
//        Image gun = iv.snapshot(params, null);
//        gc.drawImage(img, x, y);
//        gc.drawImage(gun, x, y);

        gc.drawImage(img, x, y);
        gc.save();
        gc.translate(x+32, y+32);
        gc.rotate(rotation);
        gc.translate(-x-32,-y-32);
        gc.drawImage(gunImg, x, y);
        gc.restore();
//        if(renderFireRange) {
//            gc.setStroke(Color.RED);
//            gc.strokeOval(x - targetRange + 32, y - targetRange + 32, targetRange * 2, targetRange * 2);
//        }
    }
    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public void setAngle() {
//        Tower follower = this;
        withinFiringRange = false;
        if( target != null)
        {
//            double dx = target.getCenterX() - follower.getCenterX();
//            double dy = target.getCenterY() - follower.getCenterY();
//            double angleToTarget = Math.atan2(dy, dx) + Math.PI / 2;
//            targetAngle = Math.toDegrees( angleToTarget);
//            currentAngle = follower.rotation;
//            if( Math.abs(currentAngle) > 360) {
//                if( currentAngle < 0) {
//                    currentAngle = currentAngle % 360 + 360;
//                } else {
//                    currentAngle = currentAngle % 360;
//                }
//            }
//
//            double dr = targetAngle - currentAngle;
//
//            if( Math.abs( dr) < 180) {
//
//            } else {
//                if( dr > 0) {
//                    targetAngle -= 360;
//                } else {
//                    targetAngle += 360;
//                }
//            }
//            dr = targetAngle - currentAngle;
//            currentAngle = currentAngle + dr / rotationSpeed;
//            follower.rotation = currentAngle;
//            withinFiringRange = Math.abs( this.targetAngle-this.currentAngle) < 20;
            double angle = Math.toDegrees(Math.atan((target.y - y) / (target.x - x)));
            if (target.x >= x) {
                rotation = 90 + angle;
            } else {
                rotation = angle + 270;
            }
            withinFiringRange=true;
        }else
            return;
    }
    public void checkTarget() {
        if( target == null) {
            return;
        }

        if( !target.isAlive() ) {
            setTarget( null);
            return;
        }

        if(!isInRange(target.getX(), target.getY())) {
            setTarget(null);
        }
    }
    boolean isInRange(double enemyX, double enemyY){
        if(GameField.distance(x, y, enemyX, enemyY)<=shootingRange)
            return true;
        else
            return false;
    }
    public void findTarget( List<Enemy> targetList) {
        if( getTarget() != null) {
            return;
        }

        for (int k = 0; k < Enemy.enemies.size() ; k++) {
            if (!Enemy.enemies.get(k).isAlive())
                continue;
            if(isInRange(Enemy.enemies.get(k).x, Enemy.enemies.get(k).y)){
                setTarget(Enemy.enemies.get(k));
                return;
            }
        }
    }

    public Enemy getTarget() {
        return target;
    }

    public void setTarget(Enemy target) {
        this.target = target;
    }

    public boolean hitsTarget(Enemy enemy){
        return target == enemy && withinFiringRange;
    }
//    public boolean shootTarget(Enemy enemy) {
//
//        if(target == enemy && withinFiringRange){
//            if(check) {
//                Bullet bullet = creatBullet(this.x , this.y , this.rotation);
//                b = bullet;
//                //GameField.bullets.add(bullet);
//                check=false;
//            }
//            else if(b.collidesWith(enemy)){
//                Bullet.bullets.remove(b);
//                Bullet other = creatBullet(this.x , this.y , this.rotation);
//                //GameField.bullets.add(other);
//                b = other ;
//                return true;
//            }else if(GameField.distance(b.x , b.y , this.x , this.y) > shootingRange){
//                Bullet.bullets.remove(b);
//                check=true;
//            }
//        }
//        return false;
//    }
    public Bullet creatBullet(double x , double y , double rotation){
        Bullet bullet = new Bullet(x , y , rotation);
        Bullet.bullets.add(bullet);
        return bullet;
    }

    public void update(){
        setAngle();
    }

    public abstract void upgrade();

    public int getSelling() {
        return selling;
    }

    public abstract Image infoImage();

    public Tower getTowerUpgrade() {
        return towerUpgrade;
    }

    public double getShootingRange() {
        return shootingRange;
    }
    void shot(){
        Timeline timeline = new Timeline();
        KeyFrame keyFrame = new KeyFrame(Duration.millis(2000/rateOfFire), event -> {
            if(target!=null){
                Bullet.bullets.add(creatBullet(x, y, rotation));
            }
        });

        timeline.getKeyFrames().add(keyFrame);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
}

