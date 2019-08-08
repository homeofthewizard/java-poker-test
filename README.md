# Poker Game Kata

A java project simulating a pokerHand.  
3 classes are used for this purpose:  
1- A PokerHand class a constructor that accepts a string containing 5 cards:   
```
PokerHand hand = new PokerHand("KS 2H 5C JD TD");
```
  
and a method to compare itself to another hand

```
public enum Result {
	WIN,
	LOSS,
	TIE;
}
	
public Result compareWith(PokerHand hand) {
}
```

2- A Card class that is keeping the value and the suit of itself. And A method to compare itself with another card's value.

3- A HandAnalyzer class that takes a List<Card> and return a HandType that corresponds to a ranking defined below.  
The ranking of the hands is follow the [Texas Hold'em rules](http://freepokerhoney.com/website_images/8245/poker-strategy/poker-hand-rankings.png)  

The characteristics of the string of cards are:
*   A space is used as card seperator
*   Each card consists of two characters
*   The first character is the value of the card, valid characters are: `2`, `3`, `4`, `5`, `6`, `7`, `8`, `9`, `T`(en), `J`(ack), `Q`(ueen), `K`(ing), `A`(ce)
*   The second character represents the suit, valid characters are: `S`(pades), `H`(earts), `D`(iamonds), `C`(lubs)

The result of your poker hand compare can be one of the 3 options defined by the `PokerHand.Result` enum.

  
Tests can be run from the command line like so:  
`mvn test`


