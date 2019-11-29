package src.Menu;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.Property;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import src.Main;

public class menuBox {
    public menuBox() {
        Button normalTower = new Button("", new ImageView("file:src/AssetsKit_2/PNG/Default size/NormalTower.png"));
        Button machineGunTower = new Button("", new ImageView("file:src/AssetsKit_2/PNG/Default size/MachineGunTower.png"));
        Button SniperTower = new Button("", new ImageView("file:src/AssetsKit_2/PNG/Default size/SniperTower.png"));
        normalTower.setCursor(Cursor.HAND);
        normalTower.setOnMouseClicked(mouseEvent -> {
            Image image = new Image("file:src/AssetsKit_2/PNG/Default size/NormalTower.png");
            ImageView imageView =new ImageView(image);
//            IntegerProperty a = mouseEvent.
        });
    }
}
