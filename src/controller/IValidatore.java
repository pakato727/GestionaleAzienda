package controller;


public interface IValidatore {
	public Boolean validazioneNominativi(String nominativo);
	public Boolean validazioneNominativi(String nominativo, int limitInf, int limitSup);
	public Boolean validazioneAnno(int anno);
	public Boolean validazioneMese(int mese);
	public Boolean validazioneGiorno(int giorno);
	public Boolean validazioneAnniExp(int anniExp);
	public Boolean validazioneStipendio(Double stipendio);
	



}
