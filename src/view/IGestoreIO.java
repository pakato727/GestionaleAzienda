package view;

import java.sql.Date;

import model.Dipendente;

public interface IGestoreIO {
	public String leggiStringa(String messaggio);
	public int leggiIntero(String messaggio);
	public Double leggiDecimale(String messaggio);
	public Date leggiData(String messaggio);
	public void form(Dipendente dipendente);
	public void schedaDipendente(Dipendente dipendente);
	public void verificaOperazione(Boolean risultato, String nome);
	public void tabella(Dipendente[] azienda);
	public void menu();
	public void stampaMessaggio(String messaggio);
	public void statistiche(Dipendente[] azienda);
	public void statisticheByCitta(Dipendente[] azienda, String citta);
}
