package Container.SettingStartGame;
import Container.Field.*;
import Container.Main;
import Container.Tower.NormalTower;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class SettingStart extends Parent {
    double orgSceneX, orgSceneY;
    double orgTranslateX, orgTranslateY;
    public static int selectTower ;
    public SettingStart(){
        GameField.unfeasablePoints();
        //for(Point a : firstOfGame.unfeasablePlacement) System.out.println(a);
        VBox r1 = new VBox(10);
        VBox r2 = new VBox(10);
        r1.setTranslateX(18 * 64 + 10);
        r1.setTranslateY(50);
        r2.setTranslateX(18 * 64 + 10 + 70 + 10);
        r2.setTranslateY(50);
        SettingItem cannon1 = new SettingItem("file:src/AssetsKit_2/PNG/Default size/towerDefense_tile180.png" , "file:src/AssetsKit_2/PNG/Default size/towerDefense_tile249.png");
        SettingItem cannon2 = new SettingItem("file:src/AssetsKit_2/PNG/Default size/towerDefense_tile182.png" , "file:src/AssetsKit_2/PNG/Default size/towerDefense_tile205.png");
        SettingItem cannon3 = new SettingItem("file:src/AssetsKit_2/PNG/Default size/towerDefense_tile181.png" , "file:src/AssetsKit_2/PNG/Default size/towerDefense_tile206.png");
        SettingItem cannon4 = new SettingItem("file:src/AssetsKit_2/PNG/Default size/towerDefense_tile182.png" , "file:src/AssetsKit_2/PNG/Default size/towerDefense_tile250.png");
        SettingItem cannon5 = new SettingItem("file:src/AssetsKit_2/PNG/Default size/towerDefense_tile183.png" , "file:src/AssetsKit_2/PNG/Default size/towerDefense_tile204.png");
        SettingItem cannon6 = new SettingItem("file:src/AssetsKit_2/PNG/Default size/towerDefense_tile182.png" , "file:src/AssetsKit_2/PNG/Default size/towerDefense_tile203.png");
        r1.getChildren().addAll(cannon1 ,cannon2 ,cannon3);
        r2.getChildren().addAll(cannon4 ,cannon5 ,cannon6);

        //System.out.println(cannon1.localToScene(cannon1.getBoundsInLocal()));
        Rectangle rc = new Rectangle(18 * 64 , 0 , 250 , 12 * 64);
        rc.setFill(Color.GREY);
        rc.setOpacity(0.2);
        getChildren().addAll(rc , r1 , r2 );
        cannon1.setOnMousePressed(e ->{
            selectTower = 1;
        });
        cannon2.setOnMousePressed(e ->{
            selectTower = 2;
        });
        cannon3.setOnMousePressed(e ->{
            selectTower = 3;
        });
        cannon4.setOnMousePressed(e ->{
            selectTower = 4;
        });
        cannon5.setOnMousePressed(e ->{
            selectTower = 5;
        });
        cannon6.setOnMousePressed(e ->{
            selectTower = 6;
        });
        handleSettingItem(cannon1);
        handleSettingItem(cannon2);
        handleSettingItem(cannon3);
        handleSettingItem(cannon4);
        handleSettingItem(cannon5);
        handleSettingItem(cannon6);

    }
    public void handleSettingItem(SettingItem cannon){
        cannon.setOnMouseClicked(e -> {
            orgSceneX = e.getSceneX();
            orgSceneY = e.getSceneY();
            orgTranslateX = ((SettingItem) (e.getSource())).getTranslateX();
            orgTranslateY = ((SettingItem) (e.getSource())).getTranslateY();

            SettingItem cnClone = new SettingItem();
            cnClone.getChildren().addAll(new ImageView(cannon.bImg), new ImageView(cannon.gImg));
            cnClone.setLayoutX(cannon.localToScene(cannon.getBoundsInLocal()).getMinX() + 0.5);
            cnClone.setLayoutY(cannon.localToScene(cannon.getBoundsInLocal()).getMinY() + 0.5);

            Main.scene.setOnMouseMoved(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    //System.out.println(mouseEvent.getSceneX() + " " + mouseEvent.getSceneY());
                    cnClone.setOnMouseMoved(cannonOnMouseMovedEventHandler);
                    cnClone.setOnMousePressed(e -> {
                        if (e.getButton() == MouseButton.PRIMARY) {
                            int x = (int) (mouseEvent.getSceneX() / 64) * 64;
                            int y = (int) (mouseEvent.getSceneY() / 64) * 64;
                            if (canPlace(new Point(x, y))) {
                                switch(selectTower){
                                    case 1:
                                        GameField.gameObjects.add(NormalTower.createNormalTower(x, y));
                                        break;
                                }

                                GameField.unfeasablePlacement.add(new Point(x, y));
                            }
                        }
                        if (e.getButton() == MouseButton.SECONDARY) {
                            getChildren().remove(getChildren().size() - 1);
                        }
                    });

                }
            });
            //cnClone.setOnMouseDragged(cannonOnMouseDraggedEventHandler);
            getChildren().add(cnClone);
        });
    }
    EventHandler<MouseEvent> cannonOnMouseMovedEventHandler =

            new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent t) {

                    double offsetX = t.getSceneX() - orgSceneX;
                    double offsetY = t.getSceneY() - orgSceneY;
                    double newTranslateX = orgTranslateX + offsetX;
                    double newTranslateY = orgTranslateY + offsetY;
                    ((SettingItem)(t.getSource())).setTranslateX(newTranslateX);
                    ((SettingItem)(t.getSource())).setTranslateY(newTranslateY);
                }
            };

    /*EventHandler<MouseEvent> cannonOnMouseDraggedEventHandler =
            new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent t) {
                    double offsetX = t.getSceneX() - orgSceneX;
                    double offsetY = t.getSceneY() - orgSceneY;
                    double newTranslateX = orgTranslateX + offsetX;
                    double newTranslateY = orgTranslateY + offsetY;
                    ((SettingItem)(t.getSource())).setTranslateX(newTranslateX);
                    ((SettingItem)(t.getSource())).setTranslateY(newTranslateY);

                }
            };*/
    public boolean canPlace(Point point){
        //System.out.println(point);
        if(GameField.unfeasablePlacement.contains(point)) return false;
        return true;
    }
}
