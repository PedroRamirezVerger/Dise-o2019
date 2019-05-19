package edu.uclm.esi.games.words;

import edu.uclm.esi.games.model.Game;
import edu.uclm.esi.games.model.Match;
import edu.uclm.esi.games.model.Word;

public class WordsGame extends Game {
	Word[] palabras=new Word[12];
	public WordsGame (Word [] palabras) {
		super();
		this.palabras=palabras;
	}
	
	public WordsGame() {
		super();
	}

	@Override
	public String getName() {
		return "WordsGame";
	}

	@Override
	protected Match createMatch() {
		
		return new WordsMatch(this, palabrasAleatorias());
	}
	private Word [] palabrasAleatorias() {
		Word[] seleccion=new Word[9];
		for (int i = 0; i < 9; i++) {
			seleccion[i]=palabras[i];
		}
		return seleccion;
	}
}
