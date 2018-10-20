import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ScoreKaart {

    String[] arrayOnes = {"    Ones     ]", "  "};
    String[] arrayTwos = {"    Twos     ]", "  "};
    String[] arrayThrees = {"    Threes   ]", "  "};
    String[] arrayFours = {"    Fours    ]", "  "};
    String[] arrayFives = {"    Fives    ]", "  "};
    String[] arraySixes = {"    Sixes    ]", "  "};
    String[] arrayTotalScoreUp = {" Total Score ]", "  "};
    String[] arrayBonus = {"    Bonus    ]", "  "};
    String[] arrayTotalUpper = {" Total Upper ]", "  "};
    String[][] arrayUpperSection = {arrayOnes, arrayTwos, arrayThrees, arrayFours, arrayFives, arraySixes, arrayTotalScoreUp, arrayBonus, arrayTotalUpper};
    String[] array3oaK = {" 3 of a Kind ]", "  "};
    String[] array4oaK = {" 4 of a Kind ]", "  "};
    String[] arrayFullHouse = {" Full House  ]", "  "};
    String[] arraySmStraight = {" Sm Straight ]", "  "};
    String[] arrayLgStraight = {" Lg Straight ]", "  "};
    String[] arrayYahtzee = {"   Yahtzee   ]", "  "};
    String[] arrayChance = {"   Chance    ]", "  "};
    String[] arrayYahtzeeBonus = {"Yahtzee Bonus]", "  "};
    String[] arrayTotalLower = {" Total Lower ]", "  "};
    String[] arrayGrandTotal = {" Grand Total ]", "  "};
    String[][] arrayLowerSection = {array3oaK, array4oaK, arrayFullHouse, arraySmStraight, arrayLgStraight, arrayYahtzee, arrayChance, arrayYahtzeeBonus, arrayTotalUpper, arrayTotalLower, arrayGrandTotal};

    int ones;
    int twos;
    int threes;
    int fours;
    int fives;
    int sixes;
    int totalscore = ones + twos + threes + fours + fives + sixes;
    int bonus;
    int totalUpper = totalscore + bonus;
    int[] convertUpperSection = {ones, twos, threes, fours, fives, sixes, totalscore, bonus, totalUpper};
    int toaK;
    int foaK;
    int fullHouse;
    int smStraight;
    int lgStraight;
    int yahtzee;
    int chance;
    int yahtzeeBonus;
    int totalLower = toaK + foaK + fullHouse + smStraight + lgStraight + yahtzee + chance + yahtzeeBonus;
    int grandTotal = totalUpper + totalLower;
    int[] convertLowerSection = {toaK, foaK, fullHouse, smStraight, lgStraight, yahtzee, chance, yahtzeeBonus, totalUpper, totalLower, grandTotal};

    int[][] huidigeRondeSorted = new int[6][1];

    boolean onesFilled=false;
    boolean twosFilled=false;
    boolean threesFilled=false;
    boolean foursFilled=false;
    boolean fivesFilled=false;
    boolean sixesFilled=false;
    boolean tripsFilled=false;
    boolean quadsFilled=false;
    boolean fullHouseFilled=false;
    boolean smStraightFilled=false;
    boolean lgStraightFilled=false;
    boolean yahtzeeFilled=false;
    boolean chanceFilled=false;

    int yahtzeeCounter;
    boolean yahtzeeShutdown=false;

    boolean containsOnes=false;
    boolean containsTwos=false;
    boolean containsThrees=false;
    boolean containsFours=false;
    boolean containsFives=false;
    boolean containsSixes=false;
    boolean isTrips = false;
    boolean isQuads = false;
    boolean isFullHouse = false;
    boolean isSmSt = false;
    boolean isLgSt = false;
    boolean isYahtzee = false;

    void penaltyToewijzen() {
        ArrayList<Boolean> vakjesVinder = new ArrayList<>();
        ArrayList<Boolean> vakjesVinder2 = new ArrayList<>();
        ArrayList<Integer> vakjesBoven = new ArrayList<>();
        ArrayList<Integer> vakjesOnder = new ArrayList<>();

        Collections.addAll(vakjesVinder, onesFilled, twosFilled, threesFilled, foursFilled, fivesFilled, sixesFilled);
        Collections.addAll(vakjesVinder2, tripsFilled, quadsFilled, fullHouseFilled, smStraightFilled, lgStraightFilled, yahtzeeFilled, chanceFilled);
        for (int x=0 ; x<vakjesVinder.size();x++) {
            if (!vakjesVinder.get(x)) {
                vakjesBoven.add(x);
            }
        }
        for (int y=0 ; y<vakjesVinder2.size();y++) {
            if (!vakjesVinder2.get(y)) {
                vakjesOnder.add(y);
            }
        }
        System.out.println();
        System.out.print("Je dient één van de volgende combinaties te schrappen. ");
        System.out.println("Toets: ");
        for (int x : vakjesBoven){
            if (x==0){
                System.out.print("'1' voor Ones, ");
            }
            if (x==1) {
                System.out.print("'2' voor Twos, ");
            }
            if (x==2) {
                System.out.print("'3' voor Threes, ");
            }
            if (x==3) {
                System.out.print("'4' voor Fours, ");
            }
            if (x==4) {
                System.out.print("'5' voor Fives, ");
            }
            if (x==5) {
                System.out.print("'6' voor Sixes, ");
            }
        }
        for (int x : vakjesOnder){
            if (x==0){
                System.out.print("'t' voor 3 of a Kind, ");
            }
            if (x==1){
                System.out.print("'q' voor Four of a Kind, ");
            }
            if (x==2){
                System.out.print("'f' voor Fullhouse, ");
            }
            if (x==3){
                System.out.print("'s' voor Sm Straight, ");
            }
            if (x==4){
                System.out.print("'l' voor Lg Straight, ");
            }
            if (x==5){
                System.out.print("'y' voor Yahtzee, ");
            }
            if (x==6){
                System.out.print("'c' voor Chance, ");
            }
        }
        System.out.println();
        System.out.println();

        Scanner inp = new Scanner(System.in);
        char deleter = inp.nextLine().charAt(0);

        if (deleter=='1' && !onesFilled){
            onesFilled=true;
        } else if (deleter=='2' && !twosFilled){
            twosFilled=true;
        } else if (deleter=='3' && !threesFilled){
            threesFilled=true;
        } else if (deleter=='4' && !foursFilled){
            foursFilled=true;
        } else if (deleter=='5' && !fivesFilled){
            fivesFilled=true;
        } else if (deleter=='6' && !sixesFilled){
            sixesFilled=true;
        } else if (deleter=='t' && !tripsFilled){
            tripsFilled=true;
        } else if (deleter=='q' && !quadsFilled){
            quadsFilled=true;
        } else if (deleter=='f' && !fullHouseFilled){
            fullHouseFilled=true;
        } else if (deleter=='s' && !smStraightFilled){
            smStraightFilled=true;
        } else if (deleter=='l' && !lgStraightFilled){
            lgStraightFilled=true;
        } else if (deleter=='y' && !yahtzeeFilled){
            yahtzeeFilled=true;
            yahtzeeShutdown=true;
        } else if (deleter=='c' && !chanceFilled){
            chanceFilled=true;
        }

    }


    boolean scoringAvailable(){
        ArrayList<Boolean> waardeChecker = new ArrayList<Boolean>();
        Collections.addAll(waardeChecker, containsOnes, containsTwos, containsThrees, containsFours, containsFives, containsSixes, isYahtzee, isFullHouse, isQuads, isTrips, isSmSt, isLgSt, !chanceFilled);
        return waardeChecker.contains(true);
    }

    void turnOffContentChecks() {
        containsOnes = false;
        containsTwos = false;
        containsThrees = false;
        containsFours = false;
        containsFives = false;
        containsSixes = false;
        isTrips = false;
        isQuads = false;
        isFullHouse = false;
        isSmSt = false;
        isLgSt = false;
        isYahtzee = false;
    }

    void tonenScoreKaart() {

        System.out.println("=Upper Section====");
        for (String[] x : arrayUpperSection) {
            System.out.println(Arrays.toString(x).replace("],", "]["));
        }
        System.out.println("=Lower Section====");
        for (String[] y : arrayLowerSection) {
            System.out.println(Arrays.toString(y).replace("],", "]["));
        }
    }

    void alleKaartenTonen(ArrayList<Speler> players){
        System.out.println();
        for (Speler sp: players) {
            System.out.print(sp.naam + " scorekaart");
            System.out.print("  ");
        }
        System.out.println();

        for (Speler sp: players) {
            System.out.print("=Upper Section====");
            System.out.print("   ");
        }
        System.out.println();

        for (String[] x : arrayUpperSection) {
            for (Speler sp: players) {
                System.out.print(Arrays.toString(x).replace("],", "]["));
                System.out.print("  ");
            }
            System.out.println();
        }
        for (Speler sp: players) {
            System.out.print("=Lower Section====");
            System.out.print("   ");
        }
        System.out.println();

        for (String[] y : arrayLowerSection) {
            for (Speler sp : players) {
                System.out.print(Arrays.toString(y).replace("],", "]["));
                System.out.print("  ");
            }
            System.out.println();
        }
    }

    void transcribeScore() {
        ArrayList<Boolean> vakjesVinder = new ArrayList<>();
        ArrayList<Boolean> vakjesVinder2 = new ArrayList<>();
        Collections.addAll(vakjesVinder, onesFilled, twosFilled, threesFilled, foursFilled, fivesFilled, sixesFilled);
        Collections.addAll(vakjesVinder2, tripsFilled, quadsFilled, fullHouseFilled, smStraightFilled, lgStraightFilled, yahtzeeFilled, chanceFilled);

        int counter = 0;
        for (int conval : this.convertUpperSection) {
            if (conval>0) {
                arrayUpperSection[counter][1] = String.valueOf(conval);
            } else if (counter <6  && conval==0 && vakjesVinder.get(counter)){
                arrayUpperSection[counter][1] = "0";
            } else {
                arrayUpperSection[counter][1] = " ";
            }
            counter++;
        }
        counter = 0;
        for (int conval : this.convertLowerSection) {
            if (conval>0) {
                arrayLowerSection[counter][1] = String.valueOf(conval);
            } else if (counter < 7 && conval==0 && vakjesVinder2.get(counter)) {
                arrayLowerSection[counter][1] = "0";
            } else {
                arrayLowerSection[counter][1] = " ";
            }
            counter++;
        }
    }
}
