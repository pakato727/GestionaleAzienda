package model;

import java.sql.Date;

public class Dipendente {
	public int id;
	public String nome;
	public String cognome;
	public String cf;
	public Date dataNascita;
	public String citta;
	public Double stipendio;
	public int anniExp;
	
	
	
	public Dipendente() {
		
	}
	
	public Dipendente(int ident, String nomeDip, String cognomeDip, String codFisc, Date data, String city, Double salario, int esperienza) {
		id = ident;
		nome = nomeDip;
		cognome = cognomeDip;
		cf = codFisc;
		dataNascita = data;
		citta = city;
		stipendio = salario;
		anniExp = esperienza;
	}
}
