package Kosti;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Start {

    static Player[] masPl;
    static int kolPayer = 0;
    static int kolKosti = 0;
    static int countMaxVictory = 7;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Введите количество игроков: ");
            kolPayer = Integer.parseInt(br.readLine());

            System.out.print("Введите количество кубиков: ");
            kolKosti = Integer.parseInt(br.readLine());
        } catch (Exception e) {
            System.out.println("необходимо вводить числа");
        }

        masPl = new Player[kolPayer];
        //создаем игроков
        for (int i = 0; i < kolPayer; i++) {
            masPl[i] = new Player("Player" + (i + 1));
        }

        int i=0;
        while (true){

            System.out.println("set # "+(++i));
            for (Player pp : masPl) {
                pp.setSetSum(brokenKosti());
                System.out.println("Игрок "+pp.getName() + " бросил на " + pp.getSetSum() + " очка(ков)");
            }

            findVictSet();
            maxVict();

            System.exit(1);
        }
    }



        public static int brokenKosti(){
            int beg = 1, end = 6, randNum=0;
            for (int i = 0; i < kolKosti; i++) {
                randNum += beg + (int) (Math.random()*end);
            }

           return randNum;
        }

        public static void maxVict(){
            int max = masPl[0].getKolVictory();
            for (Player pp : masPl) {
                if (pp.getKolVictory() == countMaxVictory){
                    System.out.println("Игра окончена, победил " + pp.getName());
                    System.exit(1);
                }
            }
            return max;

        }
        public static void findVictSet(){
            int max = masPl[0].getSetSum();
            for (Player pp : masPl) {
                if (pp.getSetSum() > max){
                    max = pp.getSetSum();
                }
            }
            for (Player pp : masPl){
                if (pp.getSetSum() == max){
                    pp.setKolVictory();
                    System.out.println("В текущем раунде победил "+pp.getName());
                }
            }
        }




}
