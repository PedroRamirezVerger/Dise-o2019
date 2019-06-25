package edu.uclm.esi.games.words;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.util.JSONPObject;

import edu.uclm.esi.games.model.AbstractPlayer;
import edu.uclm.esi.games.model.Board;
import edu.uclm.esi.games.model.Word;

public class WordsBoard extends Board {
	private Word [] palabras= new Word[9];//[0, 1, 2 ....]
	private int contadorPlayerA=0;
	private int contadorPlayerB=0;
	private String [][] tablero1;
	private String [][] tablero2;
	
	

	public WordsBoard(WordsMatch wordsMatch, Word [] palabras) {
		this.match=wordsMatch;
		this.palabras=palabras;
		this.tablero1= rellenarTablero();
		this.tablero2= rellenarTablero();
		this.setContadorPlayerA(0);
		this.setContadorPlayerB(0);
	}

	@Override
	public void move(AbstractPlayer player, Integer[] coordinates) throws Exception {
		if (player==match.getPlayerA()) {
			if(tablero1[coordinates[0]][coordinates[1]]==palabras[contadorPlayerA].getPalabra()) {
				contadorPlayerA++;
			}else {
				setContadorPlayerA(0);
			}
		}else if(player==match.getPlayerB()) {
			if(tablero2[coordinates[0]][coordinates[1]]==palabras[contadorPlayerB].getPalabra()) {
				contadorPlayerB++;
			}else {
				setContadorPlayerB(0);
			}
			
		}
		match.actualizarTablero();
	}
//
	@Override
	public AbstractPlayer getWinner() {
		if(getContadorPlayerA()==palabras.length) {
			return match.getPlayerA();
		} else if(getContadorPlayerB()==palabras.length) {
			return match.getPlayerB();
		}else{
			return null;
		}
	}

	@Override
	public boolean end() {
		// TODO Auto-generated method stub
		return false;
	}
	 

	@Override
	public String getContent() {
		JSONArray array=new JSONArray();
		JSONArray jsa= new JSONArray();
		JSONObject jsoPalabras= new JSONObject();
		JSONObject jsoTablero1= new JSONObject();
		JSONObject jsoTablero2= new JSONObject();
		for (int i=0; i<this.palabras.length; i++) {
			array.put(this.palabras[i].getPalabra());
			
		}
		jsoPalabras.put("palabras", array);
	
		array=new JSONArray();
		for (int i=0; i<this.tablero1.length; i++) {
			for (int j = 0; j < tablero1[i].length; j++) {
				array.put(this.tablero1[i][j]);
			}
		}
		jsoTablero1.put("tablero1", array);
		
		array=new JSONArray();
		for (int i=0; i<this.tablero2.length; i++) {
			for (int j = 0; j < tablero2[i].length; j++) {
				array.put(this.tablero2[i][j]);
			}
		}
		jsoTablero2.put("tablero2", array);
		jsa.put(jsoPalabras);
		jsa.put(jsoTablero1);
		jsa.put(jsoTablero2);
		JSONObject jso=new JSONObject().put("tablero", jsa);
		
		return jso.toString();
	}
	public String[][] rellenarTablero() {
		int c=0;
		Word [] auxPalabras= new Word [9];
		System.arraycopy(palabras, 0, auxPalabras, 0, 9);
		Mezclar(auxPalabras);
		String [][] tablero= new String [3][3];
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				tablero[i][j]=auxPalabras[c].getPalabra();
				c++;
			}
		}
		return tablero;
	}
	@Override
	public boolean draw() {
		return false;
	}
	public void Mezclar(Word [] lista) {
	    Random rnd = ThreadLocalRandom.current();
	    for (int i = lista.length - 1; i > 0; i--)
	    {
	      int aleatorio = rnd.nextInt(i + 1);
	      Word aux = lista[aleatorio];
	      lista[aleatorio] = lista[i];
	      lista[i] = aux;
	    }
	   
	}

	public int getContadorPlayerA() {
		return contadorPlayerA;
	}

	public void setContadorPlayerA(int contadorPlayerA) {
		this.contadorPlayerA = contadorPlayerA;
	}

	public int getContadorPlayerB() {
		return contadorPlayerB;
	}

	public void setContadorPlayerB(int contadorPlayerB) {
		this.contadorPlayerB = contadorPlayerB;
	}

	@Override
	public int[] getContadores() {
		int [] contadores= {getContadorPlayerA(), getContadorPlayerB()};
		return contadores;
	}

}
