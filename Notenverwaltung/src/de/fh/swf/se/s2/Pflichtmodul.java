package de.fh.swf.se.s2;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.*;
public class Pflichtmodul {

	private String pModulName;
	private int pCreditpoints;
	private double pNote;
	private String pBeschreibung;
	private int pSemester;

	public Pflichtmodul(String modulName, int creditpoints, String beschreibung, int semester) {
		this.pModulName = modulName;
		this.pCreditpoints = creditpoints;
		this.pBeschreibung = beschreibung;
		this.pSemester = semester;
		//pModul(modulName,creditpoints,beschreibung,semester);
	}

	/**
	 * 
	 * @param pModulName
	 */
	public void pModul(String pModulName) {
		// TODO - implement Pflichtmodul.pModul
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param pNote
	 */
	public boolean addPNote(double pNote) {
		this.pNote = pNote;
		return true;
	}


	/**
	 * 
	 * @param pModulName
	 * @param pCreditPoints
	 * @param pBeschreibung
	 * @param pSemester
	 */
	public void pModul(String pModulName, int pCreditPoints, String pBeschreibung, int pSemester) {

	}



	// Getter-Methode für Modulnamen
	public String getModulName() {
		return pModulName;
	}

	// Getter-Methode für die Note des Pflichtmoduls
	public double getNote() {
		return pNote;
	}
	public int getCreditpoints() {
		return pCreditpoints;
	}
	public String getBeschreibung() {
		return pBeschreibung;
	}

	// Getter-Methode für die Note des Pflichtmoduls
	public int getSemester() {
		return pSemester;
	}

}