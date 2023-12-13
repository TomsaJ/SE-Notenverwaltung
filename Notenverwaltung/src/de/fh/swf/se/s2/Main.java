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
        clearScreen();
        // Erstellen eines Studenten
        System.out.println("Nachname:");

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
                    int creditpoints = Integer.parseInt(fields[4]);


                    // Rufen Sie Ihre Methode auf, um die Daten zu verarbeiten
                    if(Objects.equals(nachname, lnachname)) {
                        student = new Student (vorname,nachname,matrikelnummer,studiengang,creditpoints);
                    }

                } else {
                    System.out.println("Warning: Insufficient fields in line");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        clearScreen();
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
            System.out.printf("%-50s|%-20s|%-15s|%-15s%n",
                    "Student",
                    "Matrikelnummer",
                    "Studiengang",
                    "Gesamte Creditpoints"
            );
            System.out.printf("%-25s%-25s|%-20s|%-15s|%-15s%n",
                    student.getVorname(), // String
                    student.getNachname(), // String
                    student.getMatrikelnummer(), // int
                    student.getStudiengang(), // String
                    student.getCreditpoints()
            );
            System.out.println("\n-----------------------------------------------------------------------------------------------------------\n");
            System.out.println("\nPflichtmodule und Noten:\n");
            System.out.printf("%-20s|%-40s|%-15s|%-15s%n", "Modulname", "Beschreibung", "Semester", "Status");
            System.out.println("-----------------------------------------------------------------------------------------------------------");
            student.getPflichtmodule().forEach(modul -> {
                String status; // Variable to store the status

                if (modul.getNote() == 0.0 || (modul.getNote() == 5.0 && modul.getVersuch() > 3)) {
                    status = "Offen";
                } else if (modul.getNote() != 0.0 && modul.getNote() != 5.0) {
                    status = "bestanden";
                } else {
                    // Set a default value or handle other cases
                    status = "Entgültig nicht bestanden";
                }
                System.out.printf("%-20s|%-40s|%-15s|%-15s%n",
                        modul.getModulName(),
                        modul.getBeschreibung(),
                        modul.getSemester(),
                        status);
            });
            System.out.println("\nDurchschnitt Pflichtmodule: " + student.berechnePflichtmodulDurchschnitt());
            System.out.println("\n-----------------------------------------------------------------------------------------------------------\n");

            System.out.println("\nWahlmodule und Noten:\n");
            System.out.printf("%-20s|%-40s|%-15s|%-15s%n", "Modulname", "Beschreibung", "Semester", "Status");
            System.out.println("-----------------------------------------------------------------------------------------------------------");
            student.getWahlmodule().forEach(modul -> {
                String status; // Variable to store the status

                if (modul.getNote() == 0.0 || (modul.getNote() == 5.0 && modul.getVersuch() < 3)) {
                    status = "Offen";
                } else if (modul.getNote() != 0.0 && modul.getNote() != 5.0) {
                    status = "bestanden";
                } else {
                    // Set a default value or handle other cases
                    status = "Entgültig nicht bestanden";
                }
                System.out.printf("%-20s|%-40s|%-15s|%-15s%n",
                        modul.getModulName(),
                        modul.getBeschreibung(),
                        modul.getSemester(),
                status);
            });

            System.out.println("\nDurchschnitt Wahlmodule: " + student.berechneWahlModulDurchschnitt());
            System.out.println("\n-----------------------------------------------------------------------------------------------------------\n");
            System.out.println("\nAbschluss:");
            System.out.printf("%-20s|%-40s|%-20s%n","Thema","Note Arbeit","Note Kolloquium");
            System.out.println("-----------------------------------------------------------------------------------------------------------");
            student.getAbschluss().forEach(abschluss -> {
                System.out.printf("%-20s|%-40s|%-20s%n",
                        abschluss.getThema(),
                        abschluss.getNoteArbeit(),
                        abschluss.getNoteArbeit());
            });


            System.out.println("-----------------------------------------------------------------------------------------------------------");


            // Menü anzeigen
            System.out.println("\n1. Neues Pflichtmodul hinzufügen");
            System.out.println("2. Neues Wahlmodul hinzufügen");
            System.out.println("3. Modul Detail");
            System.out.println("4. Offene Fächer");
            System.out.println("6. Abschluss");

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
                        while (credit <= 0 && credit >= 30)
                        {
                            System.out.println("Creditpoints");
                            credit = Integer.parseInt(scanner.nextLine());
                        }
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
                    do {
                        System.out.println("Modulname");
                        name = scanner.nextLine();
                        System.out.println("Creditpoints");
                        credit = Integer.parseInt(scanner.nextLine());
                        while (credit <= 0 && credit >= 30)
                        {
                            System.out.println("Creditpoints");
                            credit = Integer.parseInt(scanner.nextLine());
                        }
                        System.out.println("Beschreibung");
                        beschreibung = scanner.nextLine();
                        System.out.println("Semester");
                        semester = Integer.parseInt(scanner.nextLine());
                        System.out.println("Passt alles? Ja/Nein");
                        input = scanner.nextLine();
                    } while (!input.equals("Ja"));
                    Wahlmodul wm = new Wahlmodul(name, credit, beschreibung, semester);
                    student.addWahlmodul(wm);
                    // Hier können Sie den Code für Option 1 hinzufügen
                    // Hier können Sie den Code für Option 3 hinzufügen
                    break;
                case "3":
                    clearScreen();
                    System.out.println("Modul eingeben");
                    modulname = scanner.nextLine();
                    clearScreen();
                    while (true){
                    String art = einzelmodul(modulname, student);
                    System.out.printf("\n%-50s%-50s%-50s%n", "1. Noten für "+ modulname +  " eintragen", "2. Bearbeiten", "3. Verlassen");
                    // Benutzereingabe lesen
                    input = scanner.nextLine();
                        clearScreen();
                    if (input.equals("1")) {
                        System.out.println("\nNote für "+ modulname +" eingeben");
                        note = Double.parseDouble(scanner.nextLine());
                        if(Objects.equals(art, "Pflicht")){
                            student.addNoteToPflichmodul(modulname, note);
                        }else if(Objects.equals(art, "Wahl")){
                            student.addNoteToWahlModul(modulname, note);
                        }
                    }else if (input.equals("2")) {

                            System.out.println("\nBearbeitung von "+ modulname );
                            if(Objects.equals(art, "Pflicht")){
                                einzelmodul(modulname,student);
                                System.out.println("\nBei keiner Änderung, vorherigen Wert eingeben" );
                                System.out.println("Modulname");
                                name = scanner.nextLine();
                                System.out.println("Creditpoints");
                                credit = Integer.parseInt(scanner.nextLine());
                                System.out.println("Beschreibung");
                                beschreibung = scanner.nextLine();
                                System.out.println("Semester");
                                semester = Integer.parseInt(scanner.nextLine());
                                student.changePflichtmodul(modulname,name,credit,beschreibung,semester);
                                modulname = name;
                            }else if(Objects.equals(art, "Wahl")){
                                einzelmodul(modulname,student);
                                System.out.println("\nBei keiner Änderung, vorherigen Wert eingeben" );
                                System.out.println("Modulname");
                                name = scanner.nextLine();
                                System.out.println("Creditpoints");
                                credit = Integer.parseInt(scanner.nextLine());
                                System.out.println("Beschreibung");
                                beschreibung = scanner.nextLine();
                                System.out.println("Semester");
                                semester = Integer.parseInt(scanner.nextLine());
                                student.changeWahlmodul(modulname,name,credit,beschreibung,semester);
                                modulname = name;
                            }
                        }else{break;}}
                    // Hier können Sie den Code für Option 2 hinzufügen
                    break;
                case "4":
                    do {
                        System.out.println("\nOffene Fächer:");
                        System.out.printf("%-20s|%-40s|%-15s|%-15s%n", "Modulname", "Beschreibung", "Creditpoints", "Semester");
                        System.out.println("-----------------------------------------------------------------------------------------------------------");
                        student.getPflichtmodule().forEach(modul -> {
                            if (modul.getNote() == 0.0) {
                                System.out.printf("%-20s|%-40s|%-15s|%-15s%n",
                                        modul.getModulName(),
                                        modul.getBeschreibung(),
                                        modul.getCreditpoints(),
                                        modul.getSemester());
                            }
                        });
                        student.getWahlmodule().forEach(modul -> {
                            if (modul.getNote() == 0.0) {
                                System.out.printf("%-20s|%-40s|%-15s|%-15s%n",
                                        modul.getModulName(),
                                        modul.getBeschreibung(),
                                        modul.getCreditpoints(),
                                        modul.getSemester());
                            }
                        });
                        System.out.println("\n1. Verlassen");
                        // Benutzereingabe lesen
                        input = scanner.nextLine();
                    }while (!Objects.equals(input, "1"));
                    break;
                case "6":
                    abschluss(student);
                    break;
                case "9":
                    student.save();
                    break;
                default:
                    System.out.println("Ungültige Option. Bitte erneut eingeben.");
            }

            clearScreen();

        } while (!input.equals("9")); // Die Schleife läuft, bis der Benutzer "9" für "Exit" eingibt

        // Aufräumarbeiten oder Abschlusscode können hier hinzugefügt werden
        System.out.println("Daten gespeichert");
        System.out.println("Die Anwendung wird beendet.");
        scanner.close();
    }

    private static void abschluss(Student student) {
        String input;
        do {
            clearScreen();
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nAbschluss:");
            System.out.printf("|%-20s|%-20s|%-20s|%-20s|%-25s|%-15s%n", "Thema", "Note Arbeit","Gewichtung Arbeit", "Note Kolloquium", "Gewichtung Kolloquium", "Versuch");
            System.out.println("------------------------------------------------------------------------------------------------------------------------");
            student.getAbschluss().forEach(abschluss -> {
                System.out.printf("\n|%-20s|%-20s|%-20s|%-20s|%-25s|%-15s%n",
                        abschluss.getThema(),
                        abschluss.getNoteArbeit(),
                        abschluss.getGewichtungArbeit(),
                        abschluss.getNoteKolloquium(),
                abschluss.getGewichtungKolloquium(),
                abschluss.getVersuch());
            });
            System.out.println("------------------------------------------------------------------------------------------------------------------------");
            System.out.println("\n1. Abschluss erstellen");
            System.out.println("2. Noten eintragen (Arbeit/Kolloquium)");
            System.out.println("3. Abschluss bearbeiten");
            System.out.println("9. Exit");
            System.out.print("Bitte wählen Sie eine Option: ");
            input = scanner.nextLine();
            switch(input){
                case "1":
                    if(student.getAbschluss().isEmpty())
                    {
                        System.out.println("Thema:");
                        String thema = scanner.nextLine();
                        System.out.println("Gewichtung Arbeit");
                        double arbeit = Double.parseDouble(scanner.nextLine());
                        System.out.println("Gewichtung Kolloquium");
                        double kolloquium = Double.parseDouble(scanner.nextLine());
                        Abschluss abschluss1 = new Abschluss(thema, arbeit, kolloquium);
                        student.addAbschluss(abschluss1);
                    }else{
                        System.out.println("Ein Abschluss ist schon vorhanden");
                    }
                    break;
                case "2":
                    double[] mNote = {1.0, 1.3, 1.7, 2.0, 2.3, 2.7, 3.0 ,3.3, 3.7, 4.0,5.0};
                    boolean arbeit = false;
                    boolean kollo = false ;
                    if(student.getAbschluss()!=null) {
                        System.out.println("Note Arbeit:");
                        double noteA = Double.parseDouble(scanner.nextLine());

                        System.out.println("Kolloquium Arbeit:");
                        double noteK = Double.parseDouble(scanner.nextLine());

                        if ((student.getNoteA() == 0.0 && student.getVersuchA() != 2) || (student.getNoteA() == 5.0 && student.getVersuchA() != 2) || (student.getNoteK() == 0.0 && student.getVersuchA() != 2) || (student.getNoteK() == 5.0 && student.getVersuchA() != 2)) {
                            if (noteA >= 1.0 && noteA <= 5.0 && noteK >= 1.0 && noteK <= 5.0) {
                                for (int i = 0; i < 11; i++) {
                                    if (mNote[i] == noteA) {
                                        arbeit = true;
                                    }
                                    if (mNote[i] == noteK) {
                                        kollo = true;
                                    }
                                }
                                if(arbeit && kollo)
                                {
                                    student.addNoteToAbschlussA(noteA);
                                    student.addNoteToAbschlussK(noteK);
                                }else{
                                    System.out.println("Einer der Note passt nicht dem Noten Schema");
                                    try {
                                        // Warte für 2 Sekunden (2000 Millisekunden)
                                        Thread.sleep(2000);
                                    } catch (InterruptedException e) {
                                        // Handle die Interrupted-Exception, falls sie auftritt
                                        e.printStackTrace();
                                    }
                                    break;
                                }

                            }
                        } else {
                            System.out.println("Maximale Anzahl der Versuche erreicht");
                        }
                        break;
                    }
                case "3":
                    if(student.getAbschluss()!=null)
                    {
                        System.out.println("\nBei keiner Änderung, vorherigen Wert eingeben" );
                        System.out.println("Thema");
                        String thema = scanner.nextLine();
                        System.out.println("Gewichtung Arbeit");
                        double gewichtungA = Double.parseDouble(scanner.nextLine());
                        System.out.println("Gewichtung Kolloquium");
                        double gewichtungK = Double.parseDouble(scanner.nextLine());
                        student.changeAbschluss(thema, gewichtungA,gewichtungK);
                    }else{
                        System.out.println("Kein Abschluss vorhanden");
                    }
                    break;
            }

        } while (!input.equals("9"));

    }

    public static String einzelmodul(String modulname, Student student) {

        String art = null;
        boolean fund = false;
        System.out.printf("\n%-20s|%-40s|%-15s|%-10s|%-10s|%-8s%n", "Modulname", "Beschreibung", "Creditpoints", "Note", "Semester", "Versuch");
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        for (Wahlmodul modul : student.getWahlmodule()) {
            // Überprüfe, ob das aktuelle Modul den gesuchten Modulnamen hat
            if (modul.getModulName().equals(modulname)) {
                // Ausgabe nur für das Modul mit dem Namen "test"

                System.out.printf("%-20s|%-40s|%-15s|%-10s|%-10s|%-8s%n",
                        modul.getModulName(),
                        modul.getBeschreibung(),
                        modul.getCreditpoints(),
                        modul.getNote(),
                        modul.getSemester(),
                        modul.getVersuch());

                // Da das gewünschte Modul gefunden wurde, kann die Schleife verlassen werden
                art = "Wahl";
                fund = true;
                break;
            }

        }
        if(!fund) {
            for (Pflichtmodul modul : student.getPflichtmodule()) {
                // Überprüfe, ob das aktuelle Modul den gesuchten Modulnamen hat
                if (modul.getModulName().equals(modulname)) {
                    // Ausgabe nur für das Modul mit dem Namen "test"
                    System.out.printf("%-20s|%-40s|%-15s|%-10s|%-10s|%-8s%n",
                            modul.getModulName(),
                            modul.getBeschreibung(),
                            modul.getCreditpoints(),
                            modul.getNote(),
                            modul.getSemester(),
                            modul.getVersuch());

                    // Da das gewünschte Modul gefunden wurde, kann die Schleife verlassen werden
                    art = "Pflicht";
                    fund = true;
                    break;
                }

            }
        }
        if (!fund){
            System.out.println("Kein Modul mit dem Namen " + modulname + " gefunden!");
        }
        return art;
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