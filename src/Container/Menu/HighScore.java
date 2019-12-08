package Container.Menu;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HighScore {
    protected String name;
    protected int score;

    static List<HighScore> highScores = new ArrayList<>();

    public static List<HighScore> getHighScores() {
        return highScores;
    }

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

    public static void setHighScores(){
        highScores=new ArrayList<>();
        FileReader fr= null;   //reads the file
        try {
            fr = new FileReader(new File("resource/HighScore.txt"));
            BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream
            String line;
            while((line=br.readLine())!=null)
            {
                HighScore a= new HighScore(line, Integer.parseInt(br.readLine()));
                highScores.add(a);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public int getScore() {
        return score;
    }

    public static void add(String name, int _score) throws IOException {
        highScores.add((new HighScore(name, _score)));
        highScores.sort(Comparator.comparing(HighScore::getScore));
        writeHighScore();
    }

    static void writeHighScore() throws IOException {
        StringBuilder s= new StringBuilder("");
        for (int i = 1; i < highScores.size(); i++) {
            s.insert(0, highScores.get(i).getName() + "\n" + highScores.get(i).getScore() + "\n");
        }
        System.out.println(s);
        FileOutputStream fileOutputStream =new FileOutputStream(new File("resource/HighScore.txt"));
        fileOutputStream.write(s.toString().getBytes());
    }
    public String getName() {
        return name;
    }
}
