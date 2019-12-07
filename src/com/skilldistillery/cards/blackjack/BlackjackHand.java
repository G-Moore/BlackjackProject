package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.AbstractHand;

public class BlackjackHand extends AbstractHand{

	
	public BlackjackHand() {
	}
	
	
	public boolean isBlackjack() {
		if (cardsInHand.get(0).getValue() == 21){
			System.out.println("Blackjack");
			return true;
		}
		return false;
	}
	public boolean isBust() {
		if (cardsInHand.get(0).getValue() >= 22){
			System.out.println("Bust");
			return true;
		}
		return false;
	}
	
	@Override
	public int getHandValue() {
		int totalVal = 0;
		for (int i = 0; i < cardsInHand.size(); i++) {
			totalVal += cardsInHand.get(i).getValue();
		}
		return totalVal;
	}
	
}
