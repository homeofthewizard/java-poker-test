package com.poker;


import org.assertj.core.api.Assertions;
import org.junit.Test;


public class CardTest {
	
	@Test (expected = IllegalArgumentException.class)
	public void newCardRejectNullValue() {
		new Card(null);
	}
	
	
	@Test (expected = IllegalArgumentException.class)
	public void newCardRejectIncorrectValue() {
		new Card("XY");
	}
	
	
	@Test (expected = Test.None.class)
	public void newCardAcceptsAceOfSpades() {
		new Card("As");
	}
	
		
	@Test
	public void givenAceOfSpadesAndQueenOfClubes_WhenComparison_ThenAceWins() {
		Card aceOfSpades = new Card("As");
		Card queenOfClubs = new Card("Qc");
		
		int comparison = aceOfSpades.compareTo(queenOfClubs);

		Assertions.assertThat(comparison).isEqualTo(2);
	}
}
