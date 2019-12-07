package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractHand {

	protected List<Card> cardInHand = new ArrayList<>();

	public AbstractHand() {
	}

	public void clear() {
	}

	public abstract int getHandValue();


	public void addCard(Card card) {
		cardInHand.add(card);
	}

	@Override
	public String toString() {
		return "AbstractHand [cardInHand=" + cardInHand + "]";
	}

}
