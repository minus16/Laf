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
	
	
	private static final char[] RANKS  = { 'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K' };
	private static final char[] EMBLEM = { 's', 'd', 'h', 'c' };
	
	
	private char[][] mHand = null;
	
	private int [] numbers = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };//13
	private int [] emblem = {0, 0, 0, 0};//4
	
	private int myRank;
	
	
	public Poker(char[][] c)
	{
		mHand = c;
		myRank = getRank();
		
		System.out.println("MyRank : " + myRank);
	}
	
	private int getRank()
	{
		int rank = HIGH_CARD;

		for(int i=0 ; i < mHand.length ; i++)
		{
			for(int j=0 ; j < mHand[i].length; j++)
			{
				//System.out.println(mHand[i][j]);
				if(j==0)//numbers
				{
					numbers[getRankFromNumber(mHand[i][j])]++;
				}
				else //emblem
				{
					emblem[getRankFromEmblem(mHand[i][j])]++;
				}	
			}
		}
		
		//find sameNumbers
		int pairs = 0;
		int triple = 0;
		int fourcard = 0;
		
		//find straight
		int Straight = 0;
		boolean bStraight = false;
		
		for(int i=0 ; i<numbers.length ; i++)
		{
			//System.out.println(numbers[i]);
			
			switch(numbers[i])
			{
				
				case 0:
					Straight=0;
					break;
					
				case 1:
					Straight++;
					break;
					
				case 2:
					pairs++;
					Straight=0;
					break;
					
				case 3:
					triple++;
					Straight=0;
					break;
					
				case 4:
					fourcard++;
					Straight=0;
					break;
					
				default:
					Straight=0;
					break;
						
			}
			
			//straight
			if(Straight >= 5)
				bStraight= true;
		}
		
		
		//find sameEmblem
		boolean bFlush = false;
		for(int i=0 ; i<emblem.length ; i++)
		{
			if(emblem[i] > 4)
			{
				bFlush = true;
			}
		}
		
		//ONE_PAIR
		if(pairs==1)
		{
			rank = ONE_PAIR;
		}
		//TWO_PAIR
		if(pairs>1)
		{
			rank = TWO_PAIR;
		}
		//TRIPLE
		if(triple>0)
		{
			rank = TRIPLE;
		}
		//STRAIGHT
		if(bStraight==true)
		{
			rank = STRAIGHT;
		}
		//FLUSH
		if(bFlush==true && bStraight==false)
		{
			rank = FLUSH;
		}
		//FULL_HOUSE
		if(triple > 0 && pairs > 0)
		{
			rank = FULL_HOUSE;
		}
		//FOUR_CARD
		if(fourcard > 0)
		{
			rank = FOUR_CARD; 
		}
		//STRAIGHT_FLUSH
		if(bFlush==true && bStraight==true)
		{
			//ROYAL_FLUSH
			if(numbers[0]>0 && numbers[9]>0 && numbers[10]>0 && numbers[11]>0 && numbers[12]>0)
			{
				rank = ROYAL_FLUSH;
			}
			//STRAIGHT_FLUSH
			else
			{
				rank = STRAIGHT_FLUSH;
			}
		}
		//ROYAL_FLUSH
		 

		//HIGH_CARD	
		return rank;
	}
	
	
	public static int play(Poker p1, Poker p2)
	{
		int rank1  = p1.getRank();
		int rank2  = p2.getRank();
		if(rank1>rank2)
		{
			System.out.println("Player 1 win");
			return 1;
		}
		else if(rank1<rank2)
		{
			System.out.println("Player 2 win");
			return 2;
		}
		else if(rank1==rank2)
		{
			System.out.println("Draw");
			return 0;
		}
		else
		{
			return -1;
		}
	}
	
	
	//get number rank
	private int getRankFromNumber(char c)
	{
		for(int i=0 ; i < RANKS.length ; i++)
		{
			if(RANKS[i]==c)
			{
				return i;
			}
		}
		
		return -1;
	}
	
	//get emblem rank
	private int getRankFromEmblem(char c)
	{
		for(int i=0 ; i < EMBLEM.length ; i++)
		{
			if(EMBLEM[i]==c)
			{
				return i;
			}
		}
		
		return -1;
	}

}
