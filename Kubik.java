package Kosti;

public class Kubik {
    private int count;
    final int beg = 1;
    final int end = 6;


    public Kubik(int count) {
        this.count = count;
    }

    public int rollDice(){
        int randNum=0;
        for (int i = 0; i < count; i++) {
            randNum += beg + (int) (Math.random()*end);
        }

        return randNum;
    }
}
