package com.poker.rules;

import java.util.HashMap;
import java.util.Map;

public enum CardSuit{
		Spades("s"),
		Hearths("h"),
		Clubs("c"),
		Diamonds("d");
		
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
			if( BY_LABEL.get(label) == null )
				throw new IllegalArgumentException();
			else
				return BY_LABEL.get(label);
	    }
		
		public String getLabel(){
			return this.label;
		}
	}