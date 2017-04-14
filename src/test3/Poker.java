package test3;

public class Poker {
	
	static final int HIGH_CARD 		= 100;
	static final int ONE_PAIR  		= 101;
	static final int TWO_PAIR  		= 102;
	static final int TRIPLE    		= 103;
	static final int STRAIGHT  		= 104;
	static final int FLUSH	   		= 105;
	static final int FULL_HOUSE  	= 106;
	static final int FOUR_CARD  	= 107;
	static final int STRAIGHT_FLUSH = 108;
	static final int ROYAL_FLUSH  	= 109;
	
	
	/*
	 * 	
	static final char[][] t1_p1 = {{'A','s'}, {'8','d'}, {'A','d'}, {'8','c'}, {'5','d'}};
	static final char[][] t1_p2 = {{'Q','h'}, {'Q','s'}, {'J','d'}, {'K','d'}, {'J','c'}};
	
	static final char[][] t2_p1 = {{'K','s'}, {'K','c'}, {'J','d'}, {'K','d'}, {'J','c'}};
	static final char[][] t2_p2 = {{'J','h'}, {'J','s'}, {'J','d'}, {'K','d'}, {'J','c'}};
	
	static final char[][] t3_p1 = {{'A','d'}, {'K','h'}, {'A','c'}, {'7','h'}, {'7','d'}};
	static final char[][] t3_p2 = {{'A','h'}, {'K','h'}, {'A','c'}, {'7','h'}, {'7','d'}};
	 */
	
	private char[][] mHand = null;
	
	private int myGrade;
	
	
	public Poker(char[][] c)
	{
		mHand = c;
		myGrade = getMyGrade();
	}
	
	private int getMyGrade()
	{
		//ROYAL_FLUSH
		
		//STRAIGHT_FLUSH
		
		//FOUR_CARD
		
		//FULL_HOUSE
		
		//FLUSH
		
		//STRAIGHT
		
		//TRIPLE
		
		//TWO_PAIR
		
		//ONE_PAIR
		
		//HIGH_CARD
		
		
		return 0;
	}
	
	
	public int play(Poker p1, Poker p2)
	{
		return 0;
	}

}
