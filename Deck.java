public class Deck {
	
    private Card[] cards;
    private int top; //the index of the top of the deck
    private Card temp;
	private Card dealt;

        
    public Deck(){
        //make a 52 card deck
        int counter = 0;
        cards = new Card[52];
            for (int i = 0; i < 4; i++)
            {
                for (int j = 0; j < 13; j++)
                {
                    Card card = new Card(i + 1, j + 1);
                    cards[counter] = card;
                    counter++;  
                }
            }
	}
	
    public void shuffle(){
        //shuffle the deck      
        for (int i = 0; i <= 1000; i++)
        {
            int one = (int)(Math.random() * 52);
            int two = (int)(Math.random() * 52);
            temp = cards[one];
            cards[one] = cards[two];
            cards[two] = temp;
        }
        top = 0;
    }
    
    public Card deal(){
        // deal a single card
        dealt = cards[top];
        top++;
        return dealt;
    }

}
