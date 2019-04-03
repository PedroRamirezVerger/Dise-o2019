package edu.uclm.esi.games.words;

import edu.uclm.esi.games.model.AbstractPlayer;
import edu.uclm.esi.games.model.Board;

public class WordsBoard extends Board {

	private String [][] tablero1;
	private String [][] tablero2;
	private String [] palabras = {"Aberroncho","Mariposa", "Hijo", "Mañana", "Cerveza","Agujero","Gloria", "Pipas","Jamón"};

	public WordsBoard(WordsMatch wordsMatch) {
		this.match=wordsMatch;
		//this.tablero1= rellenarTablero(tablero1);
		//this.tablero2= rellenarTablero(tablero2);
		
	}

	@Override
	public void move(AbstractPlayer player, Integer[] coordinates) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public AbstractPlayer getWinner() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean end() {
		// TODO Auto-generated method stub
		return false;
	}
	

	@Override
	public String getContent() {
		String r="";
		for (int i=0; i<this.tablero1.length; i++) {
			for (int j=0; j<this.tablero1[i].length; j++) 
				r+=this.tablero1[i][j]==null ? ' ' : this.tablero1[i][j];
		}
		return r;
		//return "Albacete, Cadiz, Cuenca";
	}
	public String[][] rellenarTablero(String[][] tablero) {
		int c=0;
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				tablero[i][j]=palabras[c];
				c++;
			}
		}
		return tablero;
	}
	@Override
	public boolean draw() {
		return false;
	}

}
