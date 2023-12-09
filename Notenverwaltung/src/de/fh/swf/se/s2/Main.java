package de.fh.swf.se.s2;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        // Erstellen eines Studenten

        Student student = new Student("Max", "Mustermann",342456, "Informatik");

        // Hinzufügen von Pflichtmodulen

/*
        pm1.addPNote(5.0); // Erster Versuch
        pm1.addPNote(1.3); // Zweiter Versuch
        pm2.addPNote(3.3);

        // Hinzufügen von Wahlpflichtmodulen
        Wahlmodul wm1 = new Wahlmodul("Webentwicklung", 5, "Beschreibung3", 3);
        Wahlmodul wm2 = new Wahlmodul("Mobile Applikationen", 5, "Beschreibung4", 4);
        student.addWahlmodul(wm1);
        student.addWahlmodul(wm2);
        wm1.addWNote(5.0); // Erster Versuch
        wm1.addWNote(1.2); // Zweiter Versuch
        wm2.addWNote(2.3);


        // Hinzufügen eines Abschlusses
        Abschluss abschluss = new Abschluss("Bachelor Informatik", 0.7, 0.3);
        student.addAbschluss(abschluss);

        // Ausgabe der Informationen
        System.out.println("Student: " + student.getVorname() + " " + student.getNachname());
        System.out.println("Matrikelnummer: " + student.getMatrikelnummer());
        System.out.println("Studiengang: " + student.getStudiengang());
*/
        // Ausgabe der Pflichtmodule und Noten


   /*     // Ausgabe des Durchschnitts der Pflichtmodule
        System.out.println("Durchschnittsnote der Pflichtmodule: " + student.berechnePflichtmodulDurchschnitt());

        // Ausgabe der Wahlpflichtmodule und Noten
        System.out.println("Wahlmodule und Noten:");
        student.getWahlmodule().forEach(modul -> {
            System.out.println(" - " + modul.getModulName() + " Note: " + modul.getNote());
        });

        // Ausgabe des Durchschnitts der Wahlpflichtmodule
        System.out.println("Durchschnittsnote der Wahlpflichtmodule: " + student.berechneWahlModulDurchschnitt());

        // Ausgabe der Abschlussarbeit und der Durchschnittsnote
        System.out.println("Abschlussarbeit: " + student.getAbschluss().getThema());
        //System.out.println("Durchschnittsnote der Abschlussarbeit: " + student.getAbschluss().getFinalerDurchschnitt());

         */
        menu(student);
    }

    public static void menu(Student student){
        Scanner scanner = new Scanner(System.in);
        String input;

        do {
            System.out.println("Pflichtmodule und Noten:");
            student.getPflichtmodule().forEach(modul -> {
                System.out.println(" - " + modul.getModulName() + " Note:" + modul.getNote());
            });
            // Menü anzeigen
            System.out.println("1. Option 1");
            System.out.println("2. Option 2");
            System.out.println("3. Option 3");
            System.out.println("4. Exit");
            System.out.print("Bitte wählen Sie eine Option: ");

            // Benutzereingabe lesen
            input = scanner.nextLine();

            // Menüoptionen verarbeiten
            switch (input) {
                case "1":
                    Pflichtmodul pm1 = new Pflichtmodul("Mathematik", 5, "Beschreibung1", 1);
                    Pflichtmodul pm2 = new Pflichtmodul("Java 2", 5, "Beschreibung2", 2);
                    student.addPflichtmodul(pm1);
                    student.addPflichtmodul(pm2);
                    System.out.println("Sie haben Option 1 ausgewählt.");
                    // Hier können Sie den Code für Option 1 hinzufügen
                    break;
                case "2":



                    System.out.println("Modul einbgeb");
                    String modul = scanner.nextLine();
                    System.out.println("Note eingeben");
                    double note = Double.parseDouble(scanner.nextLine());
                    student.addNoteToPflichmodul(modul,note);

                    // Hier können Sie den Code für Option 2 hinzufügen
                    break;
                case "3":
                    System.out.println("Sie haben Option 3 ausgewählt.");
                    // Hier können Sie den Code für Option 3 hinzufügen
                    break;
                case "4":
                    student.save();
                    System.out.println("Die Anwendung wird beendet.");
                    break;
                default:
                    System.out.println("Ungültige Option. Bitte erneut eingeben.");
            }

        } while (!input.equals("4")); // Die Schleife läuft, bis der Benutzer "4" für "Exit" eingibt

        // Aufräumarbeiten oder Abschlusscode können hier hinzugefügt werden

        scanner.close();
    }
    }



