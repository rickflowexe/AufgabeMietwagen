package com.company;

import java.util.Scanner;

public class UserInterface {
    /**
     * Klasse UserInterface beinhaltet das Hauptmenü s
     */
    static Datenbank autoDatenbank = null;

    /**
     * @param autoDatenbank ist die Datenbank die hier benutzt wird vom Datentyp Datenbank
     *                      Klassenvariable von jeder Methode erreichbar
     */

    //    Main Anfang
    public static void main(String[] args) {
        autoDatenbank = new Datenbank();
        autoDatenbank.datenbankMitStandardAutosFuellen();
        autoDatenbank.fuegeDummyDatensaetzeHinzu();
        hauptMenu();
    }

    public static void hauptMenu() {
        /**
         * von hier aus werden die Methoden aus der Klasse Datenbank aufgerufen
         */

        System.out.println("\nWähle aus\n(1): Ausgabe aller Datensätze\n(2): Hinzufügen eines Datensatzes" +
                "\n(3): Suche nach einem Datensatz\n(4): Löschen eines Datensatzes\n(5): Sortieren aller Datensätze" +
                "\n(0/B/b): Programm beenden");
        Scanner scanner = new Scanner(System.in);
        String eingabeUser = scanner.next();

        switch (eingabeUser) {
            case "1":
                System.out.println("Hiermit werden alle Datensätze ausgegeben. Spawn.");
                autoDatenbank.ausgabeAllerDatensaetze();
                hauptMenu();
            case "2":
                System.out.println("Hiermit wird ein Auto Objekt erstellt, New Player.");
                autoDatenbank.fuegeDatensatzHinzu();
                hauptMenu();
            case "3":
                System.out.println("Hiermit werden Datensätze gesucht, Search.");
                autoDatenbank.sucheDatensatz();
                hauptMenu();
            case "4":
                System.out.println("Hiermit werden Datensätze gelöscht, Destroy.");
                autoDatenbank.loescheDatensatz();
                hauptMenu();
            case "5":
                System.out.println("Hiermit werden alle Datensätze sortiert, New Order.");
                autoDatenbank.sortierenAllerDatensaetze();
                hauptMenu();
            case "0", "b", "B":
                System.exit(0);
            default:
                System.out.println("Fehler.");
                hauptMenu();
        }
    }
}
