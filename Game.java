package Kosti;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

import static Kosti.Start.maxVict;

public class Game {
    private int countKosti;
    private int countPlayer;
    private int countVictory;
    public static Kubik kubik;

    public Game(int countKosti, int countPlayer, int countVictory) {
        this.countKosti = countKosti;
        this.countPlayer = countPlayer;
        this.countVictory = countVictory;
    }

    public void start(){

        //создаем игроков
        Player[] masPl = new Player[this.countPlayer];
        for (int i = 0; i < this.countPlayer; i++) {
            masPl[i] = new Player("Player" + (i + 1));
        }
        kubik = new Kubik(this.countKosti);

        //играем
        int i=0;
        while (true){
            //бросаем кости
            System.out.println("set # "+(++i));
            for (Player pp : masPl) {
                pp.setSetSum(kubik.brokenKosti());
                System.out.println("Игрок "+pp.getName() + " бросил на " + pp.getSetSum() + " очка(ков)");
            }
            //ищем победителя в сете
            findVictSet(masPl);

            //считаем у кого сколько побед
            maxVict(masPl);

        }
    }

    public static int CountVictorySet(Player[] masPl){
        //проверяем сколько победителей в сете
        int maxCount = masPl[0].getSetSum();
        int kol = 0;
        for (Player pp :masPl){
            if (pp.getSetSum() == maxCount){
                kol++;
            }
        }
        return kol;

    }

    public static void perebrosKostey(int kol, Player[] pl){

        Player[] tempPlayer = new Player[kol];
        for (int i = 0; i < kol; i++) {
            tempPlayer[i] = pl[i];
        }
        while (CountVictorySet(tempPlayer)>1){
            for (Player pp : tempPlayer) {
                pp.setSetSum(kubik.brokenKosti());
                System.out.println("Игрок "+pp.getName() + " перебросил на " + pp.getSetSum() + " очка(ков)");
            }
            Arrays.sort(tempPlayer);
        }
        for (int i = 0; i < tempPlayer.length; i++) {
            pl[i] = tempPlayer[i];
        }

    }
    public static void findVictSet(Player[] masPl){
        int kolV=0;
        //сортируем по убыванию очков в данном сете
        Arrays.sort(masPl);

        //проверяем сколько победителей в сете
        kolV = CountVictorySet(masPl);
        if (kolV > 1){
            perebrosKostey(kolV,masPl);
        }
        masPl[0].setKolVictory();
        System.out.println("В текущем раунде победил "+masPl[0].getName() + ", общее кол-во побед " +masPl[0].getKolVictory());

    }
    public static void maxVict(Player[] masPl){
        int max = masPl[0].getKolVictory();
        for (Player pp : masPl) {
            if (pp.getKolVictory() == Start.countMaxVictory){
                System.out.println("Игра окончена, победил " + pp.getName());
                System.exit(1);
            }
        }

    }
}
