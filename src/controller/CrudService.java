package controller;

import model.Dipendente;

public class CrudService implements ICrudService {
	private Dipendente[] azienda = new Dipendente[5];
	int idAutoInc = 1;
	public Boolean inserisciDipendente(Dipendente dipendente) {
		dipendente.id = idAutoInc;
		for(int i=0; i<azienda.length; i++) {
			if(azienda[i] == null) {
				azienda[i] = dipendente;
				idAutoInc++;
				return true;
			}
		}
		return false;
	}

	@Override
	public Dipendente leggi(int idRicerca) {
		for(int i=0; i<azienda.length; i++) {
			if(azienda[i] != null) {
				if(azienda[i].id == idRicerca) {	
					return azienda[i];
				}
			}
		}
		return null;
		
	}

	
	@Override
	public Dipendente leggi(String cf) {
		for(int i = 0; i<azienda.length; i++) {
			if(azienda[i] != null) {
				if(azienda[i].cf.equals(cf)) {	
					return azienda[i];
				}
			}
		}
		return null;
	}
	
	@Override
	public Dipendente[] leggi() {
		return azienda;
	}


	@Override
	public Boolean rimuoviDipendente(int idRicerca) {
		Boolean flag = false;
		for(int i = 0; i<azienda.length; i++) {
			if(azienda[i] != null) {
				if(azienda[i].id == idRicerca) {	
					azienda[i] = null;
					flag = true;
				}
			}
		}
		return flag;
	}

	@Override
	public Boolean rimuoviDipendente(String cf) {
		boolean flag = false;
		for(int i = 0; i<azienda.length; i++) {
			if(azienda[i] != null) {
				if(azienda[i].cf.equals(cf)) {	
					azienda[i] = null;
					flag = true;
				}
			}
		}
		return flag;
	}

	

}
