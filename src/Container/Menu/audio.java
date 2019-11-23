package Container.Menu;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class audio {
    int volume;
    void setVolume(){

    }
    public static void buildAudio(){
        String a = "src/AssetsKit_1/sounds/3_turretbuild.mp3";
        Media music = new Media(new File(a).toURI().toString());
        MediaPlayer m = new MediaPlayer(music);
        m.setAutoPlay(false);
        m.play();
    }
}
