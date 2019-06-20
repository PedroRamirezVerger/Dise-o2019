package edu.uclm.esi.games.ppt;

import java.util.ArrayList;

import edu.uclm.esi.games.model.Game;
import edu.uclm.esi.games.model.Match;
import edu.uclm.esi.games.model.Word;

public class PPTGame extends Game {
	
	public PPTGame() {
		super();
	}

	@Override
	public String getName() {
		return "PPT";
	}

	@Override
	protected Match createMatch() {
		return new PPTMatch(this);
	}

	
	@Override
	public void setPalabras(ArrayList<Word> palabras) {
		// TODO Auto-generated method stub
		
	}

}
