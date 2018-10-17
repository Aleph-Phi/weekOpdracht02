import java.util.ArrayList;

public class Worp {

    int[] huidigeWorp = new int [5];

    String naam;

    Worp(int num){
        naam="Worp" + num;
    }

    void worpCC (ArrayList<Dice> currentDice) {

          for (int i = 0; i < huidigeWorp.length; i++) {
              huidigeWorp[i] = currentDice.get(i).faceUp;
          }
      }

    void worpWeergave (){

         String dieTop=" "+"_______"+" ";
         String dieEmpRow="|"+"       "+"|";
         String dieBottom=" "+"\u203E"+"\u203E"+"\u203E"+"\u203E"+"\u203E"+"\u203E"+"\u203E"+" ";
         String die2Dot="|"+" "+"\u25CF" + "   " +"\u25CF"+" "+"|";
         String dieCDot="|"+"   "+"\u25CF"+"   "+"|";
         String dieLDot="|"+" "+"\u25CF" + "     "+"|";
         String dieRDot="|"+"     " +"\u25CF"+" "+"|";
         String space="";

         String dieTopS=dieTop+space;
         String dieBottomS=dieBottom+space;
         String dieTopSFull=dieTopS+dieTopS+dieTopS+dieTopS+dieTopS;
         String dieBottomSFull=dieBottomS+dieBottomS+dieBottomS+dieBottomS+dieBottomS;
         String dieEmpRowS=dieEmpRow+space;
         String die2DotS=die2Dot+space;
         String dieCDotS=dieCDot+space;
         String dieLDotS=dieLDot+space;
         String dieRDotS=dieRDot+space;

         String[] upperRows = {dieEmpRowS, dieLDotS, dieLDotS, die2DotS, die2DotS, die2DotS};
         String[] midRows = {dieCDotS, dieEmpRowS, dieCDotS, dieEmpRowS, dieCDotS, die2DotS};
         String[] lowerRows= {dieEmpRowS, dieRDotS, dieRDotS, die2DotS, die2DotS, die2DotS};

        System.out.println(dieTopSFull);
        for (int d : huidigeWorp) {
            System.out.print(upperRows[d - 1]);
        }
        System.out.println();
        for (int d : huidigeWorp) {
            System.out.print(midRows[d - 1]);
        }
        System.out.println();
        for (int d : huidigeWorp) {
            System.out.print(lowerRows[d - 1]);
        }
        System.out.println();
        System.out.println(dieBottomSFull);
    }
}
