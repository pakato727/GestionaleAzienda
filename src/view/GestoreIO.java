package view;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Scanner;

import model.Dipendente;
public class GestoreIO implements IGestoreIO{

	@Override
	public String leggiStringa(String messaggio) {
		System.out.println(messaggio);
		Scanner input = new Scanner(System.in);
		return input.nextLine();
	}

	@Override
	public int leggiIntero(String messaggio) {
		System.out.println(messaggio);
		Scanner input = new Scanner(System.in);
		return Integer.parseInt(input.nextLine());
	
	}

	@Override
	public Double leggiDecimale(String messaggio) {
		System.out.println(messaggio);
		Scanner input = new Scanner(System.in);
		return Double.parseDouble(input.nextLine());
	}

	@Override
	public Date leggiData(String messaggio) {
		System.out.println(messaggio);
		Scanner input = new Scanner(System.in);
		int giorno = leggiIntero("Inserisci il giorno: ");
		int mese = leggiIntero("Inserisci il mese");
		int anno = leggiIntero("Inserisci l'anno") ;
		return Date.valueOf(LocalDate.of(anno, mese, giorno));
	}

	@Override
	public void form(Dipendente dipendente) {
		dipendente.id =leggiIntero("ID: ");
		dipendente.nome = leggiStringa("Nome: ");
		dipendente.cognome = leggiStringa("Cognome: ");
		dipendente.cf = leggiStringa("Codice fiscale: ");
		dipendente.citta = leggiStringa("Città: ");
		dipendente.stipendio = leggiDecimale("Stipendio: ");
		dipendente.anniExp = leggiIntero("Anni esperienza: ");
		dipendente.dataNascita = leggiData("DATA DI NASCITA");
		
	}

	@Override
	public void schedaDipendente(Dipendente dipendente) {
		System.out.println("");
		System.out.println("ID: " + dipendente.id);
		System.out.println("Nome: " + dipendente.nome);
		System.out.println("Cognome: " + dipendente.cognome);
		System.out.println("Codice Fiscale: " + dipendente.cf);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		System.out.println("Data di nascita: " + (sdf.format(dipendente.dataNascita)));
		System.out.println("Citta: " + dipendente.citta);
		System.out.println("Stipendio: " + dipendente.stipendio);
		System.out.println("Anni Esperienza: " + dipendente.anniExp);
		System.out.println("");
	}

	@Override
	public void verificaOperazione(Boolean risultato, String nome) {
		if(risultato == true) {
			System.out.println( nome +" avvenuto/a con successo");
		} 
		else {
			System.err.println( nome + " fallito/a");
		}
		
	}

	@Override
	public void tabella(Dipendente[] azienda) {
		int dipendentiTrovati = 0;
		for(int i = 0; i<azienda.length ; i++) {
			if(azienda[i] != null) {
				schedaDipendente(azienda[i]);
				dipendentiTrovati++;
			}
		}
		//if(dipendentiTrovati == 0) {
		    System.out.println("--------------------------");
			System.out.println("Dipendenti trovati: " + dipendentiTrovati);
			System.out.println("--------------------------");
		//}
		
	}

	@Override
	public void menu() {
		System.out.println("");
		System.out.println("******MENU INIZIALE******");
		System.out.println("1 - Inserisci dipendente");
		System.out.println("2 - Leggi dipendente");
		System.out.println("3 - Leggi dipendenti");
		System.out.println("4 - Rimuovi un dipendente");
		System.out.println("5 - Statistiche");
		System.out.println("6 - Ricerca statistiche");
		System.out.println("7 - Esci dal programma");
		System.out.println("*************************");
	}

	
	@Override
	public void stampaMessaggio(String messaggio) {
		System.out.println(messaggio);
		
	}
	
	public void menuScelte () {
		stampaMessaggio("");
		stampaMessaggio("PUOI EFFETTUARE L'OPERAZIONE TRAMITE:");
		stampaMessaggio("1 - Id");
		stampaMessaggio("2 - Codice Fiscale");
		stampaMessaggio("*************************");
	}
	


	@Override
	public void statistiche(Dipendente[] azienda) {
		int numeroDipendenti= 0;
		Double sommaStip = 0.0;
		int sommaAnniExp = 0;
		Double avgStip = 0.0;
		int avgAnniExp = 0;
		for(int i=0; i<azienda.length; i++) {
			
			if(azienda[i] != null) {
				numeroDipendenti++;
				sommaStip += azienda[i].stipendio;
				sommaAnniExp += azienda[i].anniExp;
			}
			
			
		}
		if(numeroDipendenti > 0) {
			avgStip = (double)sommaStip/numeroDipendenti;
			avgAnniExp = sommaAnniExp/numeroDipendenti;
			stampaMessaggio("Media degli anni d'esperienza: " + avgAnniExp);
			stampaMessaggio("Media degli stipendi: " + avgStip);
		} else {
			stampaMessaggio("Non ci sono dipendenti");
		}
		stampaMessaggio("Numero dipendenti: "+numeroDipendenti);
		
	}

	@Override
	public void statisticheByCitta(Dipendente[] azienda, String citta) {
		
		int numeroDipendenti= 0;
		Double sommaStip = 0.0;
		int sommaAnniExp = 0;
		Double avgStip = 0.0;
		int avgAnniExp = 0;
		for(int i=0; i<azienda.length; i++) {
			
				if(azienda[i] != null) {
					if(azienda[i].citta.equals(citta)) {
						numeroDipendenti++;
						sommaStip += azienda[i].stipendio;
						sommaAnniExp += azienda[i].anniExp;
				}

			}
			
			
		}
		if(numeroDipendenti > 0) {
			avgStip = (double)sommaStip/numeroDipendenti;
			avgAnniExp = sommaAnniExp/numeroDipendenti;
			stampaMessaggio("Media degli anni d'esperienza: " + avgAnniExp);
			stampaMessaggio("Media degli stipendi: " + avgStip);
		} else {
			stampaMessaggio("Non ci sono dipendenti con questa città");
		}
		stampaMessaggio("Numero dipendenti: "+numeroDipendenti);
		
	}

}
