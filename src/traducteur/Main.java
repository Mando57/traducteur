package traducteur;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		String codeMorse[] = initTableau("morse.txt");
		String lettre[] = initTableau("lettre.txt");
		String fichier;
		fichier = lireFichier();
		fichier = fichier.toUpperCase();
		Traduire(codeMorse, lettre, fichier);
	}

	public static String lireFichier() throws IOException
	{
		String retour="";
		String ligne_lue;
		BufferedReader entree = new BufferedReader(new FileReader(new File("atraduire.txt")));
		System.out.println("Le fichier contient");
		while((ligne_lue=entree.readLine())!=null){
			retour+=ligne_lue;
			System.out.println("-> "+ligne_lue);
		}
		entree.close();
		return retour;
	}
	
	public static void Traduire(String[] codeMorse,String[] lettre,String fichier){
		System.out.print("\r Le fichier contient \r -> ");
		for (int i = 0; i < fichier.length(); i++) {
			for (int t = 0; t < lettre.length; t++) {
				if (fichier.charAt(i) == lettre[t].toCharArray()[0]) {
					System.out.print(" " + codeMorse[t] + "  ");
					break;
				}
			}
		}
	}
	
	public static String[] initTableau(String fichier) throws IOException
	{
		String[] retour=new String[37];
		String ligne_lue;
		int i=0;
		BufferedReader entree = new BufferedReader(new FileReader(new File(fichier)));
		while((ligne_lue=entree.readLine())!=null){
			retour[i]=ligne_lue;
			i++;
		}
		entree.close();
		return retour;
	}
}
