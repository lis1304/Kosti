package Kosti;

public class Kubik {
    private static int count;

    public Kubik(int count) {
        this.count = count;
    }

    public static int brokenKosti(){
        int beg = 1, end = 6, randNum=0;
        for (int i = 0; i < count; i++) {
            randNum += beg + (int) (Math.random()*end);
        }

        return randNum;
    }
}
