package com.poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.poker.rules.CardValue;
import com.poker.rules.PokerSetConstants.HandType;


public class PokerHandAnalyzer{
	
	
	private static class HandProperties{
		
		Map<CardValue, Integer> cardNbOfSameValueMap;
		boolean isStraight;
		boolean isFlush;
		List<Card> cards;
		
		public HandProperties(List<Card> cards) {
			this.cards = cards;
			this.cardNbOfSameValueMap = new HashMap<>();
			this.isFlush = false;
			this.isStraight = false;
		}
	}
	
	
	public static HandType getHandType(List<Card> cards) {

		Collections.sort(cards, Collections.reverseOrder());
		
		HandProperties properties = analyzerCardsAndGetProperties(cards);
		
		return tagHandWithType(properties);
	}
	

	private static HandProperties analyzerCardsAndGetProperties(List<Card> cards) {
		
		HandProperties properties = new PokerHandAnalyzer.HandProperties(cards);
		
		int straightnessCounter = 0;
		int flushnessCounter = 0;
		for(int i=0; i<cards.size()-1; i++) {
			if(checkIfNeighboorHasSameValue(i, cards))	updateDuplicatesMapForLabel(properties.cardNbOfSameValueMap, cards.get(i).cardValue);
			if(checkIfStraightWithNeighboor(i, cards)) 	straightnessCounter++;
			if(checkIfFlushWithNeighboor(i, cards)) 	flushnessCounter++;
		}
		
		properties.isStraight = straightnessCounter == cards.size();
		properties.isFlush = flushnessCounter == cards.size();
		
		return properties;
	}


	private static boolean checkIfNeighboorHasSameValue(int i, List<Card> cards) {
		if( cards.get(i).compareTo(cards.get(i+1))==0 ) return true;
		return false;
	}
	
	
	private static void updateDuplicatesMapForLabel(Map<CardValue, Integer> sameOfRankMap, CardValue cardLabel) {
		if( sameOfRankMap.putIfAbsent(cardLabel, 2) != null )
			sameOfRankMap.computeIfPresent(cardLabel, (key,old)->{return old+1;});
	}
	
	
	private static boolean checkIfStraightWithNeighboor(int i, List<Card> cards) {
		if( cards.get(i).compareTo(cards.get(i+1))!=1 ) return false;
		return true;
	}
	
	
	private static boolean checkIfFlushWithNeighboor(int i, List<Card> cards) {
		if( !cards.get(i).cardSuit.equals((cards.get(i+1)).cardSuit) ) return false;
		return true;
	}
	
	
	private static HandType tagHandWithType(HandProperties properties) {
		
		if(properties.isStraight && properties.isFlush 
				&& properties.cards.get(0).cardValue.equals(CardValue.Ace))		return HandType.RoyalFlush;	
		if(properties.isStraight && properties.isFlush)							return HandType.StraightFlush;
		if(properties.isFlush) 													return HandType.Flush;		
		if(properties.isStraight)												return HandType.Straight;
		if(!properties.cardNbOfSameValueMap.isEmpty())							return countPairsInHand(properties.cardNbOfSameValueMap);
		return HandType.HighCard;
	}
	
	
	//@Nullable
	private static HandType countPairsInHand(Map<CardValue, Integer> cardNbOfSameValueMap) {
		HandType result = null;
		List<Integer> numberOfDuplicatesPerCardValue = new ArrayList<Integer>(cardNbOfSameValueMap.values());
		
		if(numberOfDuplicatesPerCardValue.size() < 2) {
			Integer numberOfCardsWithSameValue = numberOfDuplicatesPerCardValue.get(0);
			switch(numberOfCardsWithSameValue) {
				case 4: result = HandType.FourOfAKind; 
				case 3: result = HandType.ThreeOfAKind;
				case 2: result = HandType.OnePair;
			}
		}
		else result = numberOfDuplicatesPerCardValue.contains(3) ? HandType.FullHouse : HandType.TwoPairs;

		return result;
	}
	
}