package de.fh.swf.se.s2;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student student = null;
        // Erstellen eines Studenten
        System.out.println("logg In(Nachname):");

        String lnachname = scanner.nextLine();
            try {
                var filePath = "/Users/juliantomsa/Library/CloudStorage/SynologyDrive-Uni/Software-Engineering/Programm (Blatt3)/Notenverwaltung/src/Student.csv";
                var file = Paths.get(filePath);

                if (!Files.exists(file)) {
                    System.out.println("File not found: " + filePath);
                    return;
                }

                var fileContent = Files.readString(file, Charset.forName("UTF-8"));

                // Trennen Sie die Zeilen der CSV-Datei
                List<String> lines = Arrays.asList(fileContent.split("\n"));

                // Iterieren Sie durch jede Zeile und verarbeiten Sie die Daten
                for (String line : lines) {
                    // Trennen Sie die einzelnen Felder durch das Trennzeichen ";"
                    String[] fields = line.split(";");

                    // Validieren Sie die Länge des Arrays
                    if (fields.length >= 4) {
                        // Extrahieren Sie die Daten aus den Feldern
                        String vorname = fields[0];
                        String nachname = fields[1];
                        int matrikelnummer = Integer.parseInt(fields[2]);
                        String studiengang = fields[3];


                        // Rufen Sie Ihre Methode auf, um die Daten zu verarbeiten
                        if(Objects.equals(nachname, lnachname)) {
                            student = new Student (vorname,nachname,matrikelnummer,studiengang);
                        }

                    } else {
                        System.out.println("Warning: Insufficient fields in line");
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        menu(student);
    }

    public static void menu(Student student) {
        Scanner scanner = new Scanner(System.in);
        String input;
        String name;
        int credit;
        String beschreibung;
        int semester;
        String modulname;
        double note;

        do {
            System.out.println("Name:" + student.getVorname() + " " + student.getNachname());
            System.out.println("Pflichtmodule und Noten:");
            System.out.printf("%-20s|%-40s|%-15s|%-10s|%-10s|%-8s%n", "Modulname", "Beschreibung", "Creditpoints", "Note", "Semester", "Versuch");
            System.out.println("-----------------------------------------------------------------------------------------------------------");
            student.getPflichtmodule().forEach(modul -> {
                System.out.printf("%-20s|%-40s|%-15s|%-10s|%-10s|%-8s%n",
                        modul.getModulName(),
                        modul.getBeschreibung(),
                        modul.getCreditpoints(),
                        modul.getNote(),
                        modul.getSemester(),
                        modul.getVersuch());
            });
            System.out.println("\nWahlmodule und Noten:");
            System.out.printf("%-20s|%-40s|%-15s|%-10s|%-10s%n", "Modulname", "Beschreibung", "Creditpoints", "Note", "Semester");
            System.out.println("-----------------------------------------------------------------------------------------------------------");
            student.getWahlmodule().forEach(modul -> {
                System.out.printf("%-20s|%-40s|%-15s|%-10s|%-10s%n",
                        modul.getModulName(),
                        modul.getBeschreibung(),
                        modul.getCreditpoints(),
                        modul.getNote(),
                        modul.getSemester());
            });

            System.out.println("-----------------------------------------------------------------------------------------------------------");
            System.out.println("\nAbschluss");

            student.getAbschluss().forEach(abschluss -> {
            System.out.println(abschluss.getThema()+" "+ abschluss.getNoteArbeit()+ " "+ abschluss.getNoteArbeit());
            });


            System.out.println("-----------------------------------------------------------------------------------------------------------");


            // Menü anzeigen
            System.out.println("1. Neues Pflichtmodul hinzufügen");
            System.out.println("2. Note Pflichtmodul");
            System.out.println("3. Neues Wahlmodul hinzufügen");
            System.out.println("4. Note Wahlmodul");
            System.out.println("5. Einzelnes Modul");
            System.out.println("6. Abschluss erstellen");

            System.out.println("9. Exit");


            System.out.print("Bitte wählen Sie eine Option: ");

            // Benutzereingabe lesen
            input = scanner.nextLine();
            clearScreen();
            // Menüoptionen verarbeiten
            switch (input) {
                case "1":

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
                    modulname = scanner.nextLine();
                    System.out.println("Note eingeben");
                    note = Double.parseDouble(scanner.nextLine());
                    student.addNoteToPflichmodul(modulname, note);

                    // Hier können Sie den Code für Option 2 hinzufügen
                    break;
                case "3":
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
                    Wahlmodul wm = new Wahlmodul(name, credit, beschreibung, semester);
                    student.addWahlmodul(wm);
                    System.out.println("Sie haben Option 1 ausgewählt.");
                    // Hier können Sie den Code für Option 1 hinzufügen
                    // Hier können Sie den Code für Option 3 hinzufügen
                    break;
                case "4":
                    System.out.println("Modul einbgeb");
                    modulname = scanner.nextLine();
                    System.out.println("Note eingeben");
                    note = Double.parseDouble(scanner.nextLine());
                    student.addNoteToWahlModul(modulname, note);

                case "5":
                    System.out.println("Modul eingeben");
                    modulname = scanner.nextLine();
                    einzelmodul(modulname, student);

                    // Hier können Sie den Code für Option 2 hinzufügen
                    break;
                case "6":
                    System.out.println("Thema:");
                    String thema = scanner.nextLine();
                    System.out.println("Gewichtung Arbeit");
                    double arbeit = Double.parseDouble(scanner.nextLine());
                    System.out.println("Gewichtung Kolloquium");
                    double kolloquium = Double.parseDouble(scanner.nextLine());
                    Abschluss abschluss1 = new Abschluss(thema, arbeit, kolloquium);
                    student.addAbschluss(abschluss1);
                    break;
                case "9":
                    student.save();
                    break;
                default:
                    System.out.println("Ungültige Option. Bitte erneut eingeben.");
            }

            clearScreen();

        } while (!input.equals("9")); // Die Schleife läuft, bis der Benutzer "4" für "Exit" eingibt

        // Aufräumarbeiten oder Abschlusscode können hier hinzugefügt werden
        System.out.println("Daten gespeichert");
        System.out.println("Die Anwendung wird beendet.");
        scanner.close();
    }

    public static void einzelmodul(String modulname, Student student) {
        boolean fund = true;
        for (Wahlmodul modul : student.getWahlmodule()) {
            // Überprüfe, ob das aktuelle Modul den gesuchten Modulnamen hat
            if (modul.getModulName().equals("BWL")) {
                // Ausgabe nur für das Modul mit dem Namen "test"
                System.out.printf("%-20s|%-40s|%-15s|%-10s|%-10s%n",
                        modul.getModulName(),
                        modul.getBeschreibung(),
                        modul.getCreditpoints(),
                        modul.getNote(),
                        modul.getSemester());

                // Da das gewünschte Modul gefunden wurde, kann die Schleife verlassen werden
                fund = true;
                break;
            }
            fund = false;
        }
        if(!fund) {
            for (Pflichtmodul modul : student.getPflichtmodule()) {
                // Überprüfe, ob das aktuelle Modul den gesuchten Modulnamen hat
                if (modul.getModulName().equals(modulname)) {
                    // Ausgabe nur für das Modul mit dem Namen "test"
                    System.out.printf("%-20s|%-40s|%-15s|%-10s|%-10s%n",
                            modul.getModulName(),
                            modul.getBeschreibung(),
                            modul.getCreditpoints(),
                            modul.getNote(),
                            modul.getSemester());

                    // Da das gewünschte Modul gefunden wurde, kann die Schleife verlassen werden
                    break;
                }
            }
        }
    }

    public static void clearScreen() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                // For Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // For Linux/Unix/Mac or other environments
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            // Handle exceptions here
            e.printStackTrace();
        }
    }
}