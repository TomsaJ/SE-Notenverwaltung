package de.fh.swf.se.s2.test;

import de.fh.swf.se.s2.Abschluss;
import de.fh.swf.se.s2.Pflichtmodul;
import de.fh.swf.se.s2.Student;
import de.fh.swf.se.s2.Wahlmodul;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {
    @Test
    public void addNewPflichtmodul() {
        Student student = new Student("Test", "Test", 23344, "Test", 0);
        Pflichtmodul pflichtmodul = new Pflichtmodul("Test",2,"Test",2);
        assertTrue(student.addPflichtmodul(pflichtmodul));
    }
    @Test
    public void addSameNewPflichtmodul() {
        Student student = new Student("Test", "Test", 23344, "Test", 0);
        Pflichtmodul pflichtmodul = new Pflichtmodul("Test",2,"Test",2);
        student.addPflichtmodul(pflichtmodul);
        Pflichtmodul pflichtmodul2 = new Pflichtmodul("Test",2,"Test",2);
        assertFalse(student.addPflichtmodul(pflichtmodul2));
    }
    @Test
    public void addNewWahlmodul() {
        Student student = new Student("Test", "Test", 23344, "Test", 0);
        Wahlmodul wm = new Wahlmodul("Test",2,"Test",2);
        assertTrue(student.addWahlmodul(wm));
    }
    @Test
    public void addSameNewWahlmodul() {
        Student student = new Student("Test", "Test", 23344, "Test", 0);
        Wahlmodul wm = new Wahlmodul("Test",2,"Test",2);
        student.addWahlmodul(wm);
        Wahlmodul wm2 = new Wahlmodul("Test",2,"Test",2);
        assertFalse(student.addWahlmodul(wm2));
    }



    @Test
    public void hasTheStudentallCreditspointafterabschluss() {
        Student student = new Student("Test", "Test", 23344, "Test", 0);
        Abschluss abschluss = new Abschluss("Test",0.3,0.3);
        student.addAbschluss(abschluss);
        student.addNoteToAbschlussA(1.3);
        student.addNoteToAbschlussK(1.3);
        assertEquals(180, student.getCreditpoints());
    }
    @Test
    public void fullCreditAfterANoteIsFive() {
        Student student = new Student("Test", "Test", 23344, "Test", 0);
        Abschluss abschluss = new Abschluss("Test",0.3,0.3);
        student.addAbschluss(abschluss);
        student.addNoteToAbschlussA(5.0);
        student.addNoteToAbschlussK(1.3);
        assertEquals(0, student.getCreditpoints());
    }
    @Test
    public void fullCreditAfterKNoteIsFive() {
        Student student = new Student("Test", "Test", 23344, "Test", 0);
        Abschluss abschluss = new Abschluss("Test",0.3,0.3);
        student.addAbschluss(abschluss);
        student.addNoteToAbschlussA(1.3);
        student.addNoteToAbschlussK(5.0);
        assertEquals(0, student.getCreditpoints());
    }
    @Test
    public void fullCreditAfterKNoteAndANoteAreFive() {
        Student student = new Student("Test", "Test", 23344, "Test", 0);
        Abschluss abschluss = new Abschluss("Test",0.3,0.3);
        student.addAbschluss(abschluss);
        student.addNoteToAbschlussA(5.0);
        student.addNoteToAbschlussK(5.0);
        assertEquals(0, student.getCreditpoints());
    }

}
