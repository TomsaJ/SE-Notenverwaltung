package de.fh.swf.se.s2;

public class Wahlmodul {

	public String wModulName;
	public int wCreditpoints;
	public double wNote;

	public Wahlmodul(String wModulName, int wCreditpoints) {
		this.wModulName = wModulName;
		this.wCreditpoints = wCreditpoints;
	}

	/**
	 * 
	 * @param pModulname
	 * @param pCreditPoints
	 */
	public void wModulname(String pModulname, int pCreditPoints) {
		// TODO - implement Wahlmodul.wModulname
		//throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param pNote
	 */
	public boolean addNote(double note) {
		if (note >= 1.0 && note <= 5.0) {
			this.wNote = note;
			return true;
		} else {
			System.out.println("Ungültige Note. Die Note muss zwischen 1.0 und 5.0 liegen.");
			return false;
		}
	}

	/**
	 * 
	 * @param wModulName
	 */
	public void wModulname(String wModulName) {
		// TODO - implement Wahlmodul.wModulname
		//throw new UnsupportedOperationException();
	}

}