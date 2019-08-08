package com.poker.rules;

import java.util.HashMap;
import java.util.Map;


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
		if( BY_LABEL.get(label) == null )
			throw new IllegalArgumentException();
		else
			return BY_LABEL.get(label);
    }
	
	public Integer getValue(){
		return this.value;
	}
	
	public String getLabel(){
		return this.label;
	}
}