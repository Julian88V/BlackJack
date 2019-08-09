package com.cards.blackjack;

public class Player {
	private String name;
	private Hand hand;

	public Player() {
		hand = new Hand();
	}


	public String getName() {
		return name;
	}

	public Hand getHand() {
		return hand;
	}
}
