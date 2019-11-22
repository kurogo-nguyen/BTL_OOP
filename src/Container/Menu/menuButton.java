package Container.Menu;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class menuButton extends Button {

    public menuButton(String name) {
        super(name);
        setPrefSize(250,40);
        setStyle("-fx-font: 25 arial; -fx-base: #94f4f7;");
    }
}
