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

	private int pVersuch;
	private String pBeschreibung;
	private int pSemester;

    private double[] mNote = {1.0, 1.3, 1.7, 2.0, 2.3, 2.7, 3.0 ,3.3, 3.7, 4.0, 5.0};


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
	public boolean addPNote(double pNote,String s) {
		int i = 0;
		if((this.pNote == 0.0 && this.pVersuch != 3) || (this.pNote == 5.0 && this.pVersuch != 3)) {
			if (pNote >= 1.0 && pNote <= 5.0) {
				while (mNote[i] != pNote) {
					if (i > 10) {
						System.out.println("Keine gültige Note");
						return false;
					}
					i++;
				}
				if (mNote[i] == pNote) {
					this.pNote = pNote;
					if(Objects.equals(s, "n")) {
						this.pVersuch = this.pVersuch + 1;
					}
					return true;
				}

			}
		}
		if(this.pVersuch == 3) {
			System.out.println("Note wurde NICHT eingetragen. Grund: Maximale Anzahl von Versuchen erreicht");
			try {
				// Warte für 2 Sekunden (2000 Millisekunden)
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// Handle die Interrupted-Exception, falls sie auftritt
				e.printStackTrace();
			}
		}else if(this.pNote != 0.0){
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

	/**
	 *
	 * @param pVersuch
	 */
	public boolean addPVersuch(int pVersuch) {
		this.pVersuch = pVersuch;
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
	public int getVersuch() {
		return pVersuch;
	}

}