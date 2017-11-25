package Kosti;

import java.util.Arrays;


public class Game {
    private int countKosti;
    private int countPlayer;
    private int countVictory;
    public Kubik kubik;

    public Game(int countKosti, int countPlayer, int countVictory) {
        this.countKosti = countKosti;
        this.countPlayer = countPlayer;
        this.countVictory = countVictory;
    }

    public void start(){

        //создаем игроков
        Player[] players = new Player[this.countPlayer];
        for (int i = 0; i < this.countPlayer; i++) {
            players[i] = new Player("Player" + (i + 1));
        }
        kubik = new Kubik(this.countKosti);

        //играем
        int setNumber=0;
        while (true){
            //бросаем кости
            System.out.println("set # "+(++setNumber));
            for (Player player : players) {
                player.setSetSum(kubik.rollDice());
                System.out.println("Игрок "+player.getName() + " бросил на " + player.getSetSum() + " очка(ков)");
            }
            //ищем победителя в сете
            findVictorySet(players);

            //считаем у кого сколько побед
            maxVict(players,this.countVictory);

        }
    }

    //Для определения количества победителей в текущем сете
    private int CountVictorySet(Player[] players){
        //проверяем сколько победителей в сете
        int maxCount = players[0].getSetSum();
        int kol = 0;
        for (Player pp :players){
            if (pp.getSetSum() == maxCount){
                kol++;
            }
        }
        return kol;

    }

    //Переигровка у игроков выбивших одинаковое максимальное количество очков
    private void perebrosKostey(int kol, Player[] players){

        Player[] tempPlayer = new Player[kol];
        for (int i = 0; i < kol; i++) {
            tempPlayer[i] = players[i];
        }
        while (CountVictorySet(tempPlayer)>1){
            for (Player tPlayer : tempPlayer) {
                tPlayer.setSetSum(kubik.rollDice());
                System.out.println("Игрок "+tPlayer.getName() + " перебросил на " + tPlayer.getSetSum() + " очка(ков)");
            }
            Arrays.sort(tempPlayer);
        }
        for (int i = 0; i < tempPlayer.length; i++) {
            players[i] = tempPlayer[i];
        }

    }

    //Определяем победителя в сете
    private void findVictorySet(Player[] players){
        int kolVictory=0;
        //сортируем по убыванию очков в данном сете
        Arrays.sort(players);

        //проверяем сколько победителей в сете
        kolVictory = CountVictorySet(players);
        if (kolVictory > 1){
            perebrosKostey(kolVictory,players);
        }
        players[0].setKolVictory();
        System.out.println("В текущем раунде победил "+players[0].getName() + ", общее кол-во побед " +players[0].getKolVictory());

    }

    private void maxVict(Player[] players, int maxVictory){
        int max = players[0].getKolVictory();
        for (Player player: players) {
            if (player.getKolVictory() == maxVictory){
                System.out.println("Игра окончена, победил " + player.getName());
                System.exit(1);
            }
        }

    }
}
