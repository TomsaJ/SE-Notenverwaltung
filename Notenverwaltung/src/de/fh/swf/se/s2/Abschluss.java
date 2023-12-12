package de.fh.swf.se.s2;

import java.util.Objects;

public class Abschluss {

	private String aThema;
	private double aNoteArbeit;
	private double aNoteKolloquium;
	private double aGewichtungArbeit;
	private double aGewichtungKolloquium;
	private  int aVersuch;
	private double[] mNote = {1.0, 1.3, 1.7, 2.0, 2.3, 2.7, 3.0 ,3.3, 3.7, 4.0, 5.0};

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
	public boolean addNoteArbeit(double noteArbeit,String s) {

		if((this.aNoteArbeit == 0.0 && this.aVersuch != 2) || (this.aNoteArbeit == 5.0 && this.aVersuch != 2)) {
			if (noteArbeit >= 1.0 && noteArbeit <= 5.0) {
				for (int i = 0; i<11;i++){
					if (mNote[i] == noteArbeit) {
						this.aNoteArbeit = noteArbeit;
						if(Objects.equals(s, "n")) {
							this.aVersuch = this.aVersuch + 1;
						}
						System.out.println("Note für Arbeit eingetragen");
						return true;
					}
				}
				System.out.println("Keine gültige Note");
				try {
					// Warte für 2 Sekunden (2000 Millisekunden)
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// Handle die Interrupted-Exception, falls sie auftritt
					e.printStackTrace();
				}
				return false;
			}



		}
		return false;
	}

	/**
	 * 
	 * @param noteKolloquium
	 */
	public boolean addNoteKolloquium(double noteKolloquium, String s) {
		if((this.aNoteKolloquium == 0.0 && this.aVersuch != 2) || (this.aNoteKolloquium == 5.0 && this.aVersuch != 2)) {
			if (noteKolloquium >= 1.0 && noteKolloquium <= 5.0) {
				for (int i = 0; i<11;i++){
					if (mNote[i] == noteKolloquium) {
						this.aNoteKolloquium = noteKolloquium;
						if(Objects.equals(s, "n")) {
							this.aVersuch = this.aVersuch + 1;
						}
						System.out.println("Note für Kolloquium eingetragen");
						try {
							// Warte für 2 Sekunden (2000 Millisekunden)
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							// Handle die Interrupted-Exception, falls sie auftritt
							e.printStackTrace();
						}
						return true;
					}
				}

			}
		}
		return false;
	}
	public boolean addAVersuch(int aVersuch) {
		this.aVersuch = aVersuch;
		return true;
	}
	public String getThema() {
		return aThema;
	}
	public double getNoteArbeit() {
		return aNoteArbeit;
	}
	public double getNoteKolloquium() {
		return aNoteKolloquium;
	}
	public double getGewichtungArbeit() {
		return aGewichtungArbeit;
	}
	public double getGewichtungKolloquium() {
		return aGewichtungKolloquium;
	}
	public int getVersuch() {
		return aVersuch;
	}

}