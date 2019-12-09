package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.AbstractHand;

public class BlackjackHand extends AbstractHand{

	
	public BlackjackHand() {
	}
	
	
//	public boolean isBlackjack() {
//		if (getHandValue() == 21){
//			System.out.println("Blackjack");
////			System.out.println(toString() + getHandValue());
//			return true;
//		}
//		else {
//			return false;
//		}
//	}
//	public boolean isBust() {
//		int comp = getHandValue();
//		
//		System.out.println(this.getHandValue());
//		if (comp > 21){
//			System.out.print("Bust ");
////			System.out.println(toString() + getHandValue());
//			return true;
//		}
//		else {
//			return false;
//		}
//	}
	
	@Override
	public int getHandValue() {
		int totalVal = 0;
		for (int i = 0; i < cardsInHand.size(); i++) {
			totalVal += cardsInHand.get(i).getValue();
		}
		return totalVal;
	}
	
}
