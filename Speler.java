import java.util.ArrayList;

public class Speler {

    ArrayList<Worp> worpGeschiedenis = new ArrayList<Worp>();
    ArrayList<Beurt> beurtGeschiedenis = new ArrayList<Beurt>();
    int beurtCounter=0;
    int worpCount=0;
    int beurtWorpCounter=1;
    boolean noThrowsLeft;
    ScoreKaart scoreCard = new ScoreKaart();

    String naam;

    Speler(int num) {
        naam = "Speler " + num;
    }
}
