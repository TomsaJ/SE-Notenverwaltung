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
		boolean vorhanden = false;
		try {
			var filePath = "Notenverwaltung/src/pflichtmodul.csv";
			var file = Paths.get(filePath);

			if (!Files.exists(file)) {
				System.out.println("File not found: " + filePath);
				return;
			}

			var fileContent = Files.readString(file, Charset.forName("UTF-8"));

			// Trennen Sie die Zeilen der CSV-Datei
			List<String> lines = Arrays.asList(fileContent.split("\n"));

			// Iterieren Sie durch jede Zeile und verarbeiten Sie die Daten
			for (String line : lines) {
				// Trennen Sie die einzelnen Felder durch das Trennzeichen ";"
				String[] fields = line.split(";");

				// Validieren Sie die Länge des Arrays
				if (fields.length >= 5) {
					// Extrahieren Sie die Daten aus den Feldern
					String modulName = fields[0];
					int creditPoints = Integer.parseInt(fields[1]);
					String beschreibung = fields[2];
					int semester = Integer.parseInt(fields[3]);

					// Rufen Sie Ihre Methode auf, um die Daten zu verarbeiten
					System.out.println(modulName + creditPoints + beschreibung + semester);

					if (Objects.equals(pModulName, modulName) && !modulName.isEmpty()) {
						vorhanden = true;
						break; // No need to continue checking once a match is found
					}
				} else {
					System.out.println("Warning: Insufficient fields in line");
				}
			}

			if (!vorhanden) {
				// Verwenden Sie try-with-resources, um Ressourcen zu schließen
				try (var fw = new FileWriter(filePath, true);
					 var bw = new BufferedWriter(fw);
					 var writer = new PrintWriter(bw)) {

					writer.println(String.format("%s;%d;%s;%d;", pModulName, pCreditPoints, pBeschreibung, pSemester));
				}
			}
		} catch (IOException e) {
			System.out.println(e);
		}
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