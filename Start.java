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

        Game newGame = new Game(kolKosti,kolPayer,countMaxVictory);
        newGame.start();
    }


 }

