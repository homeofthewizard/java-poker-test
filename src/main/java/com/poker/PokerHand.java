package com.poker;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.google.common.collect.Lists;

import com.poker.PokerSetConstants.Result;
import static com.poker.PokerSetConstants.*;
import com.poker.PokerHandAnalyzer;


public class PokerHand {
	
	
	private HandType handType;
	private List<Card> cards = new ArrayList<>();
	
	
	public PokerHand(String hand) {
		cards = parseHand(hand);
		handType = PokerHandAnalyzer.getHandType(cards);
	}


	private List<Card> parseHand(String hand) {
		if(hand == null) throw new IllegalArgumentException();
		
		return splitAndcheckNbOfCardsInHand(hand)
				.stream()
				.map(cardStr -> new Card(cardStr))
				.collect(Collectors.toList());
	}
	
	
	private List<String> splitAndcheckNbOfCardsInHand(String hand){
		List<String> cardsStrArray = Lists.newArrayList(hand.split(handSplitter));
		
		if(cardsStrArray.size() != numberOfCardsInHand) throw new IllegalArgumentException();
		
		return cardsStrArray;
	}
	

	public Result compareWith(PokerHand hand) {
		if(this.handType.ordinal() == hand.handType.ordinal()) 		return compareWithHandOfSameType(hand);
		if(this.handType.ordinal() > hand.handType.ordinal())		return Result.WIN;
		else														return Result.LOSS;
	}


	private Result compareWithHandOfSameType(PokerHand hand) {
		
		for(int i=0 ; i<numberOfCardsInHand ; i++) {
			int compareCards = hand.cards.get(i).compareTo(this.cards.get(i));
			if (compareCards > 0)	return Result.LOSS;
			if (compareCards < 0)	return Result.WIN;
		}			
		return Result.TIE;
	}
}
