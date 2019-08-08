package com.poker;


import static com.poker.PokerSetConstants.*;


public class Card implements Comparable<Card>{
	
	
	public CardValue cardValue;
	public CardSuit cardSuit;
	
	public Card(String cardStr) {
		checkIfCardValid(cardStr);
	}
	
	private void checkIfCardValid(String cardStr) {
		
		if(cardStr==null || cardStr.length()!=2)
			throw new IllegalArgumentException();
		
		String labelStr = cardStr.substring(0, 1);
		String suitStr = cardStr.substring(1, 2);
		
		if( CardValue.valueOfLabel(labelStr)==null || CardSuit.valueOfLabel(suitStr)==null )
			throw new IllegalArgumentException();
		
		cardValue = CardValue.valueOfLabel(labelStr);
		cardSuit = CardSuit.valueOfLabel(suitStr);	
	}
	

	@Override
	public int compareTo(Card card) {
		return this.cardValue.getValue() - card.cardValue.getValue();
	}
}
