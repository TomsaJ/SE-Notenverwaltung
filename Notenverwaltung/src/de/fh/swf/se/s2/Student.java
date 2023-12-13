package de.fh.swf.se.s2;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Student {


	private long matrikelnummer;
	private String vorname;
	private String nachname;
	private String studiengang;
	private int creditpoints;
	private List<Pflichtmodul> pflichtmodule;
	private List<Wahlmodul> wahlmodule;
	private List<Abschluss> abschluss;

	// Konstruktor für Student
	public Student(String vorname, String nachname, long matrikelnummer , String studiengang, int creditpoints) {
		this.vorname = vorname;
		this.nachname = nachname;
		this.matrikelnummer = matrikelnummer;
		this.studiengang = studiengang;
		this.pflichtmodule = new ArrayList<>();
		this.wahlmodule = new ArrayList<>();
		this.abschluss = new ArrayList<>();
		this.creditpoints = creditpoints;
		modul();

	}

	public void modul() {
		try {
			var filePath = "/Users/juliantomsa/Library/CloudStorage/SynologyDrive-Uni/Software-Engineering/Programm (Blatt3)/Notenverwaltung/src/Module.csv";
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
				if (fields.length >= 8) {
					// Extrahieren Sie die Daten aus den Feldern
					String student = fields[0];
					String modul = fields[1];
					String modulName = fields[2];
					int creditPoints = Integer.parseInt(fields[3]);
					String beschreibung = fields[4];
					int semester = Integer.parseInt(fields[5]);
					String noteStr = fields[6];
					int versuch = Integer.parseInt(fields[7]);


					// Rufen Sie Ihre Methode auf, um die Daten zu verarbeiten
					if(Objects.equals(student, nachname)) {
						if(Objects.equals(modul, "p")) {
							Pflichtmodul pm = new Pflichtmodul(modulName, creditPoints, beschreibung, semester);
							addPflichtmodul(pm);
							if (!noteStr.isEmpty() && !noteStr.equals("0.0")) {
								double note = Double.parseDouble(noteStr);
								pm.addPNote(note,"l");
								pm.addPVersuch(versuch);
							}
						}else if(Objects.equals(modul, "w")){
							Wahlmodul wm = new Wahlmodul(modulName, creditPoints, beschreibung, semester);
							addWahlmodul(wm);
							if (!noteStr.isEmpty() && !noteStr.equals("0.0")) {
								double note = Double.parseDouble(noteStr);
								wm.addWNote(note,"l");
								wm.addWVersuch(versuch);
							}
						}
					}
					Collections.sort(wahlmodule, Comparator.comparing(Wahlmodul::getSemester));
					Collections.sort(pflichtmodule, Comparator.comparing(Pflichtmodul::getSemester));
				} else {
					System.out.println("Warning: Insufficient fields in line");
				}
			}

		} catch (IOException e) {
            throw new RuntimeException(e);
        }
		try{
			int i = 0;
			var filePath = "/Users/juliantomsa/Library/CloudStorage/SynologyDrive-Uni/Software-Engineering/Programm (Blatt3)/Notenverwaltung/src/Abschluss.csv";
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
					String student = fields[0];
					String thema = fields[1];
					double gArbeit = Double.parseDouble(fields[2]);
					double nArbeit = Double.parseDouble(fields[3]);
					double gKollo = Double.parseDouble(fields[4]);
					double nKollo = Double.parseDouble(fields[5]);
					int versuch = Integer.parseInt(fields[6]);


					// Rufen Sie Ihre Methode auf, um die Daten zu verarbeiten
					if (Objects.equals(student, nachname) && i == 0) {
							Abschluss abschluss = new Abschluss(thema, gArbeit, gKollo);
							addAbschluss(abschluss);
							abschluss.addAVersuch(versuch);
							abschluss.addNoteArbeit(nArbeit,"l");
							abschluss.addNoteKolloquium(nKollo,"l");
							i = 1;
						}
					}
				}

		}catch (IOException e){
						throw new RuntimeException(e);
		}
    }

	/**
	 * 
	 * @param pModulName
	 * @param pCreditpoints
	 * @param pBeschreibung
	 * @param pSemester
	 */
	public void addPflichtmodul(String pModulName, int pCreditpoints, String pBeschreibung, int pSemester) {
		// TODO - implement Student.addPflichtmodul
		System.out.println("Modul: " + pModulName + " erstellt");
	}

	/**
	 * 
	 * @param wahlmodul
	 * @param pNote
	 */
	public void addNotetoPflichtModul(Pflichtmodul wahlmodul, double pNote) {
		// TODO - implement Student.addNotetoPflichtModul
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param pflichtmodul
	 * @param pNote
	 */
	public  void addNoteToPflichmodul(String pflichtmodul, double pNote) {
		Pflichtmodul pm1 = findePflichtmodul(pflichtmodul);


		if (pm1 != null) {
			pm1.addPNote(pNote,"n");
			int pmCP = pm1.getCreditpoints();
			creditpoints = creditpoints + pmCP;
		} else {
			System.out.println("Pflichtmodul nicht gefunden!");
			// Hier könntest du weitere Fehlerbehandlung hinzufügen
		}
	}

	// Annahme: Hier ist eine Methode zum Finden eines Pflichtmoduls anhand des Namens
	private  Pflichtmodul findePflichtmodul(String pflichtmodulName) {
		for (Pflichtmodul pm : pflichtmodule) {
			if (pm.getModulName().equals(pflichtmodulName)) {
				return pm;
			}
		}
		return null; // Pflichtmodul nicht gefunden
	}

	/**
	 * 
	 * @param wModulName
	 * @param wCredits
	 * @param wBeschreibung
	 * @param wSemester
	 */
	public void addWahlmodul(String wModulName, int wCredits, String wBeschreibung, int wSemester) {
		// TODO - implement Student.addWahlModul
		System.out.println("Modul: " + wModulName + " erstellt");
	}

	/**
	 * 
	 * @param wModulName
	 * @param wNote
	 */
	public void addNoteToWahlModul(String wModulName, double wNote) {
		Wahlmodul wm = findeWahlmodul(wModulName);

		if (wm != null) {
			wm.addWNote(wNote,"n");
			int wmCP = wm.getCreditpoints();
			creditpoints = creditpoints + wmCP;
		} else {
			System.out.println("Pflichtmodul nicht gefunden!");
			// Hier könntest du weitere Fehlerbehandlung hinzufügen
		}
	}

	private  Wahlmodul findeWahlmodul(String wahlmodulName) {
		for (Wahlmodul wm : wahlmodule) {
			if (wm.getModulName().equals(wahlmodulName)) {
				return wm;
			}
		}
		return null; // Pflichtmodul nicht gefunden
	}

	/**
	 * 
	 * @param
	 */
	public double berechnePflichtmodulDurchschnitt() {
		if (pflichtmodule.isEmpty()) {
			return 0; // Keine Pflichtmodule vorhanden
		}

		double sum = 0.0;
		for (Pflichtmodul pflichtmodul : pflichtmodule) {
			sum += pflichtmodul.getNote();
		}

		return sum / pflichtmodule.size();
	}


	/**
	 * 
	 * @param
	 */
	public double berechneWahlModulDurchschnitt() {
		if (wahlmodule.isEmpty()) {
			return 0; // Keine Wahlmodule vorhanden
		}

		double sum = 0.0;
		for (Wahlmodul wahlmodul : wahlmodule) {
			sum += wahlmodul.getNote();
		}

		return sum / wahlmodule.size();
	}


	/**
	 * 
	 * @param thema
	 * @param gewichtungArbeit
	 * @param gewichtungKolloquium
	 */
	public void addAbschluss(String thema, double gewichtungArbeit, double gewichtungKolloquium) {
		// TODO - implement Student.addAbschluss
		System.out.println("Das Thema ist: " +thema  + " Die Gewichtung(Arbeit): " + gewichtungArbeit+" Die Gewichtung(Arbeit): " + gewichtungKolloquium);
	}

	/**
	 * 
	 * @param thema
	 * @param noteArbeit
	 */
	public void addNoteToAbschlussA(String thema, double noteArbeit) {
		// TODO - implement Student.addNoteToAbschlussA
		System.out.println("Note der Arbeit: " + noteArbeit );
	}

	/**
	 * 
	 * @param abschluss
	 * @param noteArbeit
	 */
	public void addNoteToAbschlussA(Abschluss abschluss, double noteArbeit) {
		// TODO - implement Student.addNoteToAbschlussA
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param thema
	 * @param noteKolloquium
	 */
	public void addNoteToAbschlussK(String thema, double noteKolloquium) {
		// TODO - implement Student.addNoteToAbschlussK
		System.out.println("Note des Kolloquiums: " + noteKolloquium);
	}

	/**
	 * 
	 * @param abschluss
	 * @param noteKolloquium
	 */
	public void addnoteToAbschlussK(Abschluss abschluss, double noteKolloquium) {
		// TODO - implement Student.addnoteToAbschlussK
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param pModulName
	 * @param pNote
	 */
	public void addNoteToPflichtModul(String pModulName, double pNote) {
		// TODO - implement Student.addNoteToPflichmodul
		System.out.println("Note " + pNote + " zum Wahlmodul " + pModulName + " hinzugefügt.");
	}

	/**
	 * 
	 * @param pflichtmodul
	 */
	public void addPflichtmodul(Pflichtmodul pflichtmodul) {
		if (!isModulNameInList(pflichtmodul.getModulName())) {
			pflichtmodule.add(pflichtmodul);
		} else {
			System.out.println("Ein Modul mit dem gleichen Namen existiert bereits.");
			// Hier könntest du weitere Fehlerbehandlung hinzufügen
		}
		Collections.sort(pflichtmodule, Comparator.comparing(Pflichtmodul::getSemester));
	}


	public boolean isModulNameInList(String modulName) {
		for (Wahlmodul wm : wahlmodule) {
			if (wm.getModulName().equals(modulName)) {
				return true; // Pflichtmodul mit dem gegebenen Namen gefunden
			}
		}
		for (Pflichtmodul pm : pflichtmodule) {
			if (pm.getModulName().equals(modulName)) {
				return true; // Pflichtmodul mit dem gegebenen Namen gefunden
			}
		}
		return false; // Pflichtmodul mit dem gegebenen Namen nicht gefunden
	}



	/**
	 * 
	 * @param wahlmodul
	 */
	public void addWahlmodul(Wahlmodul wahlmodul) {
		if (!isModulNameInList(wahlmodul.getModulName())) {
		wahlmodule.add(wahlmodul);
		} else {
		System.out.println("Ein Modul mit dem gleichen Namen existiert bereits.");
		// Hier könntest du weitere Fehlerbehandlung hinzufügen
	}
		Collections.sort(wahlmodule, Comparator.comparing(Wahlmodul::getSemester));
	}


	/**
	 * 
	 * @param wahlmodul
	 */
	public void addNoteToWahlmodul(Wahlmodul wahlmodul) {
		// TODO - implement Student.addNoteToWahlmodul
		throw new UnsupportedOperationException();
	}

	public void save (){
		try {
			//first method
			var writer = new PrintWriter(
					"/Users/juliantomsa/Library/CloudStorage/SynologyDrive-Uni/Software-Engineering/Programm (Blatt3)/Notenverwaltung/src/Module.csv", StandardCharsets.UTF_8);
			getPflichtmodule().forEach(modul -> {
				writer.println(nachname + ";" + "p;" +   modul.getModulName() + ";" + modul.getCreditpoints()+ ";" + modul.getBeschreibung()  + ";" + modul.getSemester()+";" + modul.getNote() + ";" + modul.getVersuch()+";");
			});
			getWahlmodule().forEach(modul -> {
				writer.println(nachname + ";" + "w;" +   modul.getModulName() + ";" + modul.getCreditpoints()+ ";" + modul.getBeschreibung()  + ";" + modul.getSemester()+";" + modul.getNote() + ";" + modul.getVersuch()+";");
			});

			writer.close();
		} catch (IOException e) {
			System.out.println(e);
		}
			try {
			var writerA = new PrintWriter(
					"/Users/juliantomsa/Library/CloudStorage/SynologyDrive-Uni/Software-Engineering/Programm (Blatt3)/Notenverwaltung/src/Abschluss.csv", StandardCharsets.UTF_8);
				getAbschluss().forEach(modul -> {
			writerA.println(nachname + ";"  +   modul.getThema() + ";" + modul.getGewichtungArbeit()+ ";" + modul.getNoteArbeit()  + ";" + modul.getGewichtungKolloquium()+";" + modul.getNoteKolloquium() + ";" + modul.getVersuch()+";");
			});
			writerA.close();
		} catch (IOException e) {
			System.out.println(e);
		}
		try {
			//first method
			var writer = new PrintWriter(
					"/Users/juliantomsa/Library/CloudStorage/SynologyDrive-Uni/Software-Engineering/Programm (Blatt3)/Notenverwaltung/src/Student.csv", StandardCharsets.UTF_8);
				writer.println(getVorname()+";"+getNachname()+";"+getMatrikelnummer()+";"+getStudiengang()+";"+getCreditpoints());
			writer.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	/**
	 * 
	 * @param abschluss1
	 */
	public void addAbschluss(Abschluss abschluss1) {
		if (abschluss1 != null) {
			abschluss.add(abschluss1);
		}
	}

	public void setAbschluss(Abschluss abschluss) {

	}

	public void addNoteToAbschlussA(double noteArbeit) {
		Abschluss ab = findeAbschluss();
		if (ab != null) {
			ab.addNoteArbeit(noteArbeit, "n");
		}

	}

	private  Abschluss findeAbschluss() {
		for (Abschluss abschluss : abschluss) {
			return abschluss;
		}
		return null;
	}

	public void addNoteToAbschlussK(double noteKolloquium) {
		Abschluss ab = findeAbschluss();
		if (ab != null) {
			ab.addNoteKolloquium(noteKolloquium,"n");
			double noteA = ab.getNoteArbeit();
			double noteK = ab.getNoteKolloquium();
			if (noteA > 0.0 && noteA < 5.0 && noteK > 0.0 && noteK < 5.0)
			{
				creditpoints = 180;
			}
		}

	}

	public void changePflichtmodul(String modulname, String neumodulname,int credit,String beschreibung,int semester) {
		Pflichtmodul pm = findePflichtmodul(modulname);
		pm.setModulName(neumodulname);
		pm.setCreditpoints(credit);
		pm.setBeschreibung(beschreibung);
		pm.setSemester(semester);
		System.out.println("Modul geändert");
		try {
			// Warte für 2 Sekunden (2000 Millisekunden)
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// Handle die Interrupted-Exception, falls sie auftritt
			e.printStackTrace();
		}

	}

	public void changeWahlmodul(String modulname, String neumodulname,int credit,String beschreibung,int semester) {
		Wahlmodul wm = findeWahlmodul(modulname);
		wm.setModulName(neumodulname);
		wm.setCreditpoints(credit);
		wm.setBeschreibung(beschreibung);
		wm.setSemester(semester);
		System.out.println("Modul geändert");
		try {
			// Warte für 2 Sekunden (2000 Millisekunden)
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// Handle die Interrupted-Exception, falls sie auftritt
			e.printStackTrace();
		}
	}

	//public void

	// Getter-Methoden für Matrikelnummer, Vorname, Nachname und Studiengang
	public long getMatrikelnummer() {
		return matrikelnummer;
	}

	public String getVorname() {
		return vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public String getStudiengang() {
		return studiengang;
	}
	public int getCreditpoints() {
		return creditpoints;
	}

	// Getter-Methoden für Pflicht- und Wahlmodule sowie Abschluss
	public List<Pflichtmodul> getPflichtmodule() {
		return pflichtmodule;
	}

	public List<Wahlmodul> getWahlmodule() {
		return wahlmodule;
	}

	public List<Abschluss> getAbschluss() {
		return abschluss;
	}

	public int getVersuchA()
	{
		Abschluss ab = findeAbschluss();
		return ab.getVersuch();
	}

	public double getNoteA(){
		Abschluss ab = findeAbschluss();
		return ab.getNoteArbeit();
	}

	public double getNoteK(){
		Abschluss ab = findeAbschluss();
		return ab.getNoteKolloquium();
	}


	public void changeAbschluss(String thema, double gewichtungA, double gewichtungK) {
		Abschluss ab = findeAbschluss();
		if (ab != null) {
			ab.setThema(thema);
			ab.setGewichtungArbeit(gewichtungA);
			ab.setGewichtungKolloquium(gewichtungK);
			System.out.println("Abschluss geändert");
			try {
				// Warte für 2 Sekunden (2000 Millisekunden)
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// Handle die Interrupted-Exception, falls sie auftritt
				e.printStackTrace();
			}
		}
	}
}