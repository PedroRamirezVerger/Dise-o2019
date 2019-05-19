package edu.uclm.esi.games.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity(name="word")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="id")
public class Word {
	@Id
	private Integer id;
	private String palabra;
	
	
	public Word() {
		
	}
	//
	public Word(String palabra) {
		this.palabra=palabra;
	}
	
	public String getPalabra() {
		return palabra;
	}
	
}
