package edu.uclm.esi.games.words;

import java.util.ArrayList;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.uclm.esi.games.dao.WordRepository;
import edu.uclm.esi.games.model.Game;
import edu.uclm.esi.games.model.Match;
import edu.uclm.esi.games.model.Word;

//@Component
public class WordsGame extends Game {
	//si no es Component es bin
	ArrayList<Word> palabras=new ArrayList<Word>();
	//@Autowired
	//private WordRepository repo;

	
	public WordsGame() {
		super();
	}

	@Override
	public String getName() {
		return "WordsGame";
	}
//
	@Override
	protected Match createMatch() {
		return new WordsMatch(this, palabrasAleatorias());
	}
	private Word [] palabrasAleatorias() {
		// Object animal = animales.get(rd.nextInt(animales.size()));
		Random rd=new Random();
		Word[] seleccion=new Word[9];
		for (int i = 0; i < 9; i++) {
			seleccion[i]=palabras.remove(rd.nextInt(palabras.size()));
		}
		return seleccion;
	}

	

	@Override
	public void setPalabras(ArrayList<Word> palabras) {
		this.palabras=palabras;
		
	}
}
