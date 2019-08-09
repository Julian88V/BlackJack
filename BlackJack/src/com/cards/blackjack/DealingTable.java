package com.cards.blackjack;

import java.util.Scanner;

public class DealingTable {

	Dealer dealer = new Dealer();
	Player player = new Player();
	
	

	public void start(Scanner sc) {
		
		beginMatch(sc);
		
		//first 4 cards dealt.
		playerHit();
		dealerHit();
		playerHit();
		dealerHit();
		
		playerTurn(sc);
		
		dealerTurn();
		
		displayWhoWon(sc);
		
		
		
		
		
	}
	
	private void beginMatch(Scanner sc) {
		System.out.println("Would you like to play? Y/N ");
		String statement = sc.next();
		if(statement.equalsIgnoreCase("N")) {
			System.exit(0);
		}
		if(dealer.getDeck().checkDeckSize() < 9) {
			dealer.getNewDeck();
			System.out.println("You are now playing with a fresh deck");
		}
		dealer.getDeck().shuffle();
	}
	
	private void resetTable(Scanner sc) {
		player.getHand().resetHand();
		dealer.getHand().resetHand();
		start(sc);
	}
	private void playerHit() {
		player.getHand().addCard(dealer.getDeck().dealCard());
	}
	private void dealerHit() {
		dealer.getHand().addCard(dealer.getDeck().dealCard());
	}
	private void playerTurn(Scanner sc) {
		System.out.println("Your hand " + player.getHand());
		System.out.println("You currently have " + player.getHand().getValueOfHand());
		System.out.println("The dealers showing " + dealer.dealerFirstCard());
		System.out.println("Would you like to hit? Y/N");
		String hit = sc.next();
		if(hit.equalsIgnoreCase("N")) {
			System.out.println("You Stay with " + player.getHand().getValueOfHand() + "\n\nDealers turn");
			return;
		}
		else if (hit.equalsIgnoreCase("Y")) {
			playerHit();
			if(player.getHand().getValueOfHand() > 21) {
				System.out.println("You Hit you now have " + player.getHand().getValueOfHand() + ". You Busted, You Lose. ");
				resetTable(sc);
			}
			//In this game of 21 if you get 21 the dealer automatically loses.
			//They are given no chance to get 21 and force a push.
			else if(player.getHand().getValueOfHand() == 21){
				System.out.println("You have " + player.getHand().getValueOfHand() + ". You Win!");
				resetTable(sc);
				
			}
			playerTurn(sc);
		}
		
	}
	
	private void dealerTurn() {
		while(dealer.getHand().getValueOfHand() < 17) {
			dealerHit();
		}
		
	}
	
	private void displayWhoWon(Scanner sc) {
		if( player.getHand().getValueOfHand() < dealer.getHand().getValueOfHand()) {
			System.out.println("Dealer Wins");
			displayScore();
			resetTable(sc);
		}
		else if ( player.getHand().getValueOfHand() > dealer.getHand().getValueOfHand()) {
			System.out.println("Player Wins");
			displayScore();
			resetTable(sc);
		}
		else if ( player.getHand().getValueOfHand() == dealer.getHand().getValueOfHand()) {
			System.out.println("Push");
			displayScore();
			resetTable(sc);
		}
		
		
	}
	
	private void displayScore() {
		System.out.println();
		System.out.println("Your hand " + player.getHand());
		System.out.println("Your score is " + player.getHand().getValueOfHand());
		System.out.println("The dealers hand is " + dealer.getHand());
		System.out.println("Dealers score is " + dealer.getHand().getValueOfHand());
		System.out.println();
	}
}
