package Container.SettingStartGame;

import javafx.scene.Cursor;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.image.ImageView;


public class SettingItem extends StackPane {
    private Text text;
    private Image img;
    protected Image bImg;
    protected Image gImg;

    public SettingItem() {
        setCursor(Cursor.HAND);
    }

    public SettingItem(String base, String gun) {
        setCursor(Cursor.HAND);
        Rectangle rc = new Rectangle(64, 64);
        rc.setOpacity(0.6);
        rc.setStroke(Color.DARKSEAGREEN);
        rc.setFill(Color.WHITESMOKE);
        bImg = new Image(base);
        gImg = new Image(gun);
        ImageView baseImg = new ImageView(bImg);
        ImageView gunImg = new ImageView(gImg);
        //setAlignment(Pos.CENTER);
        getChildren().addAll(rc, baseImg, gunImg);
        setOnMouseClicked(e -> {

        });
    }
}
