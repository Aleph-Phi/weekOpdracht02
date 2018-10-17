/*
      System.out.println(" "+"_______"+" ");
      System.out.println("|"+" "+"\u25CF" + "   " +"\u25CF"+" "+"|" );
      System.out.println("|"+" "+"\u25CF" + "   " +"\u25CF"+" "+"|" );
      System.out.println("|"+" "+"\u25CF" + "   " +"\u25CF"+" "+"|" );
      System.out.println(" "+"\u203E"+ 	"\u203E"+ 	"\u203E"+ 	"\u203E"+ "\u203E"+ "\u203E"+"\u203E"+" ");

      System.out.println(" "+"_______"+" ");
      System.out.println("|"+" "+"\u25CF" + "   " +"\u25CF"+" "+"|" );
      System.out.println("|"+"   "+"\u25CF"+"   "+"|" );
      System.out.println("|"+" "+"\u25CF" + "   " +"\u25CF"+" "+"|" );
      System.out.println(" "+"\u203E"+ 	"\u203E"+ 	"\u203E"+ 	"\u203E"+ "\u203E"+ "\u203E"+"\u203E"+" ");

      System.out.println(" "+"_______"+" ");
      System.out.println("|"+" "+"\u25CF" + "   " +"\u25CF"+" "+"|" );
      System.out.println("|"+"       "+"|" );
      System.out.println("|"+" "+"\u25CF" + "   " +"\u25CF"+" "+"|" );
      System.out.println(" "+"\u203E"+ 	"\u203E"+ 	"\u203E"+ 	"\u203E"+ "\u203E"+ "\u203E"+"\u203E"+" ");

      System.out.println(" "+"_______"+" ");
      System.out.println("|"+" "+"\u25CF" + "     "+"|" );
      System.out.println("|"+"   "+"\u25CF"+"   "+"|" );
      System.out.println("|"+"     " +"\u25CF"+" "+"|" );
      System.out.println(" "+"\u203E"+ 	"\u203E"+ 	"\u203E"+ 	"\u203E"+ "\u203E"+ "\u203E"+"\u203E"+" ");

      System.out.println(" "+"_______"+" ");
      System.out.println("|"+" "+"\u25CF" + "     "+"|" );
      System.out.println("|"+"       "+"|" );
      System.out.println("|"+"     " +"\u25CF"+" "+"|" );
      System.out.println(" "+"\u203E"+ 	"\u203E"+ 	"\u203E"+ 	"\u203E"+ "\u203E"+ "\u203E"+"\u203E"+" ");


      System.out.println(" "+"_______"+" ");
      System.out.println("|"+"       "+"|" );
      System.out.println("|"+"   "+"\u25CF"+"   "+"|" );
      System.out.println("|"+"       "+"|" );
      System.out.println(" "+"\u203E"+ 	"\u203E"+ 	"\u203E"+ 	"\u203E"+ "\u203E"+ "\u203E"+"\u203E"+" ");
      */

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

