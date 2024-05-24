package controller;
import model.Dipendente;
import view.GestoreIO;

public class Avvio {
	

	public static void main(String[] args) {
		GestoreIO gio = new GestoreIO();
		CrudService cs = new CrudService();
		Dipendente dipendente = null;
		
		int scelta = 0;
		do {
			gio.menu();
			scelta = gio.leggiIntero("Scegli un opzione: ");
			switch(scelta) {
			case 1:
				//Inserisci
				dipendente = new Dipendente();
				gio.form(dipendente);
				Boolean risultatoInserimento = cs.inserisciDipendente(dipendente);
				gio.verificaOperazione(risultatoInserimento, "Inserimento");
				break;
			case 2:
				//leggi uno
				dipendente = new Dipendente();		
				gio.menuScelte();
				int sceltaLettura = gio.leggiIntero("Scegli opzione: ");
				switch(sceltaLettura) {
				case 1:
					int idCercato = gio.leggiIntero("Inserisci l'id del dipendente da leggere: ");
					Dipendente dipendenteCercato = cs.leggi(idCercato);
					gio.schedaDipendente(dipendenteCercato);
					break;
				case 2:
					String cfCercato = gio.leggiStringa("Inserisci il codice fiscale del dipendente da leggere: ");
					dipendenteCercato = cs.leggi(cfCercato);
					gio.schedaDipendente(dipendenteCercato);
					break;
				}
				break;
			case 3:
				//leggi tutti
				Dipendente[] dipendenti = cs.leggi();
				gio.tabella(dipendenti);
				
				break;
			case 4:
				//rimuovi dipendente
				
				gio.menuScelte();
				int sceltaDelete = gio.leggiIntero("Scegli opzione: ");
				switch(sceltaDelete) {
				case 1:
					int idDelete = gio.leggiIntero("Inserisci l'id del dipendente da cancellare");
					Boolean dipendenteCancellato = cs.rimuoviDipendente(idDelete);
					gio.verificaOperazione(dipendenteCancellato, "Rimozione");
					break;
				case 2:
					String cfDelete = gio.leggiStringa("Inserisci il codice fiscale del dipendente da cancellare");
					dipendenteCancellato = cs.rimuoviDipendente(cfDelete);
					gio.verificaOperazione(dipendenteCancellato, "Rimozione");
					break;
				}
				
				break;
			case 5:
				//statistiche
				gio.statistiche(cs.leggi());
				
				break;
			case 6:
				//ricerca statistiche
				String cittaCercata = gio.leggiStringa("Inserisci la citta di chi vuoi le statistiche");
				gio.statisticheByCitta(cs.leggi(), cittaCercata);
				
				break;
			case 7:
				gio.stampaMessaggio("Grazie e arrivederci!");
				break;
				
			}
		}
		while(scelta != 7);

	}

}
