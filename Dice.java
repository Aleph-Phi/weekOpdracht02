import java.util.Random;

public class Dice {

    int faceUp;
    boolean holdDice;

    String naam;

    int werpen() {
        Random dieFace = new Random();
        return (dieFace.nextInt(6) + 1);
    }
    Dice() {
    }
    Dice(int nummer) {
        naam = "d" + nummer;
    }
}

