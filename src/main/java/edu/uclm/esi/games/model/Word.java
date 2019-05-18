package edu.uclm.esi.games.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Word {
	@Id
	private String palabra;
	
	
	public Word() {
		
	}
	
	public Word(String palabra) {
		this.palabra=palabra;
	}
	
	public String getPalabra() {
		return palabra;
	}
	
}
