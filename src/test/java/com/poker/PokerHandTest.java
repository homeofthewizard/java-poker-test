package com.poker;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import static com.poker.PokerSetConstants.*;


/**
 * Unit test for simple App.
 */
public class PokerHandTest {
	
	@Test (expected = IllegalArgumentException.class)
	public void newHandTestNull() {
		new PokerHand(null);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void newHandTestWithCardsLessThanFive() {
		new PokerHand("As 2h 5c");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void newHandTestWithIncorrectCard() {
		new PokerHand("As 2h 5c XY Jd");
	}
	
	@Test
	public void highCardWin() {
		PokerHand hand1 = new PokerHand("5s 2h Ac Jd Td");
		PokerHand hand2 = new PokerHand("5c 2s 3h Kh Tc");

		assertEquals(Result.WIN, hand1.compareWith(hand2));
		assertEquals(Result.LOSS, hand2.compareWith(hand1));
	}
	
	@Test
	public void flushWinAgainstStraight() {
		PokerHand hand1 = new PokerHand("As 2s 5s Js Ts");
		PokerHand hand2 = new PokerHand("Kc Qs Jh Th 9c");

		assertEquals(Result.WIN, hand1.compareWith(hand2));
		assertEquals(Result.LOSS, hand2.compareWith(hand1));
	}
	
	@Test
	public void flushWithAceWinAgainstFlushWithQueen() {
		PokerHand hand1 = new PokerHand("As 2s 5s Js Ts");
		PokerHand hand2 = new PokerHand("Qc 2c Jc Tc 9c");

		assertEquals(Result.WIN, hand1.compareWith(hand2));
		assertEquals(Result.LOSS, hand2.compareWith(hand1));
	}
	
	@Test
	public void OnePairWithAceWinAgainstOnePairWithKing() {
		PokerHand hand1 = new PokerHand("As 3s 5s Js As");
		PokerHand hand2 = new PokerHand("Kc 2c Kc Tc 9c");

		assertEquals(Result.WIN, hand1.compareWith(hand2));
		assertEquals(Result.LOSS, hand2.compareWith(hand1));
	}
	
	@Test
	public void twoPairsWithFiveWinAgainstOnePairsWithKing() {
		PokerHand hand1 = new PokerHand("Ah 3s 5s Js 5c");
		PokerHand hand2 = new PokerHand("Kh 2c Kc Tc 9s");

		assertEquals(Result.WIN, hand1.compareWith(hand2));
		assertEquals(Result.LOSS, hand2.compareWith(hand1));
	}
}
