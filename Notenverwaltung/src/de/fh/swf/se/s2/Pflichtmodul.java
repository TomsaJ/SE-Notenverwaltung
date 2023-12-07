package de.fh.swf.se.s2;

public class Pflichtmodul {

	public String pModulName;
	public int pCreditpoints;
	public double pNote;
	private String pBeschreibung;
	private int pSemester;

	public Pflichtmodul(String modulName, int creditpoints, String beschreibung, int semester) {
		this.pModulName = modulName;
		this.pCreditpoints = creditpoints;
		this.pBeschreibung = beschreibung;
		this.pSemester = semester;
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
		// TODO - implement Pflichtmodul.pModul
		throw new UnsupportedOperationException();
	}



	// Getter-Methode für Modulnamen
	public String getModulName() {
		return pModulName;
	}

	// Getter-Methode für die Note des Pflichtmoduls
	public double getPNote() {
		return pNote;
	}

}