public class Card implements Comparable<Card>{
	
    private int suit; //use integers 1-4 to encode the suit
    private int rank; //use integers 1-13 to encode the rank
    private int back;

	
    public Card(int s, int r){
        //make a card with suit s and rank r
        suit = s;
        rank = r;
    }
	
    
    public int compareTo(Card c){
        //Method to compare cards for hand
        if (this.rank > c.rank)
        {
            back = 1;
        }
        if (this.rank < c.rank)
        {
            back = -1;
        }
        if (this.rank == c.rank)
        {
            back = 0;
        }
        return back;
    }
	
    public String toString(){
        //Method to print a Card object
        String rank = "";
        String suit = "";
        if (this.suit == 1)
        {
            suit = "Clubs";
        }
        else if (this.suit == 2)
        {
            suit = "Diamonds";
        }
        else if (this.suit == 3)
        {
            suit = "Hearts";
        }
        else if (this.suit == 4)
        {
            suit = "Spades";
        }
        if (this.rank <= 10 && this.rank > 1)
        {
            rank += this.rank;
        }
        else if (this.rank == 1)
        {
            rank = "Ace";
        }
        else if (this.rank == 11)
        {
            rank = "Jack";
        }
        else if (this.rank == 12)
        {
            rank = "Queen";
        }
        else if (this.rank == 13)
        {
            rank = "King";
        }
        return rank + " of " + suit;
	}
    
    public int suits(){
        return this.suit;
    }
    
    public int ranks(){
        return this.rank;
    }
}
