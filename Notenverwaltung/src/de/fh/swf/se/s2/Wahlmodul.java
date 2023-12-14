package de.fh.swf.se.s2;

import java.util.Objects;

public class Wahlmodul {

	private String wModulName;
	private int wCreditpoints;
	private double wNote;

	private double[] mNote = {1.0, 1.3, 1.7, 2.0, 2.3, 2.7, 3.0 ,3.3, 3.7, 4.0,5.0};
	private String wBeschreibung;

	private int wVersuch;
	private int wSemester;

	public Wahlmodul(String modulname, int creditpoints, String beschreibung, int semester) {
		setModulName(modulname);
		setBeschreibung(beschreibung);
		setCreditpoints(creditpoints);
		setSemester(semester);
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
	public boolean addWNote(double wNote,String s) {
		int i = 0;
		if((this.wNote == 0.0 && this.wVersuch != 3) || (this.wNote == 5.0 && this.wVersuch != 3) ) {
			if (wNote >= 1.0 && wNote <= 5.0) {
				while (mNote[i] != wNote) {
					if (i > 10) {
						System.out.println("Keine gültige Note");
						return false;
					}
					i++;
				}
				if (mNote[i] == wNote && (s=="n" || s == "l")) {
					this.wNote = wNote;
					if(Objects.equals(s, "n")) {

						this.wVersuch = this.wVersuch + 1;
					}
					return true;
				}else{return false;}

			}
		}
		if(this.wVersuch == 3) {
			System.out.println("Note wurde NICHT eingetragen. Grund: Maximale Anzahl von Versuchen erreicht");
			try {
				// Warte für 2 Sekunden (2000 Millisekunden)
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// Handle die Interrupted-Exception, falls sie auftritt
				e.printStackTrace();
			}
		}else if(this.wNote != 0.0){
			System.out.println("Note wurde NICHT eingetragen. Grund: Note schon vorhanden");
			try {
				// Warte für 2 Sekunden (2000 Millisekunden)
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// Handle die Interrupted-Exception, falls sie auftritt
				e.printStackTrace();
			}
		}
		return false;
	}

	public boolean addWVersuch(int wVersuch) {
		this.wVersuch = wVersuch;
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

	public String getModulName() {
		return wModulName;
	}

	// Getter-Methode für die Note des Pflichtmoduls
	public double getNote() {
		return wNote;
	}
	public int getCreditpoints() {
		return wCreditpoints;
	}
	public String getBeschreibung() {
		return wBeschreibung;
	}

	// Getter-Methode für die Note des Pflichtmoduls
	public int getSemester() {
		return wSemester;
	}
	public int getVersuch() {
		return wVersuch;
	}
	public void setModulName(String modulName) {
		this.wModulName = modulName;
	}

	public void setCreditpoints(int creditpoints) {
		if (creditpoints <= 30 && creditpoints >= 0) {
			this.wCreditpoints = creditpoints;
		}else{
			System.out.println("Creditpoints sind zu hoch oder zu niedrig");
			try {
				// Warte für 2 Sekunden (2000 Millisekunden)
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// Handle die Interrupted-Exception, falls sie auftritt
				e.printStackTrace();
			}
		}
	}

	public void setBeschreibung(String beschreibung) {
		this.wBeschreibung = beschreibung;
	}

	public void setSemester(int semester) {
		this.wSemester = semester;
	}


}