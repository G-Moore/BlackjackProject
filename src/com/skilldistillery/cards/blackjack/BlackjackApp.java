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
		newHand();
		isBust();
		isBlackjack();
		
//		checkDealForBust();
		
//		checkDealForBlackjack();

		playerMenu();
		isBust();
		
//		checkDealForBust();
		

		dealerUnder();
		isBust();
		
//		checkDealForBust();

		while (player.getHand().getHandValue() <= 21) {
			
			if (dealer.getHand().getHandValue() == player.getHand().getHandValue()) {
				System.out.println("Push");
				break;
			}
			if (isBust() == true) {
				System.out.println("Dealer: BUST!!!");
				System.out.println("Player Wins!");
				break;
			}
			else if (dealer.getHand().getHandValue() > player.getHand().getHandValue()) {
				System.out.println("Dealer Wins!");
				break;

			} else {
				System.out.println("Player Wins!");
				break;
			}

		}
//			if (player.getHand().getHandValue() > dealer.getHand().getHandValue()) {
//				System.out.println("Player Wins ");
//			}
//			if (player.getHand().getHandValue() < dealer.getHand().getHandValue()) {
//				System.out.println("Dealer Wins ");
//			}
	}

	private void dealerUnder() {
		while (dealer.getHand().getHandValue() < 17) {
			dealer.getHand().addCard(deck.dealCard());
			System.out.println("Dealer: " + dealer.getHand());
			System.out.println("Dealer: " + dealer.getHand().getHandValue());
		}
	}

	private void playerMenu() {
		while (player.getHand().getHandValue() <= 21) {
			System.out.println("\nPlease select a number\nWhat would you like to \n1: hit \n2: stay ");
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
	}

//	private void checkDealForBlackjack() {
//		while (bjh.isBlackjack() == true) {
//			if (player.getHand().isBlackjack() == true) {
//				System.out.println(" Player ");
//				System.out.println(" Player Wins ");
//				break;
//			}
//			if (dealer.getHand().isBlackjack() == true) {
//				System.out.println(" Dealer ");
//				System.out.println(" Dealer Wins ");
//				break;
//			}
//		}
//	}

//	private void checkDealForBust() {
//		while (bjh.isBust() == true) {
//			if (player.getHand().isBust() == true) {
//				System.out.println(" Player ");
//				System.out.println(" Dealer Wins ");
//				break;
//			}
//			else if (isBust() == true) {
//				System.out.println(" Dealer ");
//				System.out.println(" Player Wins ");
//				break;
//			}
//		}
//	}

	private void newHand() {

		deck.createDeck();

		player.getHand().addCard(deck.dealCard());
		player.getHand().addCard(deck.dealCard());

		dealer.getHand().addCard(deck.dealCard());
		dealer.getHand().addCard(deck.dealCard());

		System.out.println("Player: " + player.getHand().toString() + player.getHand().getHandValue());
		System.out.println("Dealer: " + dealer.getHand().toString() + dealer.getHand().getHandValue());
	}
	public boolean isBlackjack() {
		if (player.getHand().getHandValue() == 21){
			System.out.println("Player has Blackjack");
			System.out.println("Player Wins!");
			return true;
		}
		if (dealer.getHand().getHandValue() == 21){
			System.out.println("Blackjack has Blackjack");
			System.out.println("Dealer Wins!");
			return true;
		}
		else {
			return false;
		}
	}
	public boolean isBust() {
		if (player.getHand().getHandValue() > 21){
			System.out.println("Player Bust ");
			System.out.println("Dealer Wins ");
//			System.out.println(toString() + getHandValue());
			return true;
		}
		if (dealer.getHand().getHandValue() > 21){
			System.out.println("Dealer Bust ");
			System.out.println("Player Wins ");
//			System.out.println(toString() + getHandValue());
			return true;
		}
		else {
			return false;
		}
	}
}
