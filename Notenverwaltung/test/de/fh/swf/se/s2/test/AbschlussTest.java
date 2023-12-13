package de.fh.swf.se.s2.test;
import de.fh.swf.se.s2.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AbschlussTest {
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
