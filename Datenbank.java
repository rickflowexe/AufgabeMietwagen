package com.company;

import java.util.Scanner;

import static com.company.UserInterface.hauptMenu;

public class Datenbank {

    private final Auto[] autoArray;
    private int positionArray = 0;
    Scanner scanner = new Scanner(System.in);

    /**
     * autoArray ist ein final Array mit Auto Objekten, ist ein Attribut von Datenbank
     * positionArray
     */

    public Datenbank() {
        /**
         * hier wird autoArray die Größe 50 gegeben
         */
        autoArray = new Auto[50];
    }

    public void datenbankMitStandardAutosFuellen() {
        /**
         * autoArray wird mit leeren Autos gefüllt
         */
        for (int i = 0; i < 50; i++) {
            autoArray[i] = new Auto(0, "leer", 0, 0);
        }
    }

    public void fuegeDummyDatensaetzeHinzu() {
        autoArray[0] = new Auto(100, "Jaguar", 550, 55000.00);
        autoArray[1] = new Auto(101, "Porsche", 400, 40000.00);
        autoArray[2] = new Auto(102, "Lambo", 700, 70000.00);
        autoArray[3] = new Auto(103, "Ferrarri", 900, 90000.00);
        autoArray[4] = new Auto(104, "Maserati", 500, 50000.00);
        autoArray[5] = new Auto(105, "Bugati", 1000, 100000.00);
        autoArray[6] = new Auto(106, "AstonMartin", 600, 60000.00);
        autoArray[7] = new Auto(107, "Koenigsegg", 1100, 110000.00);
        autoArray[8] = new Auto(108, "Mclaren", 800, 80000.00);
        autoArray[9] = new Auto(109, "Mercedes", 650, 65000.00);
        autoArray[10] = new Auto(200, "Jaguar", 555, 55500.00);
    }

    public void ausgabeAllerDatensaetze() {
        /**
         * hiermit werden alle Datensätze von autoArray ausgegeben
         */
        for (int i = 0; i < 50; i++) {
            if (autoArray[i].getId() != 0) {
                System.out.println("Array Position: " + i + ", Id: " + autoArray[i].getId() + ", Hersteller: "
                        + autoArray[i].getHersteller() + ", PS: " + autoArray[i].getPs() + ", Preis: "
                        + autoArray[i].getPreis() + " €.");
            } /*else {
                System.out.println("Array Position: " + i + ", ist leer.");
            }*/
        }
    }

    public void fuegeDatensatzHinzu() {
        /**
         * Methode wird benutzt um ein Auto Objekt dem autoArray hinzuzufügen
         */
        int fuegeIdHinzu = 0, fuegePsHinzu = 0;
        double fuegePreisHinzu = 0;
        boolean fuegeIdHinzuRichtig = false, fuegePsHinzuRichtig = false, fuegePreisHinzuRichtig = false;
        /**
         * "...Hinzu" Attribute sind diese die später dem Auto Objekt hinzugefügt werden
         * "...Richtig" Attribute dienen dazu mit Try & Catch zusammenzuarbeiten um Fehleingaben zu vermeiden
         */
        do {
            /**
             * do-while Schleife solange "...Richtig" Attribut false ist
             */
            try {
                /**
                 * Eingabe prüfen, "...Richtig" Attribut auf true setzen
                 */
                System.out.println("\nBitte gebe die ID mit ganzen Zahlen ein.");
                fuegeIdHinzu = scanner.nextInt();
                fuegeIdHinzuRichtig = true;
            } catch (Exception e) {
                /**
                 * Fehler auffangen
                 */
                System.out.println("Fehler.");
                scanner.nextLine();
            }
        } while (!fuegeIdHinzuRichtig);
        System.out.println("Bitte gebe den Hersteller an.");
        String fuegeHerstellerHinzu = scanner.next();
        do {
            /**
             * do-while Schleife solange "...Richtig" Attribut false ist
             */
            try {
                /**
                 * Eingabe prüfen, "...Richtig" Attribut auf true setzen
                 */
                System.out.println("Bitte gebe die PS mit ganzen Zahlen ein.");
                fuegePsHinzu = scanner.nextInt();
                fuegePsHinzuRichtig = true;
            } catch (Exception e) {
                /**
                 * Fehler auffangen
                 */
                System.out.println("Fehler.");
                scanner.nextLine();
            }
        } while (!fuegePsHinzuRichtig);
        do {
            /**
             * do-while Schleife solange "...Richtig" Attribut false ist
             */
            try {
                /**
                 * Eingabe prüfen, "...Richtig" Attribut auf true setzen
                 */
                System.out.println("Bitte gebe den Preis mit Komma ein wenn du Kommazahlen verwendest.");
                fuegePreisHinzu = scanner.nextDouble();
                fuegePreisHinzuRichtig = true;
            } catch (Exception e) {
                /**
                 * Fehler auffangen
                 */
                System.out.println("Fehler.");
                scanner.nextLine();
            }
        } while (!fuegePreisHinzuRichtig);
        for (int i = 0; i < 50; i++) {
            /**
             * Rausfinden welche Stelle im Array die erste ist die frei ist
             */
            if (autoArray[i].getId() == 0) {
                /**
                 * Auto Objekt mit den vorherigen Werten erstellen und an diese Stelle speichern
                 */
                autoArray[i] = new Auto(fuegeIdHinzu, fuegeHerstellerHinzu, fuegePsHinzu, fuegePreisHinzu);
                System.out.println("Array Position: " + i + ", Id: " + autoArray[i].getId() + ", Hersteller: "
                        + autoArray[i].getHersteller() + ", PS: " + autoArray[i].getPs() + ", Preis: "
                        + autoArray[i].getPreis() + " €.");
                System.out.println("Erfolgreich hinzugefügt.");
                /**
                 * Zurück ins Hauptmenü
                 */
                hauptMenu();
            }
        }
    }

    public void sucheDatensatz() {
        /**
         * Datensätze durchsuchen
         */
        System.out.println("\nNach welcher Eigenschaft möchtest du suchen?\n(1): ID\n(2): Hersteller\n(3): PS" +
                "\n(4): Preis\n(0): Hauptmenü");
        String auswahlUser = scanner.next().toLowerCase();
        /**
         * Userwahl nach was gesucht werden soll oder Hauptmenü
         */
        int sucheId = 0, suchePs = 0;
        double suchePreis = 0;
        boolean sucheIdRichtig = false, suchePsRichtig = false, suchePreisRichtig = false;
        switch (auswahlUser) {
            case "1", "id":
                do {
                    /**
                     * do-while Schleife solange "...Richtig" Attribut false ist
                     */
                    try {
                        /**
                         * Eingabe prüfen, "...Richtig" Attribut auf true setzen
                         */
                        System.out.println("Bitte gebe die ID mit ganzen Zahlen ein.");
                        sucheId = scanner.nextInt();
                        sucheIdRichtig = true;
                    } catch (Exception e) {
                        /**
                         * Fehler auffangen
                         */
                        System.out.println("Fehler.");
                        scanner.nextLine();
                    }
                } while (!sucheIdRichtig);
                boolean idGefunden = false;
                for (int i = 0; i < 50; i++) {
                    /**
                     * Schleife zum finden des Eintrags im Array
                     * Print Eintrag
                     */
                    if (autoArray[i].getId() == sucheId) {
                        idGefunden = true;
                        System.out.println("Array Position: " + i + ", Id: " + autoArray[i].getId() + ", Hersteller: "
                                + autoArray[i].getHersteller() + ", PS: " + autoArray[i].getPs() + ", Preis: "
                                + autoArray[i].getPreis() + " €.");
                    }
                }
                if (!idGefunden) {
                    /**
                     * falls nichts gefunden wird
                     */
                    System.out.println("Kein Auto mit dieser ID gefunden.");
                }
                sucheDatensatz();
            case "2", "hs", "hersteller":
                System.out.println("Bitte gebe den Hersteller an nach dem du suchst.");
                String sucheHersteller = scanner.next();
                boolean herstellerGefunden = false;
                for (int i = 0; i < 50; i++) {
                    /**
                     * Schleife zum finden des Eintrags im Array
                     * Print Eintrag
                     */
                    if (autoArray[i].getHersteller().equalsIgnoreCase(sucheHersteller)) {
                        herstellerGefunden = true;
                        System.out.println("Array Position: " + i + ", Id: " + autoArray[i].getId() + ", Hersteller: "
                                + autoArray[i].getHersteller() + ", PS: " + autoArray[i].getPs() + ", Preis: "
                                + autoArray[i].getPreis() + " €.");
                    }
                }
                if (!herstellerGefunden) {
                    /**
                     * falls nichts gefunden wird
                     */
                    System.out.println("Kein Auto mit diesem Hersteller gefunden.");
                }
                sucheDatensatz();
            case "3", "ps":
                do {
                    /**
                     * do-while Schleife solange "...Richtig" Attribut false ist
                     */
                    try {
                        /**
                         * Eingabe prüfen, "...Richtig" Attribut auf true setzen
                         */
                        System.out.println("Bitte gebe die PS mit ganzen Zahlen ein.");
                        suchePs = scanner.nextInt();
                        suchePsRichtig = true;
                    } catch (Exception e) {
                        /**
                         * Fehler auffangen
                         */
                        System.out.println("Fehler.");
                        scanner.nextLine();
                    }
                } while (!suchePsRichtig);
                boolean psGefunden = false;
                for (int i = 0; i < 50; i++) {
                    /**
                     * Schleife zum finden des Eintrags im Array
                     * Print Eintrag
                     */
                    if (autoArray[i].getPs() == suchePs) {
                        psGefunden = true;
                        System.out.println("Array Position: " + i + ", Id: " + autoArray[i].getId() + ", Hersteller: "
                                + autoArray[i].getHersteller() + ", PS: " + autoArray[i].getPs() + ", Preis: "
                                + autoArray[i].getPreis() + " €.");
                    }
                }
                if (!psGefunden) {
                    /**
                     * falls nichts gefunden wird
                     */
                    System.out.println("Kein Auto mit diesen PS gefunden.");
                }
                sucheDatensatz();
            case "4", "preis":
                do {
                    /**
                     * do-while Schleife solange "...Richtig" Attribut false ist
                     */
                    try {
                        /**
                         * Eingabe prüfen, "...Richtig" Attribut auf true setzen
                         */
                        System.out.println("Bitte gebe den Preis mit Komma ein wenn du Kommazahlen verwendest.");
                        suchePreis = scanner.nextDouble();
                        suchePreisRichtig = true;
                    } catch (Exception e) {
                        /**
                         * Fehler auffangen
                         */
                        System.out.println("Fehler.");
                        scanner.nextLine();
                    }
                } while (!suchePreisRichtig);
                boolean preisGefunden = false;
                for (int i = 0; i < 50; i++) {
                    /**
                     * Schleife zum finden des Eintrags im Array
                     * Print Eintrag
                     */
                    if (autoArray[i].getPreis() == suchePreis) {
                        preisGefunden = true;
                        System.out.println("Array Position: " + i + ", Id: " + autoArray[i].getId() + ", Hersteller: "
                                + autoArray[i].getHersteller() + ", PS: " + autoArray[i].getPs() + ", Preis: "
                                + autoArray[i].getPreis() + " €.");
                    }
                }
                if (!preisGefunden) {
                    /**
                     * falls nichts gefunden wird
                     */
                    System.out.println("Kein Auto mit diesem Preis gefunden.");
                }
                sucheDatensatz();
            case "0", "haupt", "hauptmenue":
                /**
                 * Zurück ins Hauptmenü
                 */
                hauptMenu();
            default:
                System.out.println("Fehler.");
                sucheDatensatz();
        }


    }

    public void loescheDatensatz() {
        /**
         * Wird zum loeschen eines Datensatzes verwendet
         */
        System.out.println("\nMit welcher Eigenschaft möchtest du ein Auto löschen?\n(1): ID\n(2): Hersteller\n(3): PS" +
                "\n(4): Preis\n(0): Hauptmenü");
        String auswahlUser = scanner.next().toLowerCase();
        /**
         * Userwahl nach was gelöscht werden soll oder Hauptmenü
         */
        int loescheId = 0, loeschePs = 0;
        double loeschePreis = 0;
        boolean loescheIdRichtig = false, loeschePsRichtig = false, loeschePreisRichtig = false;
        switch (auswahlUser) {
            case "1", "id":
                do {
                    /**
                     * do-while Schleife solange "...Richtig" Attribut false ist
                     */
                    try {
                        /**
                         * Eingabe prüfen, "...Richtig" Attribut auf true setzen
                         */
                        System.out.println("Bitte gebe die ID von dem Auto an das du löschen möchtest mit ganzen Zahlen ein.");
                        loescheId = scanner.nextInt();
                        loescheIdRichtig = true;
                    } catch (Exception e) {
                        /**
                         * Fehler auffangen
                         */
                        System.out.println("Fehler.");
                        scanner.nextLine();
                    }
                } while (!loescheIdRichtig);
                boolean idGefunden = false;
                for (int i = 0; i < 50; i++) {
                    /**
                     * Schleife zum finden des Eintrags im Array
                     * "...Gefunden" Attribut auf true setzen
                     * Print Eintrag
                     */
                    if (autoArray[i].getId() == loescheId) {
                        idGefunden = true;
                        System.out.println("Array Position: " + i + ", Id: " + autoArray[i].getId() + ", Hersteller: "
                                + autoArray[i].getHersteller() + ", PS: " + autoArray[i].getPs() + ", Preis: "
                                + autoArray[i].getPreis() + " €.");
                        System.out.println("Willst du diese löschen? Ja: 1 / Nein: nicht 1 ;)");
                        String wirklichloeschen = scanner.next();
                        /**
                         * Mit löschen fortfahren?
                         */
                        if (wirklichloeschen.equals("1")) {
                            System.out.println("Wurde gelöscht.");
                            for(int j = 0; j < 50; j++){
                                if (autoArray[j].getId() == 0){
                                    autoArray[i] = autoArray[j-1];
                                    autoArray[j-1] = new Auto(0, "leer", 0, 0);
                                    break;
                                }
                            }
                        } else {
                            System.out.println("Wurde nicht gelöscht.");
                        }
                    }
                }
                if (!idGefunden) {
                    /**
                     * falls nichts gefunden wird
                     */
                    System.out.println("Kein Auto mit dieser ID gefunden.");
                }
                loescheDatensatz();
            case "2", "hs", "hersteller":
                System.out.println("Bitte gebe den Hersteller von dem Auto an das du löschen möchtest an.");
                String loescheHersteller = scanner.next();
                boolean herstellerGefunden = false;
                for (int i = 0; i < 50; i++) {
                    /**
                     * Schleife zum finden des Eintrags im Array
                     * "...Gefunden" Attribut auf true setzen
                     * Print Eintrag
                     */
                    if (autoArray[i].getHersteller().equalsIgnoreCase(loescheHersteller)) {
                        herstellerGefunden = true;
                        System.out.println("Array Position: " + i + ", Id: " + autoArray[i].getId() + ", Hersteller: "
                                + autoArray[i].getHersteller() + ", PS: " + autoArray[i].getPs() + ", Preis: "
                                + autoArray[i].getPreis() + " €.");
                        System.out.println("Willst du diese löschen? Ja: 1 / Nein: nicht 1 ;)");
                        String wirklichloeschen = scanner.next();
                        /**
                         * Mit löschen fortfahren?
                         */
                        if (wirklichloeschen.equals("1")) {
                            System.out.println("Wurde gelöscht.");
                            for(int j = 0; j < 50; j++){
                                if (autoArray[j].getId() == 0){
                                    autoArray[i] = autoArray[j-1];
                                    autoArray[j-1] = new Auto(0, "leer", 0, 0);
                                    break;
                                }
                            }
                        } else {
                            System.out.println("Wurde nicht gelöscht.");
                        }
                    }
                }
                if (!herstellerGefunden) {
                    /**
                     * falls nichts gefunden wird
                     */
                    System.out.println("Kein Auto mit diesem Hersteller gefunden.");
                }
                loescheDatensatz();
            case "3", "ps":
                do {
                    /**
                     * do-while Schleife solange "...Richtig" Attribut false ist
                     */
                    try {
                        /**
                         * Eingabe prüfen, "...Richtig" Attribut auf true setzen
                         */
                        System.out.println("Bitte gebe die PS von dem Auto an das du löschen möchtest mit ganzen Zahlen ein.");
                        loeschePs = scanner.nextInt();
                        loeschePsRichtig = true;
                    } catch (Exception e) {
                        /**
                         * Fehler auffangen
                         */
                        System.out.println("Fehler.");
                        scanner.nextLine();
                    }
                } while (!loeschePsRichtig);
                boolean psGefunden = false;
                for (int i = 0; i < 50; i++) {
                    /**
                     * Schleife zum finden des Eintrags im Array
                     * "...Gefunden" Attribut auf true setzen
                     * Print Eintrag
                     */
                    if (autoArray[i].getPs() == loeschePs) {
                        psGefunden = true;
                        System.out.println("Array Position: " + i + ", Id: " + autoArray[i].getId() + ", Hersteller: "
                                + autoArray[i].getHersteller() + ", PS: " + autoArray[i].getPs() + ", Preis: "
                                + autoArray[i].getPreis() + " €.");
                        System.out.println("Willst du diese löschen? Ja: 1 / Nein: nicht 1 ;)");
                        String wirklichloeschen = scanner.next();
                        /**
                         * Mit löschen fortfahren?
                         */
                        if (wirklichloeschen.equals("1")) {
                            System.out.println("Wurde gelöscht.");
                            for(int j = 0; j < 50; j++){
                                if (autoArray[j].getId() == 0){
                                    autoArray[i] = autoArray[j-1];
                                    autoArray[j-1] = new Auto(0, "leer", 0, 0);
                                    break;
                                }
                            }
                        } else {
                            System.out.println("Wurde nicht gelöscht.");
                        }
                    }
                }
                if (!psGefunden) {
                    /**
                     * falls nichts gefunden wird
                     */
                    System.out.println("Kein Auto mit diesen PS gefunden.");
                }
                loescheDatensatz();
            case "4", "preis":
                do {
                    /**
                     * do-while Schleife solange "...Richtig" Attribut false ist
                     */
                    try {
                        /**
                         * Eingabe prüfen, "...Richtig" Attribut auf true setzen
                         */
                        System.out.println("Bitte gebe den Preis von dem Auto an das du löschen möchtest mit Komma ein " +
                                "wenn du Kommazahlen verwendest.");
                        loeschePreis = scanner.nextDouble();
                        loeschePreisRichtig = true;
                    } catch (Exception e) {
                        /**
                         * Fehler auffangen
                         */
                        System.out.println("Fehler.");
                        scanner.nextLine();
                    }
                } while (!loeschePreisRichtig);
                boolean preisGefunden = false;
                for (int i = 0; i < 50; i++) {
                    /**
                     * Schleife zum finden des Eintrags im Array
                     * "...Gefunden" Attribut auf true setzen
                     * Print Eintrag
                     */
                    if (autoArray[i].getPreis() == loeschePreis) {
                        preisGefunden = true;
                        System.out.println("Array Position: " + i + ", Id: " + autoArray[i].getId() + ", Hersteller: "
                                + autoArray[i].getHersteller() + ", PS: " + autoArray[i].getPs() + ", Preis: "
                                + autoArray[i].getPreis() + " €.");
                        System.out.println("Willst du diese löschen? Ja: 1 / Nein: nicht 1 ;)");
                        String wirklichloeschen = scanner.next();
                        /**
                         * Mit löschen fortfahren?
                         */
                        if (wirklichloeschen.equals("1")) {
                            System.out.println("Wurde gelöscht.");
                            for(int j = 0; j < 50; j++){
                                if (autoArray[j].getId() == 0){
                                    autoArray[i] = autoArray[j-1];
                                    autoArray[j-1] = new Auto(0, "leer", 0, 0);
                                    break;
                                }
                            }
                        } else {
                            System.out.println("Wurde nicht gelöscht.");
                        }
                    }
                }
                if (!preisGefunden) {
                    /**
                     * falls nichts gefunden wird
                     */
                    System.out.println("Kein Auto mit diesem Preis gefunden.");
                }
                loescheDatensatz();
            case "0", "haupt", "hauptmenue":
                /**
                 * Zurück ins Hauptmenü
                 */
                hauptMenu();
            default:
                System.out.println("Fehler.");
                loescheDatensatz();
        }
    }

    public void sortierenAllerDatensaetze() {
        /**
         * Datensätze nach Hersteller sortieren
         */
        int anzahlAutos = 0;
        for (int i = 0; i < autoArray.length; i++) {
            /**
             * wie viele Autos sind im Array?
             */
            if (autoArray[i].getId() != 0) {
                anzahlAutos++;
            }
        }
        Auto temp;
        for (int i = 1; i < anzahlAutos; i++) {
            /**
             * sortieren
             */
            for (int j = 0; j < anzahlAutos - i; j++) {
                if (autoArray[j].getHersteller().compareToIgnoreCase(autoArray[j + 1].getHersteller()) > 0) {
                    temp = autoArray[j];
                    autoArray[j] = autoArray[j + 1];
                    autoArray[j + 1] = temp;
                }
            }
        }
        System.out.println("Datensätze wurden erfolgreich nach Hersteller aufsteigend sortiert.");
        /**
         * Zurück ins Hauptmenü
         */
        hauptMenu();
    }
}
