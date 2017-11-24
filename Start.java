package Kosti;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Start {

    static Player[] masPl;
    static int kolPayer = 0;
    static int kolKosti = 0;

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

        for (int i = 0; i < kolPayer; i++) {
            masPl[i] = new Player("Player" + (i + 1));
        }

        int i=0;
        while (maxVict()<7){
            i++;
            System.out.println("set # "+i);
            for (Player pp : masPl) {
                pp.setSetSum(brokenKosti());
            }
            findVictSet();
        }
    }



        public static int brokenKosti(){
            int beg = 1, end = 6, randNum=0;
            for (int i = 0; i < kolKosti; i++) {
                randNum += beg + (int) (Math.random()*end);
            }

           return randNum;
        }

        public static int maxVict(){
            int max = masPl[0].getKolVictory();
            for (Player pp : masPl) {
                if (pp.getKolVictory() > max){
                    max = pp.getKolVictory();
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
                    pp.setSetSum();
                }
            }
        }




}
