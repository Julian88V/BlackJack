package com.cards.blackjack;

import java.util.Scanner;

public class BlackJackApp {
	public static void main(String[] args) {
		
		DealingTable dealingTable = new DealingTable();
		Scanner sc = new Scanner(System.in);
		
		dealingTable.start(sc);
		sc.close();
		
	}
}
