package com.skilldistillery.cards.blackjack;

import java.util.Scanner;

import com.skilldistillery.cards.common.Deck;

public class BlackjackApp {
	Player player = new Player();
	Dealer dealer = new Dealer();
	Deck deck = new Deck();
	Scanner sc = new Scanner(System.in);

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

		System.out.println("Player: " + player.getHand().toString() + player.getHand().getHandValue());
		System.out.println("Dealer: " + dealer.getHand().toString() + dealer.getHand().getHandValue());
		
		if(player.getHand().isBlackjack() == true) {
			System.out.println("BLACKJACK!!!");
		}
		if(dealer.getHand().isBlackjack() == true) {
			System.out.println("BLACKJACK!!!");
		}
		
		
		while (player.getHand().getHandValue() < 21) {
			System.out.println("Would you like to hit or stay? ");
			String userInput = sc.next();
			
			
			if (userInput.equalsIgnoreCase("hit")) {
				player.getHand().addCard(deck.dealCard());
				System.out.println("Player: " + player.getHand());
				System.out.println("Player: " + player.getHand().getHandValue());

			}

			if (userInput.equalsIgnoreCase("stay")) {
				System.out.println(player.getHand().getHandValue());
			}
			if(player.getHand().isBust() == true) {
				System.out.println("BUST!!!");
				break;
			}

			}
	
		if (dealer.getHand().getHandValue() < 17) {
			dealer.getHand().addCard(deck.dealCard());
			System.out.println("Dealer: " + dealer.getHand());
			System.out.println("Dealer: " + dealer.getHand().getHandValue());
		}
		}

	}


