package de.fh.swf.se.s2;

import java.util.ArrayList;
import java.util.List;

public class Student {


	private long matrikelnummer;
	private String vorname;
	private String nachname;
	private String studiengang;
	private List<Pflichtmodul> pflichtmodule;
	private List<Wahlmodul> wahlmodule;
	private Abschluss abschluss;

	// Konstruktor für Student
	public Student(String vorname, String nachname, long matrikelnummer , String studiengang) {
		this.vorname = vorname;
		this.nachname = nachname;
		this.matrikelnummer = matrikelnummer;
		this.studiengang = studiengang;
		this.pflichtmodule = new ArrayList<>();
		this.wahlmodule = new ArrayList<>();
	}

	/**
	 * 
	 * @param pModulName
	 * @param pCreditpoints
	 * @param pBeschreibung
	 * @param pSemester
	 */
	public void addPflichtmodul(String pModulName, int pCreditpoints, String pBeschreibung, int pSemester) {
		// TODO - implement Student.addPflichtmodul
		System.out.println("Modul: " + pModulName + " erstellt");
	}

	/**
	 * 
	 * @param wahlmodul
	 * @param pNote
	 */
	public void addNotetoPflichtModul(Pflichtmodul wahlmodul, double pNote) {
		// TODO - implement Student.addNotetoPflichtModul
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param pflichtmodul
	 * @param pNote
	 */
	public void addNoteToPflichmodul(Pflichtmodul pflichtmodul, double pNote) {
		// TODO - implement Student.addNoteToPflichmodul
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param wModulName
	 * @param wCredits
	 * @param wBeschreibung
	 * @param wSemester
	 */
	public void addWahlmodul(String wModulName, int wCredits, String wBeschreibung, int wSemester) {
		// TODO - implement Student.addWahlModul
		System.out.println("Modul: " + wModulName + " erstellt");
	}

	/**
	 * 
	 * @param wModulName
	 * @param wNote
	 */
	public void addNoteToWahlModul(String wModulName, double wNote) {
		// TODO - implement Student.addNoteToWahlModul
		System.out.println("Note " + wNote + " zum Wahlmodul " + wModulName + " hinzugefügt.");
	}

	/**
	 * 
	 * @param
	 */
	public double berechnePflichtmodulDurchschnitt() {
		if (pflichtmodule.isEmpty()) {
			return 0; // Keine Pflichtmodule vorhanden
		}

		double sum = 0.0;
		for (Pflichtmodul pflichtmodul : pflichtmodule) {
			sum += pflichtmodul.getPNote();
		}

		return sum / pflichtmodule.size();
	}


	/**
	 * 
	 * @param
	 */
	public double berechneWahlModulDurchschnitt() {
		if (wahlmodule.isEmpty()) {
			return 0; // Keine Wahlmodule vorhanden
		}

		double sum = 0.0;
		for (Wahlmodul wahlmodul : wahlmodule) {
			sum += wahlmodul.getNote();
		}

		return sum / wahlmodule.size();
	}


	/**
	 * 
	 * @param thema
	 * @param gewichtungArbeit
	 * @param gewichtungKolloquium
	 */
	public void addAbschluss(String thema, double gewichtungArbeit, double gewichtungKolloquium) {
		// TODO - implement Student.addAbschluss
		System.out.println("Das Thema ist: " +thema  + " Die Gewichtung(Arbeit): " + gewichtungArbeit+" Die Gewichtung(Arbeit): " + gewichtungKolloquium);
	}

	/**
	 * 
	 * @param thema
	 * @param noteArbeit
	 */
	public void addNoteToAbschlussA(String thema, double noteArbeit) {
		// TODO - implement Student.addNoteToAbschlussA
		System.out.println("Note der Arbeit: " + noteArbeit );
	}

	/**
	 * 
	 * @param abschluss
	 * @param noteArbeit
	 */
	public void addNoteToAbschlussA(Abschluss abschluss, double noteArbeit) {
		// TODO - implement Student.addNoteToAbschlussA
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param thema
	 * @param noteKolloquium
	 */
	public void addNoteToAbschlussK(String thema, double noteKolloquium) {
		// TODO - implement Student.addNoteToAbschlussK
		System.out.println("Note des Kolloquiums: " + noteKolloquium);
	}

	/**
	 * 
	 * @param abschluss
	 * @param noteKolloquium
	 */
	public void addnoteToAbschlussK(Abschluss abschluss, double noteKolloquium) {
		// TODO - implement Student.addnoteToAbschlussK
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param pModulName
	 * @param pNote
	 */
	public void addNoteToPflichtModul(String pModulName, double pNote) {
		// TODO - implement Student.addNoteToPflichmodul
		System.out.println("Note " + pNote + " zum Wahlmodul " + pModulName + " hinzugefügt.");
	}

	/**
	 * 
	 * @param pflichtmodul
	 */
	public void addPflichtmodul(Pflichtmodul pflichtmodul) {
		pflichtmodule.add(pflichtmodul);
	}


	/**
	 * 
	 * @param wahlmodul
	 */
	public void addWahlmodul(Wahlmodul wahlmodul) {
		wahlmodule.add(wahlmodul);
	}


	/**
	 * 
	 * @param wahlmodul
	 */
	public void addNoteToWahlmodul(Wahlmodul wahlmodul) {
		// TODO - implement Student.addNoteToWahlmodul
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param abschluss
	 */
	public void addAbschluss(Abschluss abschluss) {
		this.abschluss = abschluss;
	}

	public void setAbschluss(Abschluss abschluss) {
		this.abschluss = abschluss;
	}

	public void addNoteToAbschlussA(double noteArbeit) {
		abschluss.addNoteArbeit(noteArbeit);
	}

	public void addNoteToAbschlussK(double noteKolloquium) {
		abschluss.addNoteKolloquium(noteKolloquium);
	}

	// Getter-Methoden für Matrikelnummer, Vorname, Nachname und Studiengang
	public long getMatrikelnummer() {
		return matrikelnummer;
	}

	public String getVorname() {
		return vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public String getStudiengang() {
		return studiengang;
	}

	// Getter-Methoden für Pflicht- und Wahlmodule sowie Abschluss
	public List<Pflichtmodul> getPflichtmodule() {
		return pflichtmodule;
	}

	public List<Wahlmodul> getWahlmodule() {
		return wahlmodule;
	}

	public Abschluss getAbschluss() {
		return abschluss;
	}


}