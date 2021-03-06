# Poker Game Kata

A java project simulating a pokerHand.  
One package and 2 other classes are used for this purpose:  
  
1- A package names `com.poker.rules` contains class defining the rules as the name suggests, such as `PokerSetConstance` class including   
an enum defining the rankings of the hands(see `PokerHandAnalyzer` below for ranking),   
a constant number of cards that can be in a poker hand,  
and an enum defining the results for comparison of poke hands:  
```
public enum Result {
	WIN,
	LOSS,
	TIE;
}
```
  
The package also contains two enums defining the type of cards to be used in the poker game (`CardValue` and `CardSuit` enum class).    
The characteristics of the string of cards are:
*   A space is used as card seperator
*   Each card consists of two characters
*   The first character is the value of the card, valid characters are: `2`, `3`, `4`, `5`, `6`, `7`, `8`, `9`, `T`(en), `J`(ack), `Q`(ueen), `K`(ing), `A`(ce)
*   The second character represents the suit, valid characters are: `S`(pades), `H`(earts), `D`(iamonds), `C`(lubs)  

2- A `PokerHand` class a constructor that accepts a string containing 5 cards:   
```
PokerHand hand = new PokerHand("Ks 2h 5c Jd Td");
```  
The seperator character is defined in the class `PokerSetConstances`:  
``` private final static String handSplitter= " "; ```  
  
PokerHand also contains a method to compare itself to another hand and return a `Result` instance

```	
public Result compareWith(PokerHand hand) {
...
return Result.TIE;
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
  
  
  
## How To test ??  
Test class are present under src/test/ folder. PokerHandTest class can be used to simulate a poker game.  
Tests can be run from the command line like so:  
`mvn test`


