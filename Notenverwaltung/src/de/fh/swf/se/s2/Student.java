package de.fh.swf.se.s2;

import java.util.List;
import java.util.ArrayList;


public class Student {

	public long matrikelnummer;
	private String vorname;
	private String nachname;
	private String studiengang;

	private List<Wahlmodul> wahlModule = new ArrayList<>();
	private List<Pflichtmodul> pflichtModule = new ArrayList<>();
	private Abschluss abschluss;

	/**
	 * 
	 * @param pModulName
	 * @param pCreditpoints
	 */
	public void addPflichtmodul(String pModulName, int pCreditpoints) {
		// TODO - implement Student.addPflichtmodul
	}

	/**
	 * 
	 * @param pflichtmodul
	 * @param pNote
	 */
	public void addNotetoPflichtModul(Pflichtmodul pflichtmodul, double pNote) {
		// TODO - implement Student.addNotetoPflichtModul
		//throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param pflichtmodul
	 * @param pNote
	 */
	public void addNoteToPflichmodul(Pflichtmodul pflichtmodul, double pNote) {
		if (pflichtmodul.addPNote(pNote)) {
			System.out.println("Note " + pNote + " zu Pflichtmodul " + pflichtmodul.pModulName + " hinzugefügt.");
		}
	}

	/**
	 * 
	 * @param wModulName
	 * @param wCredits
	 */
	public void addWahlModul(String wModulName, int wCredits) {
		Wahlmodul wahlmodul = new Wahlmodul(wModulName, wCredits);
		wahlModule.add(wahlmodul);
		System.out.println("Wahlmodul " + wModulName + " mit " + wCredits + " Credits hinzugefügt.");
	}

	/**
	 * 
	 * @param wahlmodul
	 * @param wNote
	 */
	public void addNoteToWahlModul(Wahlmodul wahlmodul, double wNote) {
		if (wahlmodul.addNote(wNote)) {
			System.out.println("Note " + wNote + " zu Wahlmodul " + wahlmodul.wModulName + " hinzugefügt.");
		}
	}

	/**
	 * 
	 * @param pflichtmodul
	 */
	public double berechnePflichtmodulDurchschnitt(int pflichtmodul) {
		// TODO - implement Student.berechnePflichtmodulDurchschnitt
		//throw new UnsupportedOperationException();
		return pflichtmodul;
	}

	/**
	 * 
	 * @param wahlmodul
	 */
	public double berechneWahlModulDurchschnitt(int wahlmodul) {

        return wahlmodul;
    }

	/**
	 * 
	 * @param thema
	 * @param gewichtungArbeit
	 * @param gewichtungKolloquium
	 */
	public void addAbschluss(String thema, double gewichtungArbeit, double gewichtungKolloquium) {
		// TODO - implement Student.addAbschluss
		//throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param thema
	 * @param noteArbeit
	 */
	public void addNoteToAbschlussA(String thema, double noteArbeit) {
		// TODO - implement Student.addNoteToAbschlussA
		//throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param abschluss
	 * @param noteArbeit
	 */
	public void addNoteToAbschlussA(Abschluss abschluss, double noteArbeit) {
		// TODO - implement Student.addNoteToAbschlussA
		//throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param thema
	 * @param noteKolloquium
	 */
	public void addNoteToAbschlussK(Abschluss thema, double noteKolloquium) {

	}

	/**
	 * 
	 * @param abschluss
	 * @param noteKolloquium
	 */
	public void addnoteToAbschlussK(Abschluss abschluss, double noteKolloquium) {
		// TODO - implement Student.addnoteToAbschlussK
		//throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param pModulName
	 * @param pNote
	 */
	public void addNoteToPflichmodul(String pModulName, double pNote) {
		// TODO - implement Student.addNoteToPflichmodul
		//throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param pflichtmodul
	 */
	public void addPflichmodul(Pflichtmodul pflichtmodul) {
		pflichtModule.add(pflichtmodul);
		System.out.println("Pflichtmodul " + pflichtmodul.pModulName + " hinzugefügt.");
	}

	/**
	 * 
	 * @param wahlmodul
	 */
	public void addWahlModul(Wahlmodul wahlmodul) {
		wahlModule.add(wahlmodul);
		System.out.println("Wahlmodul " + wahlmodul.wModulName + " hinzugefügt.");
	}

	/**
	 * @param wahlmodul
	 * @param v
	 */
	public void addNoteToWahlmodul(Wahlmodul wahlmodul, double note) {

	}

	/**
	 * 
	 * @param abschluss
	 */
	public void addAbschluss(Abschluss abschluss) {
		this.abschluss = abschluss;
		System.out.println("Abschluss hinzugefügt.");
	}

}