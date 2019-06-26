package edu.uclm.esi.games.words;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.uclm.esi.games.dao.WordRepository;
import edu.uclm.esi.games.model.Game;
import edu.uclm.esi.games.model.Match;
import edu.uclm.esi.games.model.Word;

@Component
public class WordsGame extends Game {
	//si no es Component es bin
	
	private ConcurrentHashMap<Integer, Word> palabras;
	private ArrayList<Word> palabrasJuego= new ArrayList<Word>();
	@Autowired
	private WordRepository wordsRepo;

	public WordsGame () {
		super();
		this.palabras=new ConcurrentHashMap<>();
		
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
			seleccion[i]=palabrasJuego.remove(rd.nextInt(palabrasJuego.size()));
		}
		return seleccion;
	}

	public ArrayList<Word> getPalabrasBD() {
		ArrayList <Word> listaPalabras = new ArrayList<Word>();
		int i=1;
		//
		for (Word w : wordsRepo.findAll()) {
			palabras.put(i, w);
			i++;
		}
		Enumeration<Word> eWords = palabras.elements();
		while (eWords.hasMoreElements())
			listaPalabras.add(eWords.nextElement());
		return listaPalabras;
	}

	@Override
	public void setPalabras() {
		
		this.palabrasJuego=getPalabrasBD();
		
	}
}
