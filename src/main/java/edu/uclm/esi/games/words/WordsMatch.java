package edu.uclm.esi.games.words;


import edu.uclm.esi.games.model.AbstractPlayer;
import edu.uclm.esi.games.model.Board;
import edu.uclm.esi.games.model.Game;
import edu.uclm.esi.games.model.Match;
import edu.uclm.esi.games.model.Word;

public class WordsMatch extends Match {
	Word[] palabras=new Word[9];
	public WordsMatch(Game game) {
		super(game);
	}
	public WordsMatch(Game game, Word [] palabras) {
		super(game);
		this.palabras=palabras;
		this.board= new WordsBoard(this, palabras);
	}
//
	@Override
	protected boolean tieneElTurno(AbstractPlayer player) {
		return (this.getCurrentPlayer()==0 && player==this.playerA) 
				|| (this.getCurrentPlayer()==1 && player==playerB);
	}

	public void setPalabras(Word [] palabras) {
		this.palabras=palabras;
	}
	@Override
	public void setBoard(Board board) {
		super.setBoard(board);
		WordsBoard theBoard=(WordsBoard) board;
		
	}
	@Override
	public void calculateFirstPlayer() {
		// TODO Auto-generated method stub
		
	}
}
