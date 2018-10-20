import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class YahtzeeSpel {

    ArrayList<Dice> Dobbelstenen = new ArrayList<Dice>();
    ArrayList<Speler> Spelers = new ArrayList<Speler>();
    int[] blokkeerarray = {0,0,0,0,0};
    int playersAmount;

    YahtzeeSpel() {
        System.out.println();
        System.out.println("Welkom bij Yahtzee!");
        System.out.println();
        for (int i = 1; i < 6; i++) {
            Dobbelstenen.add(new Dice(i));
        }
        Scanner readInt = new Scanner(System.in);
        System.out.println("Met hoeveel mensen wil je Yahtzee spelen, voer een getal tussen 1 en 4 in.");
        int aantalSpelers = readInt.nextInt();
        if (aantalSpelers > 0 && aantalSpelers < 5) {
            for (int n = 1; n <= aantalSpelers; n++) {
                Spelers.add(new Speler(n));
                playersAmount = aantalSpelers;
            }
        } else {
            while (aantalSpelers < 1 || aantalSpelers > 4) {
                System.out.println("Helaas dat is geen geldige invoer");
                System.out.println();
                System.out.println("Probeer het nogmaals \nMet hoeveel mensen wil je Yahtzee spelen, voer een getal tussen 1 en 4 in, of voer 0 in om te stoppen met het spel");
                int aantalSPReTry = readInt.nextInt();
                if (aantalSPReTry > 0 && aantalSPReTry < 5) {
                    for (int n = 1; n <= aantalSPReTry; n++) {
                        Spelers.add(new Speler(n));
                        playersAmount = aantalSpelers;
                    }
                    aantalSpelers = aantalSPReTry;
                } else if (aantalSPReTry == 0) {
                    System.exit(0);
                }
            }
        }
    }


    public void spelen(){
       while (Spelers.get(playersAmount-1).beurtCounter<13){
           for (Speler player : Spelers) {
               beurtSpelen(player);

           }
       }
        winnaarBepalen();
    }

    void winnaarBepalen(){
        int highScore=0;
        String naam="";
        ArrayList<Speler> Winnaars = new ArrayList<>();

        for (Speler sp: Spelers){
            if (sp.scoreCard.convertLowerSection[10]>highScore){
                highScore=sp.scoreCard.convertLowerSection[10];
                naam=sp.naam;
                Winnaars=new ArrayList<>();
                Winnaars.add(sp);
            } else if (sp.scoreCard.convertLowerSection[10]==highScore){
                Winnaars.add(sp);
            }
        }
        System.out.println();
        if (Winnaars.size()==1) {
            System.out.println(naam + " heeft gewonnen met een score van " + highScore + " punten!");
        } else{
            int x=1;
            for (Speler win: Winnaars){
                System.out.print(win.naam);
                if (x<Winnaars.size()){
                    System.out.print(" en ");
                    x++;
                }

            }
            System.out.println(" hebben gelijk gespeeld met een score van " + highScore + " punten");
            Spelers.get(0).scoreCard.alleKaartenTonen(Spelers);
        }
    }

    int[][] worpAnalyse(Speler sp){

        String scanString="";
        String streetScan="";
        String rawNumbers="";
        int[] Ones = {0};
        int[] Twos = {0};
        int[] Threes = {0};
        int[] Fours = {0};
        int[] Fives = {0};
        int[] Sixes = {0};
        int[][] numberCounter = {Ones, Twos, Threes, Fours, Fives, Sixes};

        for (int x:sp.worpGeschiedenis.get(sp.worpCount).huidigeWorp){
            rawNumbers=rawNumbers+String.valueOf(x);
            numberCounter[x-1][0]+=1;
        }
        for (int[] x: numberCounter){
            for (int n:x){
                String converter = String.valueOf(n);
                scanString = scanString+converter;
                if (n>0){
                    streetScan=streetScan+"1";
                } else{
                    streetScan=streetScan+"0";
                }
            }
        }

        if (rawNumbers.contains("6") && sp.scoreCard.sixesFilled==false){
            sp.scoreCard.containsSixes=true;
        }

        if (rawNumbers.contains("5") && sp.scoreCard.fivesFilled==false){
            sp.scoreCard.containsFives=true;
        }

        if (rawNumbers.contains("4") && sp.scoreCard.containsFours==false){
            sp.scoreCard.containsFours=true;
        }

        if (rawNumbers.contains("3") && sp.scoreCard.threesFilled==false){
            sp.scoreCard.containsThrees=true;
        }

        if (rawNumbers.contains("2") && sp.scoreCard.twosFilled==false){
            sp.scoreCard.containsTwos=true;
        }

        if (rawNumbers.contains("1") && sp.scoreCard.onesFilled==false){
            sp.scoreCard.containsOnes=true;
        }

        System.out.println("U kunt de volgende combinaties uit de lagere secties van de scorekaart maken: ");

        if (scanString.contains("5")){
            sp.scoreCard.isYahtzee=true;
            System.out.print("Yahtzee, ");
            if (sp.scoreCard.quadsFilled==false){
                sp.scoreCard.isQuads=true;
                System.out.print("Four of a kind, ");
            }
            if (sp.scoreCard.tripsFilled==false){
                sp.scoreCard.isTrips=true;
                System.out.print("Three of a kind, ");
            }
        }

        if (scanString.contains("4") && sp.scoreCard.quadsFilled==false){
            sp.scoreCard.isQuads=true;
            sp.scoreCard.isTrips=true;
            System.out.print("Four of a kind, ");
            if (sp.scoreCard.tripsFilled==false){
                sp.scoreCard.isTrips=true;
                System.out.print("Three of a kind, ");
            }
        }

        if (scanString.contains("3") && sp.scoreCard.tripsFilled==false){
            sp.scoreCard.isTrips=true;
            System.out.print("Three of a kind, ");
        }

        if (scanString.contains("3") && scanString.contains("2") && sp.scoreCard.fullHouseFilled==false){
            sp.scoreCard.isFullHouse=true;
            System.out.print("Fullhouse, ");
        }

        if (streetScan.contains("1111") && sp.scoreCard.smStraightFilled==false){
            sp.scoreCard.isSmSt=true;
            System.out.print("Kleine straat, ");
        }
        if (streetScan.contains("11111") && sp.scoreCard.lgStraightFilled==false){
            sp.scoreCard.isLgSt=true;
            System.out.print("Grote straat, ");
        }
        System.out.println();
        return numberCounter;
    }

    void scoreToewijzen(Speler csp) {
        System.out.println("Welke score zou u willen toewijzen? Toets de numerieke waarde in voor een keuze uit de Upper Section");
        System.out.println("Voor een score uit de Lower Section, toetst u: 't' voor 3 of a kind, 'q' voor 4 of a kind, 'f' voor Full House, 's' voor Small Straight, 'l' voor Large Straight, 'y' voor Yahtzee en 'c' voor Chance");

        Scanner invoer = new Scanner(System.in);
        char input = invoer.nextLine().charAt(0);
        if (input == '1' && csp.scoreCard.onesFilled==false && csp.scoreCard.huidigeRondeSorted[0][0] >0) {
            csp.scoreCard.ones = (csp.scoreCard.huidigeRondeSorted[0][0]);
            csp.scoreCard.convertUpperSection[0] = (csp.scoreCard.huidigeRondeSorted[0][0]);
            csp.scoreCard.onesFilled=true;

        } else if (input == '2' && csp.scoreCard.twosFilled==false && csp.scoreCard.huidigeRondeSorted[1][0] >0) {
            csp.scoreCard.twos = (csp.scoreCard.huidigeRondeSorted[1][0] * 2);
            csp.scoreCard.convertUpperSection[1] = (csp.scoreCard.huidigeRondeSorted[1][0] * 2);
            csp.scoreCard.twosFilled=true;

        } else if (input == '3' && csp.scoreCard.threesFilled==false && csp.scoreCard.huidigeRondeSorted[2][0] >0) {
            csp.scoreCard.threes = (csp.scoreCard.huidigeRondeSorted[2][0] * 3);
            csp.scoreCard.convertUpperSection[2] = (csp.scoreCard.huidigeRondeSorted[2][0] * 3);
            csp.scoreCard.threesFilled=true;

        } else if (input == '4' && csp.scoreCard.foursFilled==false && csp.scoreCard.huidigeRondeSorted[3][0] >0) {
            csp.scoreCard.fours = (csp.scoreCard.huidigeRondeSorted[3][0] * 4);
            csp.scoreCard.convertUpperSection[3] = (csp.scoreCard.huidigeRondeSorted[3][0] * 4);
            csp.scoreCard.foursFilled=true;

        } else if (input == '5' && csp.scoreCard.fivesFilled==false && csp.scoreCard.huidigeRondeSorted[4][0] >0) {
            csp.scoreCard.fives = (csp.scoreCard.huidigeRondeSorted[4][0] * 5);
            csp.scoreCard.convertUpperSection[4] = (csp.scoreCard.huidigeRondeSorted[4][0] * 5);
            csp.scoreCard.fivesFilled=true;

        } else if (input == '6' && csp.scoreCard.sixesFilled==false && csp.scoreCard.huidigeRondeSorted[5][0] >0) {
            csp.scoreCard.sixes = (csp.scoreCard.huidigeRondeSorted[5][0] * 6);
            csp.scoreCard.convertUpperSection[5] = (csp.scoreCard.huidigeRondeSorted[5][0] * 6);
            csp.scoreCard.sixesFilled=true;

        } else if (input == 'y' && csp.scoreCard.isYahtzee && !csp.scoreCard.yahtzeeShutdown) {
            if (csp.scoreCard.yahtzeeCounter == 0) {
                csp.scoreCard.yahtzeeFilled=true;
                csp.scoreCard.yahtzee = 50;
                csp.scoreCard.convertLowerSection[5]=50;
                csp.scoreCard.yahtzeeCounter++;
            } else {
                csp.scoreCard.yahtzeeBonus += 100;
                csp.scoreCard.convertLowerSection[7]+=100;
                csp.scoreCard.yahtzeeCounter++;
            }

        } else if (input == 'f' && csp.scoreCard.isFullHouse && csp.scoreCard.fullHouseFilled==false) {
            csp.scoreCard.fullHouse = 25;
            csp.scoreCard.convertLowerSection[2]=25;
            csp.scoreCard.fullHouseFilled=true;

        } else if (input == 'q' && csp.scoreCard.isQuads && csp.scoreCard.quadsFilled==false) {
            int y = 0;
            for (int x : csp.worpGeschiedenis.get(csp.worpCount).huidigeWorp) {
                y += x;
                csp.scoreCard.foaK=y;
                csp.scoreCard.convertLowerSection[1]=y;
                csp.scoreCard.quadsFilled=true;

            }

        } else if (input == 't' && csp.scoreCard.isTrips&& csp.scoreCard.tripsFilled==false) {
            int y = 0;
            for (int x : csp.worpGeschiedenis.get(csp.worpCount).huidigeWorp) {
                y += x;
                csp.scoreCard.toaK = y;
                csp.scoreCard.convertLowerSection[0]=y;
                csp.scoreCard.tripsFilled=true;

            }

        } else if (input == 'l' && csp.scoreCard.isLgSt && csp.scoreCard.lgStraightFilled==false) {
            csp.scoreCard.lgStraight = 40;
            csp.scoreCard.convertLowerSection[4]=40;
            csp.scoreCard.lgStraightFilled=true;

        } else if (input == 's' && csp.scoreCard.isSmSt && csp.scoreCard.smStraightFilled==false) {
            csp.scoreCard.smStraight = 30;
            csp.scoreCard.convertLowerSection[3]=30;
            csp.scoreCard.smStraightFilled=true;

        } else if (input == 'c' && csp.scoreCard.chanceFilled==false) {
            int y = 0;
            for (int x : csp.worpGeschiedenis.get(csp.worpCount).huidigeWorp) {
                y += x;
                csp.scoreCard.chance = y;
                csp.scoreCard.convertLowerSection[6]=y;
                csp.scoreCard.chanceFilled=true;
            }

        } else {
            if (csp.scoreCard.scoringAvailable()) {
                System.out.println("Helaas kan u die hand niet met deze combinatie dobbelstenen maken, probeer het nog een keertje");
                csp.scoreCard.tonenScoreKaart();
                scoreToewijzen(csp);
            } else {
                csp.scoreCard.penaltyToewijzen();
            }
        }
        csp.scoreCard.convertUpperSection[6]=0;
        for (int x=0; x<6; x++){
            csp.scoreCard.convertUpperSection[6]+=csp.scoreCard.convertUpperSection[x];

        }
        csp.scoreCard.convertLowerSection[9]=0;
        for (int x=0; x<8; x++) {
            csp.scoreCard.convertLowerSection[9] +=csp.scoreCard.convertLowerSection[x];
        }
        if (csp.scoreCard.convertUpperSection[7]==0 && csp.scoreCard.convertUpperSection[6]>=63){
            csp.scoreCard.convertUpperSection[7] = 35;
        }
        csp.scoreCard.convertUpperSection[8]=csp.scoreCard.convertUpperSection[6]+csp.scoreCard.convertUpperSection[7];
        csp.scoreCard.convertLowerSection[8]=csp.scoreCard.convertUpperSection[8];
        csp.scoreCard.convertLowerSection[10]=csp.scoreCard.convertLowerSection[8]+csp.scoreCard.convertLowerSection[9];

        csp.scoreCard.transcribeScore();
        csp.scoreCard.tonenScoreKaart();
        csp.scoreCard.turnOffContentChecks();
    }


    void vasthouden(){
        System.out.println("Welke dobbelstenen wil je vasthouden? Toets ENTER indien je geen enkele dobbelsteen wilt vasthouden");
        for (int i=0; i< this.blokkeerarray.length; i++){
            Dobbelstenen.get(i).holdDice=false;
            blokkeerarray[i]=0;
        }
        Scanner inp01= new Scanner(System.in);
        String keepYoN=inp01.nextLine();
        int inputLength=keepYoN.length();
        if (inputLength==0){
            System.out.println("Er worden geen dobbelstenen vastgehouden");
        } else {
            System.out.print("De dobbelstenen met de volgende waardes worden vastgehouden: ");
        }
        for (int i=0;i<inputLength;i++){
            int gotcha=Integer.parseInt(keepYoN.substring(i, i+1));
            System.out.print(gotcha+ ", ");
            for (Dice dobbelsteen: Dobbelstenen){
                if (dobbelsteen.faceUp == gotcha && dobbelsteen.holdDice == false){
                    blokkeerarray[(Dobbelstenen.indexOf(dobbelsteen))]=1;
                    dobbelsteen.holdDice=true;
                    break;
                }
            }
        }
        System.out.println();
    }

    void beurtSpelen(Speler sp) {
            int beurtIndex=sp.beurtCounter;
            sp.beurtGeschiedenis.add(new Beurt(beurtIndex+1));
            sp.beurtCounter++;
            Scanner input = new Scanner(System.in);
            System.out.println("Beurt "+sp.beurtCounter);
            System.out.println(sp.naam +" jij bent aan de beurt:");
            while (sp.noThrowsLeft==false){
                int blockIndex = 0;
                System.out.println("Toets ENTER om de dobbelstenen te werpen of druk 'q' om te stoppen");
                String inputUser = input.nextLine();
                if (inputUser.equals("")) {
                    System.out.println("De dobbelstenen worden geworpen");
                    System.out.println();
                    for (Dice d : Dobbelstenen) {
                        if (blokkeerarray[blockIndex] == 0) {
                            d.faceUp = d.werpen();
                        }
                        blockIndex++;
                    }
                    sp.worpGeschiedenis.add(new Worp(sp.worpCount));
                    sp.worpGeschiedenis.get(sp.worpCount).worpCC(Dobbelstenen);
                    sp.worpGeschiedenis.get(sp.worpCount).worpWeergave();


                    if (sp.beurtWorpCounter == 1) {
                        sp.beurtGeschiedenis.get(beurtIndex).worp1 = sp.worpGeschiedenis.get(sp.worpCount).worpCC(Dobbelstenen);
                    } else if (sp.beurtWorpCounter == 2) {
                        sp.beurtGeschiedenis.get(beurtIndex).worp2 = sp.worpGeschiedenis.get(sp.worpCount).worpCC(Dobbelstenen);
                    } else if (sp.beurtWorpCounter == 3) {
                        sp.beurtGeschiedenis.get(beurtIndex).worp3 = sp.worpGeschiedenis.get(sp.worpCount).worpCC(Dobbelstenen);
                    }
                    sp.scoreCard.turnOffContentChecks();

                    if (sp.beurtWorpCounter <3) {
                        sp.scoreCard.huidigeRondeSorted = worpAnalyse(sp);
                        scorenOfWerpen(sp);

                    } else {
                        for (int i = 0; i < this.blokkeerarray.length; i++) {
                            Dobbelstenen.get(i).holdDice = false;
                            blokkeerarray[i] = 0;
                        }
                        sp.noThrowsLeft=true;
                        sp.scoreCard.huidigeRondeSorted = worpAnalyse(sp);
                        scoreToewijzen(sp);

                    }

                    if (sp.noThrowsLeft==false){
                        System.out.println(sp.naam + " is aan de beurt, " + sp.naam + " heeft nog maximaal " + (3 - sp.beurtWorpCounter) + " worp(en) over deze beurt");
                        sp.worpCount++;
                        sp.beurtWorpCounter++;
                    } else {
                        sp.worpCount++;
                        sp.beurtWorpCounter++;
                    }
                } else if (inputUser.equals("q")) {
                    System.out.println("Wilt u stoppen met spelen?");
                    System.out.println("Toets 'j' om definitief te stoppen en 'n' om toch door te gaan met spelen");
                    char inpUser = input.nextLine().charAt(0);
                    if (inpUser == 'j') {
                        System.out.println("Bedankt voor het spelen van Yahtzee");
                        System.exit(0);
                    } else if (inpUser == 'n') {
                        beurtSpelen(sp);
                    } else {
                        beurtSpelen(sp); //unfinished
                    }
                } else {
                    System.out.println("Het is onduidelijk wat u bedoelt, probeer het nog een keertje");
                    beurtSpelen(sp);
                }
            }
            sp.beurtWorpCounter=1;
            sp.noThrowsLeft=false;
        }

    void scorenOfWerpen(Speler sp) {
        Scanner bgfxInput = new Scanner(System.in);
        System.out.println("Wilt u deze hand een score toewijzen of nog een worp gooien? toets 'j' om uw punten toe te wijzen of 'n' om nogmaals te werpen. U heeft nog " + (3 - sp.beurtWorpCounter) + " worp(en) over.");
        String vasthoudenofScore = bgfxInput.nextLine();
        if (vasthoudenofScore.equals("j")) {
            sp.noThrowsLeft = true;
            scoreToewijzen(sp);
        } else if (vasthoudenofScore.equals("n")) {
            vasthouden();
        } else {
            System.out.println("Helaas die invoer herken ik niet, probeer het nog een keertje");
            scorenOfWerpen(sp);
        }
    }
    }

