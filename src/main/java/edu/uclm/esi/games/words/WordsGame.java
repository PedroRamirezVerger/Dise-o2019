package edu.uclm.esi.games.words;

import edu.uclm.esi.games.model.Game;
import edu.uclm.esi.games.model.Match;

public class WordsGame extends Game {
	
	public WordsGame () {
		super();
	}
	
	@Override
	public String getName() {
		return "WordsGame";
	}

	@Override
	protected Match createMatch() {
		
		return new WordsMatch(this);
	}

}
