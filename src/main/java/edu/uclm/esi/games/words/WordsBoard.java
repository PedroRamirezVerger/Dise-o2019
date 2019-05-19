package edu.uclm.esi.games.words;

import org.json.JSONArray;

import com.fasterxml.jackson.databind.util.JSONPObject;

import edu.uclm.esi.games.model.AbstractPlayer;
import edu.uclm.esi.games.model.Board;
import edu.uclm.esi.games.model.Word;

public class WordsBoard extends Board {
	private Word [] palabras= new Word[9];
	private String [][] tablero1;
	private String [][] tablero2;
	//private String [] palabras = {"Aberroncho","Mariposa", "Hijo", "Mañana", "Cerveza","Agujero","Gloria", "Pipas","Jamón"};
	private JSONArray array=new JSONArray();

	public WordsBoard(WordsMatch wordsMatch, Word [] palabras) {
		this.match=wordsMatch;
		//this.tablero1= rellenarTablero(new String [3][3]);
		//this.tablero2= rellenarTablero(new String [3][3]);
		this.palabras=palabras;
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
		/*for (int i=0; i<this.palabras.length; i++) {
			r+=this.palabras[i];
			r+=" ";
		}*/
		return r;
		//return "Albacete, Cadiz, Cuenca";
	}/*
	public String[][] rellenarTablero(String[][] tablero) {
		int c=0;
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				tablero[i][j]=palabras[c];
				c++;
			}
		}
		return tablero;
	}*/
	@Override
	public boolean draw() {
		return false;
	}

}
