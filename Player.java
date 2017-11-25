package Kosti;

public class Player implements Comparable<Player>{
    private String name;
    private int kolVictory;
    private int setSum;

    public int getSetSum() {
        return setSum;
    }

    public void setSetSum(int setSum) {
        this.setSum = setSum;
    }

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKolVictory() {
        return kolVictory;
    }

    public void setKolVictory() {
        this.kolVictory ++;
    }

    @Override
    public int compareTo(Player o) {
        Player pl = (Player) o;
        if (this.getSetSum() < pl.getSetSum()){
            return 1;
        }
        if (this.getSetSum() == pl.getSetSum()){
            return 0;
        }

        return -1;
    }
}
