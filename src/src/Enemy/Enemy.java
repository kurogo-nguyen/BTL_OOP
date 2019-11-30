package src.Enemy;


import javafx.scene.canvas.GraphicsContext;
import src.Field.GameField;
import src.Field.Point;
import src.GameObj;


public abstract class Enemy extends GameObj {
    double speed;
    Direction direction;
    int health;
    int armor;
    double reward;
    int wayPointIndex = 0;
    public Point getNextWayPoint() {
        if (wayPointIndex < GameField.wayPoints.length - 1)
            return GameField.wayPoints[++wayPointIndex];
        return null;
    }
    public void calculateDirection() {
        // Tinh huong di tiep theo cho Object
        if (wayPointIndex >= GameField.wayPoints.length) {
            // Enemy den way point cuoi
            return;
        }

        Point currentWP = GameField.wayPoints[wayPointIndex];
        if (GameField.distance(x, y, currentWP.x, currentWP.y) <= speed) {
            x = currentWP.x;
            y = currentWP.y;
            Point nextWayPoint = getNextWayPoint();
            if (nextWayPoint == null) return;
            double deltaX = nextWayPoint.x - x;
            double deltaY = nextWayPoint.y - y;
            if (deltaX > speed) direction = Direction.RIGHT;
            else if (deltaX < -speed) direction = Direction.LEFT;
            else if (deltaY > speed) direction = Direction.DOWN;
            else if (deltaY <= -speed) direction = Direction.UP;
        }

    }
    public abstract void render(GraphicsContext gc);
    public void update(){

        calculateDirection();

        switch (direction) {
            case UP:
                y -= speed;
                break;
            case DOWN:
                y += speed;
                break;
            case LEFT:
                x -= speed;
                break;
            case RIGHT:
                x += speed;
                break;
        }
    }

}
enum Direction {
    LEFT(180), UP(270), RIGHT(0), DOWN(90), LCross(135);

    int degree;

    Direction(int i) {
        degree = i;
    }

    int getDegree() {
        return degree;
    }
}
