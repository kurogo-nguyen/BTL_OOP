package Container.Menu;

import javafx.scene.text.Text;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HighScore {
    String name;
    int score;
    List<HighScore> list = new ArrayList<>();

    public HighScore(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public static String ReadHighScore(){
        StringBuilder a = new StringBuilder();
        //            File file = new File("resource/HighScore.txt");
        try {
//                FileOutputStream fileOutputStream =new FileOutputStream(file);
//                String b="Huy          1000\n" +
//                         "Duc Anh       500";
//                fileOutputStream.write(b.getBytes());
            FileInputStream fileInputStream = new FileInputStream("resource/HighScore.txt");

            int charIndex = fileInputStream.read();
            while (charIndex!=-1){
                a.append((char) charIndex);
                charIndex=fileInputStream.read();
            }
            fileInputStream.close();
            System.out.println(a);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return a.toString();
    }

    void creatListHighScore() throws IOException {
        FileReader fr=new FileReader(new File("resource/HighScore.txt"));   //reads the file
        BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream
        StringBuffer sb=new StringBuffer();    //constructs a string buffer with no characters
        String line;
        while((line=br.readLine())!=null)
        {
            list.add(new HighScore(line, Integer.parseInt(br.readLine())));
        }
    }

    void add(){

    }
}
