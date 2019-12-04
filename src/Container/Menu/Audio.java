package Container.Menu;

import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.io.File;

public abstract class Audio {
    public static void PlayBackgroundMusic(Pane group){
        File m = new File("src/sounds/8_music.mp3");
        MediaPlayer music = new MediaPlayer(new Media(m.toURI().toString()));
        music.setVolume(0.2);
        music.setAutoPlay(true);
        MediaView mediaView=new MediaView(music);
        group.getChildren().add(mediaView);
    }

    public static void PlayBuildTowerAudio(){
        String filepath = "src/sounds/3_turretbuild.mp3";
        Media media = new Media(new File(filepath).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }
}
