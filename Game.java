import java.util.*;


public class Game {
	
    private Player p;
    private Deck cards;
    private ArrayList<Card> hand;
    private String answer;
    private int me;
	
	
    public Game(String[] testHand){//Use to test hand
		hand = new ArrayList<Card>();
        for (int i = 0; i < 5; i++)
        {
            if (testHand[i].substring(0,1).equals("c"))
            {
                me = Integer.parseInt(testHand[i].substring(1,testHand[i].length()));
                Card c = new Card (1, me);
                hand.add(c);
            }
            else if (testHand[i].substring(0,1).equals("d"))
            {
                me = Integer.parseInt(testHand[i].substring(1,testHand[i].length()));
                Card c = new Card (2, me);
                hand.add(c);
            }
            else if (testHand[i].substring(0,1).equals("h"))
            {
                me = Integer.parseInt(testHand[i].substring(1,testHand[i].length()));
                Card c = new Card (3, me);
                hand.add(c);
            }
            else if (testHand[i].substring(0,1).equals("s"))
            {
                me = Integer.parseInt(testHand[i].substring(1,testHand[i].length()));
                Card c = new Card (4, me);
                hand.add(c);
            }                          
        }
        Collections.sort(hand);
        System.out.println(toString());
    }
	
    public Game(){
		
        //Play a normal game
		p = new Player();
        cards = new Deck();
        hand = new ArrayList<Card>();
    }
	
    public void play(){
        
        // this method should play the game	
        Scanner input = new Scanner(System.in);
        cards.shuffle();
        System.out.println("~~~~~~~~~~Welcome to Poker Frenzy~~~~~~~~~~\n");
        System.out.print("Please place a bet between  1 - 5: ");
        p.bets(input.nextInt());
        while (p.getBet() > 5 || p.getBet() < 1)
        {
            System.out.print("Please a number between 1 ~ 5: ");
            p.bets(input.nextInt());
        }
        for (int i = 0; i < 5; i++)
        {
            hand.add(cards.deal());
        }
        Collections.sort(hand);
        System.out.println(toString());
        replace();
        Collections.sort(hand);
        System.out.println(toString());
        p.winnings(checkHand());
        System.out.println("You now have: " + p.getBankroll());
        answer();
    }
    
    public void testPlay(){
        // Method is used for testing the checkHand method
        checkHand();
    }
	
	public int checkHand(){
        // Method should to take an ArrayList of five Card objects as input
		// and evaluate the hand
        if (royal() == true)
        {
            System.out.println("You got a royal flush!");
            return 250;
        }
        else if (straightflush() == true)
        {
            System.out.println("You got a straight flush!");
            return 50;
        }
		else if (four() == true)
        {
            System.out.println("You got a four of a kind!");
            return 25;
        }
        else if (full() == true)
        {
            System.out.println("You got a full house!");
            return 6;
        }
        else if (flush() == true)
        {
            System.out.println("You got a flush!");
            return 5;
        }
        else if (straight() == true)
        {
            System.out.println("You got a straight!");
            return 4;
        }
        else if (three() == true)
        {
            System.out.println("You got a three of a kind!");
            return 3;
        }
        else if (two() == true)
        {
            System.out.println("You got a two pair!");
            return 2;
        }
        else if (pair() == true)
        {
            System.out.println("You got a pair!");
            return 1;
        }
        else
        {
            System.out.println("Sorry! You lost.");
            return 0;
        }
    }
    
	public String toString(){//Print out the hand of the player.
        String cardinhand = "You currently have:\n";
        for (Card element: hand)
        {
            cardinhand += element.toString() + "\n"; 
        }
        return cardinhand;
    }
    
    public boolean straightflush(){//Method of Straight Flush
        return (straight() && flush());
    }
    
    public boolean pair(){//Method of Pair
        boolean dup = false;
        int counter = 0;
        for (int i = 0; i < hand.size() - 1; i++)
        {
            for (int j = i + 1; j < hand.size(); j++)
            {
                if (hand.get(i).ranks() == hand.get(j).ranks())
                {
                    counter += 1;
                }
            }
            if (counter == 1)
            {
                dup = true;
            }
        }
        return dup; 
    }
    
    public boolean two(){ //Method for Two Pairs
        int counter = 0;
        boolean dup = false; 
        for (int i = 0; i < hand.size() - 1; i ++)
        {
            if(hand.get(i).ranks() == hand.get(i + 1).ranks())
            {
                counter += 1; 
            }
            if (counter == 2)
            {
                dup = true;
            }
        }
        return dup;
    }
    
    public boolean three(){//Method of Three of a kind
        int counter = 0;
        boolean dup = false; 
        for (int i = 0; i < hand.size() - 2; i++)
        {
            if (hand.get(i).ranks() == hand.get(i + 2).ranks())
            {
                counter += 1;
            }
            if (counter == 1)
            {
                dup = true;
            }
        }
        return dup;
    }
    
    public boolean four(){//Method of Four of a Kind
        boolean dup = false;
        int counter = 0;
        for (int i = 0; i < 2; i++)
        {
            if (hand.get(i).ranks() == hand.get(i + 3).ranks())
            {
                counter += 1;
            }
            if (counter == 1)
            {
                dup = true;
            }
        }
        return dup;
    }
 
    public boolean full(){//Method of Full House
        boolean dup = false;
        if (hand.get(0).ranks() == hand.get(1).ranks()
           && hand.get(2).ranks() == hand.get(4).ranks())
        {
            dup = true;
        }
        else if (hand.get(0).ranks() == hand.get(2).ranks()
           && hand.get(3).ranks() == hand.get(4).ranks())
        {
            dup = true;
        }
        return dup;
    }
    
    public boolean flush(){//Method of Flush
        boolean dup = false;
        int counter = 0;
        for (int i = 1; i < hand.size(); i++)
        {
            if (hand.get(0).suits() == hand.get(i).suits())
            {
                counter ++;
            }
            if (counter == 4)
            {
                dup = true;
            }
        }
        return dup;
    }
    
    public boolean straight(){//Method of Straight 
        boolean dup = false;
        int counter = 0;
        for (int i = 0; i < hand.size() - 1; i++)
        {
            if (hand.get(i).ranks() + 1 == hand.get(i + 1).ranks())
            {
                counter += 1;
            }
            if (counter == 4)
            {
                dup = true;
            }
        }
        return dup;
    }
    
    public boolean royal(){//Method of Royal Flush
        boolean dup = false;
        for (int i = 1; i < hand.size() - 1; i++)
        {
            if (hand.get(0).ranks() == 1 
                && flush() 
                && hand.get(1).ranks() == 10
                && hand.get(i).ranks() + 1 == hand.get(i + 1).ranks())
            {
                dup = true;
            }
        }
        return dup;
    }
    
    public void replace(){//Method to ask and replace cards
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < 5; i++)
        {
            System.out.print("Would you like to replace: " + hand.get(i)
                           + "?\n");
            answer = input.next();
            while (!answer.equals("yes") && !answer.equals ("no"))
            {
                System.out.print("Please enter yes or no: ");
                answer = input.next();
            }
            if (answer.equals ("yes"))
            {
                hand.set(i,cards.deal());
            }
            answer = "no";
        }
    }
    
    public void answer(){//Method to either play again or stop.
        Scanner input = new Scanner(System.in);
        System.out.print("Would you like to keep playing? (yes/no) : ");
        answer = input.next();
        while (!answer.equals("yes") && !answer.equals ("no"))
            {
                System.out.print("Please enter yes or no: ");
                answer = input.next();
            }
        if (answer.equals ("yes"))
        {
            hand.removeAll(hand);
            play();
        }
        else
        {
            System.out.println("Thanks for playing!");
            System.exit(0);
        }
    }
}
