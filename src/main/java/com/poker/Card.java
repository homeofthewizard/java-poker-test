package com.poker;

import com.poker.rules.CardSuit;
import com.poker.rules.CardValue;


public class Card implements Comparable<Card>{
	
	
	public CardValue cardValue;
	public CardSuit cardSuit;
	
	public Card(String cardStr) {
		if(cardStr==null || cardStr.length()!=2)
			throw new IllegalArgumentException();
		checkIfCardValid(cardStr);
	}
	
	private void checkIfCardValid(String cardStr) {
		
		String labelStr = cardStr.substring(0, 1);
		String suitStr = cardStr.substring(1, 2);
		
		cardValue = CardValue.valueOfLabel(labelStr);
		cardSuit = CardSuit.valueOfLabel(suitStr.toLowerCase());	
	}
	

	@Override
	public int compareTo(Card card) {
		return this.cardValue.getValue() - card.cardValue.getValue();
	}
}
