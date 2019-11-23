package Container.Tower;


import Container.GameObj;
import javafx.scene.canvas.GraphicsContext;

public abstract class Bullet extends GameObj {
    int rateOfFire;
    int damage;
    int shootingRange;
    enum bullet{
        normalBullet(),
    }
    //public abstract void render(GraphicsContext gc);
    //public abstract void update();
}
