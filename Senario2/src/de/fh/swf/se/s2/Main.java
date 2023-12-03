package de.fh.swf.se.s2;

public class Main {

        public static void main(String[] args) {
            // Erstelle einen Studenten
            Student student = new Student();
            student.addPflichtmodul("Mathematik", 5);
            student.addWahlModul("Informatik", 5);

            // Erstelle Pflichtmodule und füge sie dem Studenten hinzu
            Pflichtmodul pflichtmodul1 = new Pflichtmodul("Programmieren", 10);
            Pflichtmodul pflichtmodul2 = new Pflichtmodul("Datenbanken", 8);
            student.addPflichmodul(pflichtmodul1);
            student.addPflichmodul(pflichtmodul2);

            // Erstelle Wahlmodule und füge sie dem Studenten hinzu
            Wahlmodul wahlmodul1 = new Wahlmodul("Webentwicklung", 6);
            Wahlmodul wahlmodul2 = new Wahlmodul("Künstliche Intelligenz", 7);
            student.addWahlModul(wahlmodul1);
            student.addWahlModul(wahlmodul2);

            // Erstelle einen Abschluss und füge ihn dem Studenten hinzu
            Abschluss abschluss = new Abschluss();
            student.addAbschluss(abschluss);

            // Füge Noten zu Pflichtmodulen, Wahlmodulen und dem Abschluss hinzu
            student.addNoteToPflichmodul(pflichtmodul1, 4.0);
            student.addNoteToWahlmodul(wahlmodul1, 3.5);
            student.addNoteToAbschlussA(abschluss, 3.7);
            student.addNoteToAbschlussK(abschluss, 4.2);

            // Berechne Durchschnittsnoten für Pflichtmodule und Wahlmodule
            double pflichtDurchschnitt = student.berechnePflichtmodulDurchschnitt(3);
            double wahlDurchschnitt = student.berechneWahlModulDurchschnitt(3);

            // Ausgabe der Durchschnittsnoten
            System.out.println("Durchschnittsnote Pflichtmodule: " + pflichtDurchschnitt);
            System.out.println("Durchschnittsnote Wahlmodule: " + wahlDurchschnitt);
        }
    }

