package de.fh.swf.se.s2.test;
import de.fh.swf.se.s2.Pflichtmodul;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PflichtmodulTest {

    Pflichtmodul testPflichmodul = new Pflichtmodul("Test",5,"Test",1);

    @Test
    public void testAddPNote() {

        // Teste mit gültigen Parametern
        assertTrue(testPflichmodul.addPNote(3.0, "n"));
        assertEquals(3.0, testPflichmodul.getNote()); // Annahme: getPNote-Methode gibt die aktuelle pNote zurück

        // Teste mit ungültiger Note
        assertFalse(testPflichmodul.addPNote(6.0, "n"));
        assertFalse(testPflichmodul.addPNote(0.5, "n"));

        // Teste mit ungültigem Versuch
        assertFalse(testPflichmodul.addPNote(4.0, "x"));

        // Teste mit gültigem Versuch und maximalen Versuchen
        assertFalse(testPflichmodul.addPNote(2.0, "n"));
        assertFalse(testPflichmodul.addPNote(4.0, "n"));
        assertFalse(testPflichmodul.addPNote(1.0, "n"));
        assertFalse(testPflichmodul.addPNote(3.0, "n")); // Der vierte Versuch sollte fehlschlagen



    }




}