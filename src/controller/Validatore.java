package controller;


public class Validatore implements IValidatore{

	public Boolean validazioneNominativi(String nominativo) {
		String regex = "^[a-zA-Z ]*$";
		return nominativo.matches(regex);
	}

	@Override
	public Boolean validazioneNominativi(String nominativo, int limitInf, int limitSup) {
		String regex = "^[a-zA-Z ]{"+limitInf+","+limitSup+"}$";
		return nominativo.matches(regex);
	}

	@Override
	public Boolean validazioneAnno(int anno) {
		String regex = "^(19[3-9][0-9]|20[0-9][0-9])$";
		return (anno+"").matches(regex);
	}

	@Override
	public Boolean validazioneMese(int mese) {
		String regex = "^(0[1-9]|1[0-2]|[1-9])$";
		return (mese+"").matches(regex);
	}

	@Override
	public Boolean validazioneGiorno(int giorno) {
		String regex = "^(0[1-9]|[12][0-9]|3[0-1]|[1-9])$";
		return (giorno+"").matches(regex);
	}


	@Override
	public Boolean validazioneAnniExp(int anniExp) {
		String regex = "^(|[0-9]{1,2})$";
		return (anniExp+"").matches(regex);
	}

	@Override
	public Boolean validazioneStipendio(Double stipendio) {
		String regex = "^([123456789][0-9][0-9][0-9]([.])[0-9]{1,2})$"; //da 1000.0 a 9999.99
		return (stipendio+"").matches(regex);
	}
	
	public Boolean validazioneCodiceFiscale(String cf) {
		String regex = "^([A-Z]{6}[0-9LMNPQRSTUV]{2}[ABCDEHLMPRST]{1}[0-9LMNPQRSTUV]{2}[A-Z]{1}[0-9LMNPQRSTUV]{3}[A-Z]{1})$|([0-9]{11})$";
		return cf.matches(regex);
	}
	
}
