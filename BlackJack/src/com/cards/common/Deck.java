package com.cards.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
private Card card;
	
	List<Card> deck;
	
	public Deck() {
		deck = createDeck();
		Suits[] suit = Suits.values();
		Rank[] ranks = Rank.values();
		
	}
	
	public List<Card> createDeck(){
		List<Card> deck = new ArrayList<>();
		for (Suits s : Suits.values()) {
			for (Rank r: Rank.values()) {
				deck.add( new Card(r, s));
			}
		}
		return deck;
	}
	
	public int checkDeckSize() {
		return deck.size();
	}
	
	public void shuffle() {
		Collections.shuffle(deck);
	}
	
	public Card dealCard() {
		return deck.remove(0);
	}
}
