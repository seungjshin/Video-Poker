Card.java
This class had a total of 5 methods. From the top, I had a constructor 
of Card in order to create an object of a card. It took in two implicit
parameters, s and r which were loaded into suit for s and rank for r. 
Because the class started with implements Comparable<Card>, I had to 
input compareTo method to later sort in the other classes. This compareTo
method sorted by the rank of the cards; higher the rank, returns 1 and 
lower the rank, returns -1. The toString method takes in the suit and 
rank and prints out a user-friendly name of the card. This is used to 
display what cards are in the user’s hand in the game. Below, are two 
accessor methods, suits and ranks which returns the numerical suit or rank 
of the card. 

Deck.java
There are three methods in this class. The deck method is a constructor 
that is create a deck for the game. Shuffle method takes two cards from 
the deck and switches their positions. This will occur 1000 times in order 
to thoroughly shuffle the cards. Last method is the accessor deal method 
which will return the card object to the hand of the player. The object 
reference top will change and the cards are being dealt.

Game.java
The game method that takes in the args from the main method as an array 
of Strings. This will check which character is started with and decide 
which suit of a card will be created. With that, the next two or one 
following integers will be parseInt’ed to be entered as the rank of the 
card. The cards then will be added into the hand, sorted and printed. 
The game no-argument constructor will create a deck, player and hand. 
The play method will start by printing out the introduction and ask for 
a bet amount. The bet amount will be taken in with a Scanner and placed 
into the bets of the player in the player class. The for loop is then 
initiated to deal five times to the player’s hand. The cards in the hand 
will be then sorted and printed out. The replace method is then called to 
ask and change the cards that the user wishes to do so. The cards are then 
sorted again and printed out. The hand is checked to see which combination 
is achieved and odds are returned from the checkHand method to be put 
into winnings of the player. The amount of bank is then printed out by 
the getBankroll method and answer method is called to either continue 
playing or stop. The testPlay method is put in place to check the hand of 
the player-input-cards from args to determine what combination are achieved.  
The checkHand method calls in 9 different helper methods to either print-out 
what the combination was and return the odds of the won combination. If 
no combinations were achieved, it will print out that the player lost and 
return 0. The toString method is created to print out the hand of the player. 
The following are the combination methods:

Striaght Flush: takes in the Boolean of straight method and the flush method 
and return true with both are achieved. 

Pair: Because the cards are sorted, the same rank cards will be placed 
next to each other. This method checks all adjacent cards to see if a 
pair exists through a nested for loop.

Two Pair: This is the essentially the same method of the pair but seeks 
out if two of these combinations exists. 

Three of a Kind: This checks if the rank of the card starting from index 
0, has the same rank as the card two indexes away. This is because the cards 
are sorted, therefore, if the card two places away is equal, it means that 
three of the same card exists. 

Four of a Kind: Same idea as the three of a kind but checks to see if the 
ranks are same three indexes away. 

Full house: This checks if the first two cards or the last two cards have 
the same ranks, and at the same time check if the last three or the first 
three cards are the same.

Flush: This calls for the suit method to check the suit of the first card. 
This is then compared to every card by a for loop and check to see if the 
cards in the hand have the same suits. 

Straight. This card checks to see if the cards are one rank in increasing 
order by a for loop. 

Royal Flush: This checks to see if the first card is an ace, calls for a 
flush method, check if the second card is a 10 and is increasing by one 
afterwards. 

Replace method is to ask the player which card would like to be replaced 
in the hand. This is done by the set method of an arraylist and asks the 
player whether it should be replaced five times. The answer method is put 
in place to ask if the player wishes to continue playing. 

Player.java
The variable e was created to temporarily place the winnings of the player 
before returning to the player. The player constructor is structured to 
create a player that has 1000 coins and bet 0. The bets method takes in the 
amt that the player bets and subtracts it from the bankroll of the player. 
The winnings method will take in the odds won by the player and multiplied 
by the bet of the player. This is then added into the player’s bankroll. The 
accessor getBankroll method will return the bankroll of the player. 
