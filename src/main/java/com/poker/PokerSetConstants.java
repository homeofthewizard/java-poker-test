package com.poker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	
	public enum CardValue {
		Two("2", 2),
		Three("3", 3),
		Four("4", 4),
		Five("5", 5),
		Six("6", 6),
		Seven("7", 7),
		Eight("8", 8),
		Nine("9", 9),
		Ten("T", 10),
		Jack("J", 11),
		Queen("Q", 12),
		King("K", 13),
		Ace("A", 14);
		
		private final String label;
		private final Integer value;
		
		private static final Map<String, CardValue> BY_LABEL = new HashMap<>();
		
		static {
	        for (CardValue cv : values()) {
	            BY_LABEL.put(cv.label, cv);
	        }
	    }
		
		private CardValue(String label, Integer value) {
	        this.label = label;
	        this.value = value;
	    }
		
		public static CardValue valueOfLabel(String label) {
	        return BY_LABEL.get(label);
	    }
		
		public Integer getValue(){
			return this.value;
		}
		
		public String getLabel(){
			return this.label;
		}
	}
	
	
	public enum CardSuit{
		Spades("s"),
		Hearth("h"),
		Club("c"),
		Diamond("d");
		
		private final String label;
		
		private static final Map<String, CardSuit> BY_LABEL = new HashMap<>();
		
		static {
	        for (CardSuit cv : values()) {
	            BY_LABEL.put(cv.label, cv);
	        }
	    }
		
		private CardSuit(String label) {
	        this.label = label;
	    }
		
		public static CardSuit valueOfLabel(String label) {
	        return BY_LABEL.get(label);
	    }
		
		public String getLabel(){
			return this.label;
		}
	}
	
	
	public static final String handSplitter = " ";
	
	public static final int numberOfCardsInHand = 5;
	
	
//	public static final List<String> cardSuits;
//	public static final Map<String,Integer> cardLabelValueMap;
//	static {
//		Map<String, Integer> tempMap = new HashMap<String, Integer>();
//		tempMap.put("2", 2);
//		tempMap.put("3", 3);
//		tempMap.put("4", 4);
//		tempMap.put("5", 5);
//		tempMap.put("6", 6);
//		tempMap.put("7", 7);
//		tempMap.put("8", 8);
//		tempMap.put("9", 9);
//		tempMap.put("T", 10);
//		tempMap.put("J", 11);
//		tempMap.put("Q", 12);
//		tempMap.put("K", 13);
//		tempMap.put("A", 14);
//		cardLabelValueMap = Collections.unmodifiableMap(tempMap);
//		
//		List<String> tempList = new ArrayList<>(Arrays.asList("s", "h", "d", "c"));
//		cardSuits = Collections.unmodifiableList(tempList);
//	}
	
}