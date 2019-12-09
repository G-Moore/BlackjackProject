package com.skilldistillery.cards.blackjack;

import java.util.Scanner;

import com.skilldistillery.cards.common.Deck;

public class BlackjackApp {
	Player player = new Player();
	Dealer dealer = new Dealer();
	Deck deck = new Deck();
	Scanner sc = new Scanner(System.in);
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

		System.out.println("Player: " + player.getHand().toString() + player.getHand().getHandValue());
		System.out.println("Dealer: " + dealer.getHand().toString() + dealer.getHand().getHandValue());

		while (bjh.isBlackjack() == true || bjh.isBust() == true){
		if (player.getHand().isBust() == true) {
			System.out.println(" Player ");
			System.out.println(" Dealer Wins ");
			break;
		}
		if (player.getHand().isBlackjack() == true) {
			System.out.println(" Player ");
			System.out.println(" Player Wins ");
			break;
		}
		if (dealer.getHand().isBust() == true) {
			System.out.println(" Dealer ");
			System.out.println(" Player Wins ");
			break;
		}
		if (dealer.getHand().isBlackjack() == true) {
			System.out.println(" Dealer ");
			System.out.println(" Dealer Wins ");
			break;
		}
		}

		while (player.getHand().getHandValue() <= 21) {
			System.out.println("Would you like to \n1: hit \n2: stay? ");
			int userInput = sc.nextInt();

			if (userInput == 1) {
				player.getHand().addCard(deck.dealCard());
				System.out.println("Player: " + player.getHand());
				System.out.println("Player: " + player.getHand().getHandValue());
			}

			else {
				System.out.println("PLayer: " + player.getHand());
				System.out.println("Player: " + player.getHand().getHandValue());
				break;
			}

		}
		if (player.getHand().isBust() == true) {
			System.out.println("Player ");
			System.out.println("Dealer Wins ");
		}

		while (dealer.getHand().getHandValue() < 17 && player.getHand().getHandValue() <= 21) {
			dealer.getHand().addCard(deck.dealCard());
			System.out.println("Dealer: " + dealer.getHand());
			System.out.println("Dealer: " + dealer.getHand().getHandValue());

			if (dealer.getHand().getHandValue() == player.getHand().getHandValue()) {
				System.out.println("Push");
			}
			if (dealer.getHand().isBust() == true) {
				System.out.println("Dealer: BUST!!!");
				System.out.println("Player Wins!");
			} 
			else if (dealer.getHand().getHandValue() > player.getHand().getHandValue()) {
				System.out.println("Dealer Wins!");
			} else {
				System.out.println("Player Wins!");
			}
		}
		if (player.getHand().getHandValue() > dealer.getHand().getHandValue()) {
			System.out.println("Player Wins ");
		}
		else if (player.getHand().getHandValue() < dealer.getHand().getHandValue()) {
			System.out.println("Dealer Wins ");
		}

	}

}
