package de.fh.swf.se.s2;

public class Abschluss {

	private String aThema;
	private double aNoteArbeit;
	private double aNoteKolloquium;
	private double aGewichtungArbeit;
	private double aGewichtungKolloquium;

	public Abschluss(String thema, double aGewichtung, double kGewichtung) {
		this.aGewichtungArbeit = aGewichtung;
		this.aGewichtungKolloquium = kGewichtung;
		this.aThema = thema;
	}

	/**
	 * 
	 * @param thema
	 */
	public void abschluss(String thema) {
		// TODO - implement Abschluss.abschluss
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param thema
	 * @param gewichtungArbeit
	 * @param gewichtungKolloquium
	 */
	public void abschluss(String thema, double gewichtungArbeit, double gewichtungKolloquium) {
		// TODO - implement Abschluss.abschluss
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param noteArbeit
	 */
	public boolean addNoteArbeit(double noteArbeit) {
		// TODO - implement Abschluss.addNoteArbeit
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param noteKolloquium
	 */
	public boolean addNoteKolloquium(double noteKolloquium) {
		// TODO - implement Abschluss.addNoteKolloquium
		throw new UnsupportedOperationException();
	}

	public String getThema() {
		return aThema;
	}
}