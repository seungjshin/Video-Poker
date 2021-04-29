public class Player {
	
		
    private int bankroll;
    private int bet;
    private int e;
		
    public Player(){		
        //create a player
        bankroll = 1000;
        bet = 0;
    }
		
    public void bets(int amt){
        //player makes a bet
        bet = amt;
        bankroll -= bet;
    }

    public void winnings(int odds){
        //adjust bankroll if player wins
        e = odds * this.bet;
        this.bankroll += e;
    }

    public int getBankroll(){
        //return current balance of bankroll
        return this.bankroll;
    }

    public int getBet(){
        return this.bet;
    }
}


