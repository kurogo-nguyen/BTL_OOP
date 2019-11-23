package Container.Menu;

import javafx.scene.control.Button;


public class menuButton extends Button {

    public menuButton(String name) {
        super(name);
        setPrefSize(250,40);
        setStyle("-fx-font: 25 arial; -fx-base: #94f4f7;");
    }
}
