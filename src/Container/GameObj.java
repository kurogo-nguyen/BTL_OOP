package Container;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class GameObj{
    public int i ;
    public int j;
    public double x ;
    public double y;
    public Image img;

    public abstract void render(GraphicsContext gc);
    public abstract void update();
}
