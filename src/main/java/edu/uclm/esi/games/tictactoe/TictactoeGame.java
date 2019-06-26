package edu.uclm.esi.games.tictactoe;

import java.util.ArrayList;

import edu.uclm.esi.games.model.Game;
import edu.uclm.esi.games.model.Match;
import edu.uclm.esi.games.model.Word;

public class TictactoeGame extends Game {

	public TictactoeGame() {
		super();
	}

	@Override
	public String getName() {
		return "tictactoe";
	}

	@Override
	protected Match createMatch() {
		return new TictactoeMatch(this);
	}

	@Override
	public void setPalabras() {
		// TODO Auto-generated method stub
		
	}



}
