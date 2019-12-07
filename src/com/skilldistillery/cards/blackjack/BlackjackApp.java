package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.Deck;

public class BlackjackApp {
	Player player = new Player();
	Dealer dealer = new Dealer();
	Deck deck = new Deck();
	BlackjackHand bjh = new BlackjackHand();
	
	public static void main(String[] args) {
		BlackjackApp app = new BlackjackApp();
		
		app.run();
	}
	public void run() {
		deck.createDeck();
		
		player.getHand().addCard(deck.dealCard());
		player.getHand().addCard(deck.dealCard());
		
		dealer.getHand().addCard(deck.dealCard());
		dealer.getHand().addCard(deck.dealCard());
		
		System.out.println(player.getHand().toString());
		System.out.println(dealer.getHand().toString());
	}
}
