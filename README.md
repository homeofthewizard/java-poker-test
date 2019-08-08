# Poker Game Kata

A java project simulating a pokerHand.  
Four classes are used for this purpose:  
  
1- A `PokerSetConstance` class including enums for the definition of cards used in the came, 
```
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
```
rankings of the hands(see `PokerHandAnalyzer` below for ranking), and the results for comparison of poke hands.  
```
public enum Result {
	WIN,
	LOSS,
	TIE;
}
```
  
2- A `PokerHand` class a constructor that accepts a string containing 5 cards:   
```
PokerHand hand = new PokerHand("Ks 2h 5c Jd Td");
```
The characteristics of the string of cards are:
*   A space is used as card seperator
*   Each card consists of two characters
*   The first character is the value of the card, valid characters are: `2`, `3`, `4`, `5`, `6`, `7`, `8`, `9`, `T`(en), `J`(ack), `Q`(ueen), `K`(ing), `A`(ce)
*   The second character represents the suit, valid characters are: `S`(pades), `H`(earts), `D`(iamonds), `C`(lubs)
  
PokerHand also contains a method to compare itself to another hand and return a `Result` instance

```	
public Result compareWith(PokerHand hand) {
...
}
```

3- A `Card` class that is keeping the value and the suit of itself. And A method to compare itself with another card's value, and sorting of cards in hand (implementing `Comparable<Card>` interface)
```
public int compareTo(Card card) {
	return this.cardValue.getValue() - card.cardValue.getValue();
}
```
  
4- A `HandAnalyzer` class that takes a List<Card> and return a HandType that corresponds to a ranking defined below.  
The ranking of the hands is follow the [Texas Hold'em rules](http://freepokerhoney.com/website_images/8245/poker-strategy/poker-hand-rankings.png)  


  
Tests can be run from the command line like so:  
`mvn test`


