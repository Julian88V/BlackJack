package com.cards.blackjack;

import com.cards.common.Card;
import com.cards.common.Deck;

public class Dealer {
	private Deck deck = new Deck();
	private Hand hand = new Hand();
	
	
	public Dealer() {
		
	}
	public Card dealerFirstCard(){
		return hand.getFirstCard();
		
	}
	public void getNewDeck() {
		deck = new Deck();
	}

	public Deck getDeck() {
		return deck;
	}


	public Hand getHand() {
		return hand;
	}

}
