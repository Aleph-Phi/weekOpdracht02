/*
Weekopdracht week 2

        Yathzee

        Maak een Yahtzee spel op de command-line.
        In eerste instantie is het een 1 persoons-spel.
        Tref de regels van Yahtzee hier:
        https://nl.wikipedia.org/wiki/Yahtzee
        Onze weekopdracht zal zich richten op het programmeren van de basis-activiteit van het spel.

        De GUI ziet er als volgt uit:
        Het Toont:
        WORP1
        1 2 3 4 5
        6 2 3 3 4
        Welke posities wilt u vasthouden? 0 voor geen anders bv 124
        INVOER: 34 ENTER

        WORP2
        1 2 3 4 5
        3 6 3 3 2
        Druk Enter voor het werpen van een nieuwe worp. Druk q voor het stoppen met het spel.

        Volgorde van doelstellingen:
        1. Maak een loop in de public static void main die loopt zolang je op enter drukt, en stopt zodra je op q drukt.
        2. Maak een losse klasse YahtzeeSpel met een methode spelen(). Verhuis de loop van 1. naar de methode spelen(). Instantieer een YahtzeeSpel in de psvm en start de methode spelen.
        3. Maak een losse methode werpen() in het YahtzeeSPel. Deze methode heeft int als return type. Zorg dat de aanroep van deze methode er voor zorgt dat er een getal tussen 1 en 6 terug komt.
        4. Maak de methode een onderdeel van de klasse Dobbelsteen. Maak in de klasse YahtzeeSpel een Arraylist van Dobbelstenen. In de constructor van het YahtzeeSpel voeg je 5 dobbelstenen toe aan deze ArrayList.
        In de loop van spelen wordt over de Arraylist heengegaan met een enhanced for-loop en werp je iedere dobbelsteen. Hou in je dobbelsteen het resultaat van de worp vast.
        5. Maak een losse methode vasthouden(). Via een Scanner vraagt het programma om invoer. De invoer wordt via Integer.parseInt() omgezet tot een blokkeerarray van 0 en 1 bijvoorbeeld 11001.
        Dit blokkeerarray is een field van het YahtzeeSpel.
        6. Loop in de tweede worp over de arraylist heen en alleen als in de blokkeerarray een 0 staat wordt de dobbelsteen opnieuw geworpen.

        7. Maak een klasse Worp, met een veld van het type int array met lengte 5. Een methode die de worp uitslag weergeeft.
        8. Maak een klasse Speler, met een veld worp-geschiedenis, dit is een array met een flinke lengte of een arraylist.

        9. Zorg dat aan het einde van een worp-cyclus zoals gemaakt tot stap zes, opgeslagen wordt in een Worp-object. Voeg deze toe aan de worp-geschiedenis van de speler.
        10. Maak het spel geschikt voor het spelen met twee spelers.

        Veel succes!
*/

public class Yahtzee { // opdracht veel meer met objecten werken, en static op de main na vermijden
    public static void main(String[] args) {

        YahtzeeSpel nieuwSpel = new YahtzeeSpel();
        nieuwSpel.spelen();
    }
}