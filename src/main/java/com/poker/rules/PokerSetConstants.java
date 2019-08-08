package com.poker.rules;



public class PokerSetConstants{
	
	
	public enum Result {
		WIN,
		LOSS,
		TIE;
	}
	
	
	public enum HandType {
		HighCard,
		OnePair,
		TwoPairs,
		ThreeOfAKind,
		Straight,
		Flush,
		FullHouse,
		FourOfAKind,
		StraightFlush,
		RoyalFlush
	}
	
	
	public static final String handSplitter = " ";
	
	
	public static final int numberOfCardsInHand = 5;
	
	
}