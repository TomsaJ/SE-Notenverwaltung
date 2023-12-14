package de.fh.swf.se.s2.test;
import de.fh.swf.se.s2.*;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;


public class PflichtmodulTest {


    @Test
    public void testAddPNoteInvalidVersuch() {
        Pflichtmodul testPflichtmodul = new Pflichtmodul("Test",2,"Test",2); // Annahme: Pflichtmodul ist der Name deiner Klasse

        // Testfälle für ungültige Versuche
        assertFalse(testPflichtmodul.addPNote(1.0, "x"));
        assertFalse(testPflichtmodul.addPNote(1.3, "x"));
        assertFalse(testPflichtmodul.addPNote(1.7, "x"));
        // und so weiter...
    }

    @Test
    public void testAddPNoteCorrect() {
        Pflichtmodul testPflichtmodul = new Pflichtmodul("Test",2,"Test",2); // Annahme: Pflichtmodul ist der Name deiner Klasse

        // Testfälle für gültige Versuche
        assertTrue(testPflichtmodul.addPNote(3.0, "n"));
        // und so weiter...
    }

    @Test
    public void testAddPNoteInvalidNote() {
        Pflichtmodul testPflichtmodul = new Pflichtmodul("Test",2,"Test",2); // Annahme: Pflichtmodul ist der Name deiner Klasse

        // Testfälle für ungültige Noten
        assertFalse(testPflichtmodul.addPNote(6.0, "n"));
        assertFalse(testPflichtmodul.addPNote(0.5, "n"));
        // und so weiter...
    }

    @Test
    public void testAddPNoteInvalidVersuchAndNote() {
        Pflichtmodul testPflichtmodul = new Pflichtmodul("Test",2,"Test",2); // Annahme: Pflichtmodul ist der Name deiner Klasse

        // Testfälle für ungültige Versuche und Noten
        assertFalse(testPflichtmodul.addPNote(1.0, "x"));
        assertFalse(testPflichtmodul.addPNote(1.3, "x"));
        assertFalse(testPflichtmodul.addPNote(6.0, "x"));
        // und so weiter...
    }

    @Test
    public void testAusgabeZuHoch() {

        // Erfasse die System.out-Ausgabe
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        Pflichtmodul testPflichtmodul = new Pflichtmodul("Test",200,"Test",2);

        // Setze die System.out-Ausgabe zurück
        System.setOut(originalOut);

        // Überprüfe die erwartete Ausgabe
        assertEquals("Creditpoints sind zu hoch oder zu niedrig" + System.lineSeparator(), outputStream.toString());
    }
    @Test
    public void testAusgabeZuNiedrig() {

        // Erfasse die System.out-Ausgabe
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        Pflichtmodul testPflichtmodul = new Pflichtmodul("Test",-2,"Test",2);

        // Setze die System.out-Ausgabe zurück
        System.setOut(originalOut);

        // Überprüfe die erwartete Ausgabe
        assertEquals("Creditpoints sind zu hoch oder zu niedrig" + System.lineSeparator(), outputStream.toString());
    }

}
