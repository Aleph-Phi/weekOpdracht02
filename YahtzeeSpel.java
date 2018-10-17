import java.util.ArrayList;
import java.util.Scanner;

public class YahtzeeSpel {

    ArrayList<Dice> Dobbelstenen = new ArrayList<Dice>();
    ArrayList<Speler> Spelers = new ArrayList<Speler>();
    int[] blokkeerarray = {0,0,0,0,0};

    int worpCount;

    YahtzeeSpel(){
        System.out.println();
        System.out.println("Welkom bij Yahtzee!");
        System.out.println();
        for (int i=1; i<6; i++){
            Dobbelstenen.add(new Dice(i));
        }
        Spelers.add(new Speler(1));
        }

    public void spelen(){
        Scanner input = new Scanner(System.in);
        int icount=0;
        System.out.println("Toets ENTER om de dobbelstenen te werpen of druk 'q' om te stoppen");
        String inputUser= input.nextLine();
        System.out.println(inputUser);
        if(inputUser.equals("")){
            System.out.println("De dobbelstenen worden geworpen");
            System.out.println();
            for (Dice d :Dobbelstenen){
                if (blokkeerarray[icount]==0) {
                    d.faceUp = d.werpen();
                    System.out.println(d.faceUp);
                }
                icount++;
            }
            Spelers.get(0).worpGeschiedenis.add(new Worp(worpCount));
            Spelers.get(0).worpGeschiedenis.get(worpCount).worpCC(Dobbelstenen);
            Spelers.get(0).worpGeschiedenis.get(worpCount).worpWeergave();
            worpCount++;
            vasthouden();
            spelen();
        } else if(inputUser.equals("q")){
            System.out.println("Wilt u stoppen met spelen?");
            System.out.println("Toets 'j' om definitief te stoppen en 'n' om toch door te gaan met spelen");
            char inpUser= input.nextLine().charAt(0);
            if (inpUser == 'j'){
                System.out.println("Bedankt voor het spelen van Yahtzee");
                System.exit(0);
            } else if (inpUser == 'n'){
                spelen();
            } else {
                spelen(); //unfinished
            }
        } else {
            System.out.println("Het is onduidelijk wat u bedoelt, probeer het nog een keertje");
        }
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
}