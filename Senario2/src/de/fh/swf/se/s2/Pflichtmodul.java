package de.fh.swf.se.s2;

public class Pflichtmodul {

	public String pModulName;
	public int pCreditpoints;
	public double pNote;

	public Pflichtmodul(String pModulName, int pCreditPoints) {
		this.pModulName = pModulName;
		this.pCreditpoints = pCreditPoints;
	}

	/**
	 * 
	 * @param pModulName
	 */
	public void pModul(String pModulName) {
		//TODO - implement Pflichtmodul.pModul
		//throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param pNote
	 */
	public boolean addPNote(double pNote) {
		if (pNote >= 1.0 && pNote <= 5.0) {
			this.pNote = pNote;
			return true;
		} else {
			System.out.println("Ungültige Note. Die Note muss zwischen 1.0 und 5.0 liegen.");
			return false;
		}
	}

	/**
	 * 
	 * @param pModulName
	 * @param pCreditPoints
	 */
	public void pModul(String pModulName, int pCreditPoints) {
		// TODO - implement Pflichtmodul.pModul
		//throw new UnsupportedOperationException();
	}

}