package de.fh.swf.se.s2;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        // Erstellen eines Studenten

        Student student = new Student("Max", "Mustermann",342456, "Informatik");
        menu(student);
    }

    public static void menu(Student student){
        Scanner scanner = new Scanner(System.in);
        String input;

        do {
            System.out.println("Pflichtmodule und Noten:");
            System.out.printf("%-20s|%-20s|%-15s|%-10s|%-10s%n", "Modulname", "Beschreibung", "Creditpoints",  "Note", "Semester");
            System.out.println("-----------------------------------------------------------------------------");
            student.getPflichtmodule().forEach(modul -> {
                System.out.printf("%-20s|%-20s|%-15s|%-10s|%-10s%n",
                        modul.getModulName(),
                        modul.getBeschreibung(),
                        modul.getCreditpoints(),
                        modul.getNote(),
                        modul.getSemester());
            });

            System.out.println("-----------------------------------------------------------------------------");


            // Menü anzeigen
            System.out.println("1. Neues Pflichtmodul hinzufügen");
            System.out.println("2. Option 2");
            System.out.println("3. Option 3");
            System.out.println("4. Exit");
            System.out.print("Bitte wählen Sie eine Option: ");

            // Benutzereingabe lesen
            input = scanner.nextLine();

            // Menüoptionen verarbeiten
            switch (input) {
                case "1":
                    String name;
                    int credit;
                    String beschreibung;
                    int semester;
                    do {
                        System.out.println("Modulname");
                        name = scanner.nextLine();
                        System.out.println("Creditpoints");
                        credit = Integer.parseInt(scanner.nextLine());
                        System.out.println("Beschreibung");
                        beschreibung = scanner.nextLine();
                        System.out.println("Semester");
                        semester = Integer.parseInt(scanner.nextLine());
                        System.out.println("Passt alles? Ja/Nein");
                        input = scanner.nextLine();
                    } while (!input.equals("Ja"));
                    Pflichtmodul pm = new Pflichtmodul(name, credit, beschreibung, semester);
                    student.addPflichtmodul(pm);
                    System.out.println("Sie haben Option 1 ausgewählt.");
                    // Hier können Sie den Code für Option 1 hinzufügen
                    break;
                case "2":


                    System.out.println("Modul einbgeb");
                    String modul = scanner.nextLine();
                    System.out.println("Note eingeben");
                    double note = Double.parseDouble(scanner.nextLine());
                    student.addNoteToPflichmodul(modul, note);

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



