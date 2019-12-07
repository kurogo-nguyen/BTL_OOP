package Container.Menu;

import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.io.File;

public abstract class Audio{
    static double volume=0.2;
    static MediaPlayer music;

    public static void setVolume(double volume) {
        Audio.volume = volume;
        music.setVolume(volume);
    }

    public static void PlayBackgroundMusic(Pane group){
        File m = new File("src/sounds/8_music.mp3");
        music = new MediaPlayer(new Media(m.toURI().toString()));
        music.setVolume(volume);
        music.setAutoPlay(true);
        music.play();
        MediaView mediaView=new MediaView(music);
        group.getChildren().add(mediaView);
    }

    public static MediaView PlayBuildTowerAudio(){
        String filepath = "src/sounds/3_turretbuild.mp3";
        Media media = new Media(new File(filepath).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        MediaView mediaView=new MediaView(mediaPlayer);
        mediaPlayer.play();
        return mediaView;
    }
}
