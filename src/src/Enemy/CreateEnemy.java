package src.Enemy;

import java.util.ArrayList;
import java.util.Random;

public class CreateEnemy {

    public static ArrayList<Enemy> listEnemies(){
        int indexOfEnemy = 32;
        int i = 0;
        ArrayList<Enemy> enemies = new ArrayList<>();
        Random rd = new Random();
        while(++i<indexOfEnemy){
            switch (rd.nextInt(3)){
                case 0:
                    enemies.add(NormalEnemy.createSoldier(i));
                    break;
                case 1:
                    enemies.add(SmallerEnemy.createSoldier(i,rd.nextInt(4)));
                    break;
                case 2:
                    enemies.add(TankerEnemy.createSoldier(i,rd.nextInt(2)));
            }

        }
        enemies.add(BossEnemy.createSoldier(i+1));
        return enemies;
    }
}
