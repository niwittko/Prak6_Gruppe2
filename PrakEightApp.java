import java.io.*;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class PrakEightApp {

    public static void main(String[] args) {
    	//generateClubWithRandomScores(2024); // Zahl eingeben. Wird an den CSV filename angehangen.
    	readBundesligaCSV("Bundesliga2024.csv");
 
    }
    
    public static void readBundesligaCSV(String filepath) {
    	BufferedReader br = null;
    	String line = "";
		int totalCount = 0;
    	
    	try {
    		br = new BufferedReader(new FileReader(filepath));
    		while((line = br.readLine()) != null) {
    			String[] strArr = line.split(";");
    			String vereinsName = strArr[0];
    			int count = 0;
    			
    			for (int i = 1; i<strArr.length; i++) {
    				if (!strArr[i].isEmpty()) {
    					String[] score = strArr[i].split(":");
    					int tore = Integer.parseInt(score[0]);
    					int ggTore = Integer.parseInt(score[1]);
    					
    					if(tore > ggTore) {
    						count+=3;
    					} else if (tore == ggTore) {
    						count+=1;
    					}
    					
    				}
    				
    				
    			}
				totalCount += count;
    			System.out.println("Verein: " + vereinsName + ", Punkte: " + count);
    			
    			
    			
    		}
    	} catch (IOException e) {
    		e.printStackTrace();
    	} 
    	
    	System.out.println("\nTotale Punkte aller Vereine in dieser Saison: " + totalCount + "\n");
    	
    	}

    public static void generateClubWithRandomScores(int jahr) {
        BufferedWriter bw = null;
        Random r = new Random();
       // String s = JOptionPane.showInputDialog("Gebe einen Vereinsnamen ein") + ";";
        
        LinkedList<String> vereinsListe = new LinkedList<>();
        vereinsListe.add("FC Schalke 04");
        vereinsListe.add("Borussia Dortmund");
        vereinsListe.add("Bayern Muenchen");
        vereinsListe.add("Borussia Moenchengladbach");
        vereinsListe.add("SpVGG Greuther Fuerth");
        vereinsListe.add("1. FC Union Berlin");
        vereinsListe.add("Bayer Leverkusen");
        vereinsListe.add("FSV Mainz 05");
        vereinsListe.add("VFL Bochum");
        vereinsListe.add("Fortuna Duesseldorf");
        vereinsListe.add("VfB Stuttgart");
        vereinsListe.add("Eintracht Frankfurt");
        vereinsListe.add("TSG Hoffenheim");
        vereinsListe.add("Werder Bremen");
        vereinsListe.add("SC Freiburg");
        vereinsListe.add("FC Augsburg");
        vereinsListe.add("VfL Wolfsburg");
        vereinsListe.add("1. FC Koeln");
        vereinsListe.add("SV Darmstadt 98");
        vereinsListe.add("1. FC Heidenheim");
        vereinsListe.add("St. Pauli");
        vereinsListe.add("Holstein Kiel");
        vereinsListe.add("Hertha BSC");
        vereinsListe.add("Eintracht Braunschweig");
        vereinsListe.add("SV Elversberg");
        vereinsListe.add("Hannover 96");
        vereinsListe.add("1. FC Kaiserslautern");
        vereinsListe.add("1. FC Magdeburg");
        vereinsListe.add("Karlsruher SC");
        vereinsListe.add("1. FC Nuernberg");
        vereinsListe.add("Vfl Osnabrueck");
        vereinsListe.add("SC Paderborn 07");
        vereinsListe.add("SV Wehen Wiesbaden");
        
        

        try {
            bw = new BufferedWriter(new FileWriter("Bundesliga" + jahr + ".csv", false));
            java.util.Collections.shuffle(vereinsListe, r);
            for (int j = 0; j < 17; j++) {
            	bw.write(vereinsListe.get(j) + ";");
	            for (int i = 0; i < 17; i++) {
	                String scores = r.nextInt(5) + ":" + r.nextInt(5) + ";";
	                bw.write(scores);
	            }
	            bw.newLine();  
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


