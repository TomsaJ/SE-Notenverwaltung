package de.fh.swf.se.s2;

public class Wahlmodul {

	private String wModulname;
	private int wCreditpoints;
	private double wNote;
	private String wBeschreibung;
	private int wSemester;

	public Wahlmodul(String modulname, int creditpoints, String beschreibung, int semester) {
		this.wModulname = modulname;
		this.wCreditpoints = creditpoints;
		this.wBeschreibung= beschreibung;
		this.wSemester = semester;
	}


	/**
	 *
	 * @param wModulname
	 * @param wCreditPoints
	 * @param wBeschreibung
	 * @param wSemester
	 */
	public void wModulname(String wModulname, int wCreditPoints, String wBeschreibung, int wSemester) {
		// TODO - implement Wahlmodul.wModulname
		throw new UnsupportedOperationException();
	}

	/**
	 *
	 * @param wNote
	 */
	public boolean addWNote(double wNote) {
		this.wNote = wNote;
		return true;
	}




	/**
	 *
	 * @param wModulName
	 */
	public void wModulname(String wModulName) {
		// TODO - implement Wahlmodul.wModulname
		throw new UnsupportedOperationException();
	}

	public void addNote(double note) {
		this.wNote = note;
	}

	// Getter-Methode für die Note des Wahlmoduls
	public double getNote() {
		return wNote;
	}

	public String getModulName() {
		return wModulname;
	}
}