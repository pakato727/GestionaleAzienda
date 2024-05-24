package controller;

import model.Dipendente;

public interface ICrudService {
	//Un interfaccia in java è un elenco di metodi
	public Boolean inserisciDipendente(Dipendente dipendente);
	public Dipendente leggi(int idRicerca);
	public Dipendente[] leggi();
	public Dipendente leggi(String cf);
	public Boolean rimuoviDipendente(int idRicerca);
	public Boolean rimuoviDipendente(String cf);
	
}
