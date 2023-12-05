package de.fh.swf.se.s2;

public class Abschluss {

	private String aThema;
	private double aNoteArbeit;
	private double aNoteKolloquium;
	private double aGewichtungArbeit;
	private double aGewichtungKolloquium;



	/**
	 * 
	 * @param thema
	 */
	public void abschluss(String thema) {
		// TODO - implement Abschluss.abschluss
		//throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param thema
	 * @param gewichtungArbeit
	 * @param gewichtungKolloquium
	 */
	public void abschluss(String thema, double gewichtungArbeit, double gewichtungKolloquium) {
		// TODO - implement Abschluss.abschluss
		//throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param noteArbeit
	 */
	public boolean addNoteArbeit(double noteArbeit) {
		if (noteArbeit >= 1.0 && noteArbeit <= 5.0) {
			this.aNoteArbeit = noteArbeit;
			return true;
		} else {
			System.out.println("Ungültige Note. Die Note muss zwischen 1.0 und 5.0 liegen.");
			return false;
		}
	}

	/**
	 * 
	 * @param noteKolloquium
	 */
	public boolean addNoteKolloquium(double noteKolloquium) {
		if (noteKolloquium >= 1.0 && noteKolloquium <= 5.0) {
			this.aNoteKolloquium = noteKolloquium;
			return true;
		} else {
			System.out.println("Ungültige Note. Die Note muss zwischen 1.0 und 5.0 liegen.");
			return false;
		}
	}

}