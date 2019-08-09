package com.cards.blackjack;

import java.util.ArrayList;
import java.util.List;

import com.cards.common.Card;

public class Hand {
List<Card> cardsInHand = new ArrayList<>();
	
	public List<Card> cardInHand(){
		return null;
		
	}
	
	public void addCard(Card card) {
		cardsInHand.add(card);
	}
	
	public List<Card> getCardsInHand() {
		return cardsInHand;
		
	}
	
	public int getValueOfHand() {
		int totalVal = 0;
		for (Card c : cardsInHand) {
			totalVal += c.getValue();
		}
		return totalVal;
		
	}
	public Card getFirstCard() {
		
		return cardsInHand.get(0);
		
	}
	
	public void resetHand() {
		cardsInHand = new ArrayList<>();
	}

	@Override
	public String toString() {
		return cardsInHand.toString();
	}
}
