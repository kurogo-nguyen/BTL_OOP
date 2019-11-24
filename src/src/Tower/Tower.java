package src.Tower;

import src.GameObj;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class Tower extends GameObj {
    int rateOfFire;
    int damage;
    int shootingRange;
    Image gunImg;

    public void render(GraphicsContext gc) {
        gc.drawImage(img, x, y);
        gc.drawImage(gunImg, x, y);
    }
    public abstract void update();
}

