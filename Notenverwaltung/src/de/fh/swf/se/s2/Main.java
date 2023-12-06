package de.fh.swf.se.s2;

public class Main {
    public static void main(String[] args) {

        // Erstellen eines Studenten
        Student student = new Student("Max", "Mustermann",342456, "Informatik");

        // Hinzufügen von Pflichtmodulen
        Pflichtmodul pm1 = new Pflichtmodul("Mathematik", 5, "Beschreibung1", 1);
        Pflichtmodul pm2 = new Pflichtmodul("Java 2", 5, "Beschreibung2", 2);
        student.addPflichtmodul(pm1);
        student.addPflichtmodul(pm2);

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

        // Ausgabe der Pflichtmodule und Noten
        System.out.println("Pflichtmodule und Noten:");
        student.getPflichtmodule().forEach(modul -> {
            System.out.println(" - " + modul.getModulName() + " Note: " + modul.getPNote());
        });

        // Ausgabe des Durchschnitts der Pflichtmodule
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
    }
}
