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
	
	//high numbers
	private int mHighNumber = -1;
	private int mHighPair1 = -1;
	private int mHighPair2 = -1;
	private int mHighTriple = -1;
	
	
	public static final int PLAYER1 = 1;
	public static final int PLAYER2 = 2;
	public static final int DRAW = 0;
	
	
	
	public Poker(char[][] c)
	{
		mHand = c;
		myRank = getRank();
		
		//System.out.println("MyRank : " + myRank);
	}
	
	
	public int getMyRank()
	{
		return myRank;
	}
	
	private int getRank()
	{
		int rank = HIGH_CARD;
		int cRank = 0;

		for(int i=0 ; i < mHand.length ; i++)
		{
			for(int j=0 ; j < mHand[i].length; j++)
			{
				//System.out.println(mHand[i][j]);
				if(j==0)//numbers
				{
					cRank = getRankFromNumber(mHand[i][j]);
					numbers[cRank]++;
					
					//max number
					if(mHighNumber < cRank)
						mHighNumber = cRank;
					
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
					if(mHighPair1==-1)
					{
						mHighPair1=i;
					}
					else
					{
						if(mHighPair1 < i)
						{
							int temp = mHighPair1;
							mHighPair1 = i;
							mHighPair2 = temp;
						}
						else
						{
							mHighPair2 = i;
						}
					}
					break;
					
				case 3:
					triple++;
					Straight=0;
					mHighTriple = i;
					break;
					
				case 4:
					fourcard++;
					Straight=0;
					mHighNumber = i;
					break;
					
				default:
					Straight=0;
					break;
						
			}
			
			
			//for Ace
			if(i==numbers.length-1 && Straight ==4)
			{
				if(numbers[0]==1)
				{
					Straight++;
				}
			}
			
			//straight
			if(Straight >= 5)
				bStraight= true;
		}
		
		//for ace2
		if(mHighPair1 == 0)
			mHighPair1 = 14;
		if(mHighPair2 == 0)
			mHighPair2 = 14;
		if(mHighPair1 < mHighPair2)
		{
			int temp = mHighPair1;
			mHighPair1 = mHighPair2;
			mHighPair2 = temp;
		}		
		if(mHighTriple == 0)
			mHighPair1 = 14;
		
		
		//find sameEmblem for FLUSH
		boolean bFlush = false;
		for(int i=0 ; i<emblem.length ; i++)
		{
			if(emblem[i] > 4)
			{
				bFlush = true;
			}
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
		//FOUR_CARD
		else if(fourcard > 0)
		{
			rank = FOUR_CARD;
		}
		//FULL_HOUSE
		else if(triple > 0 && pairs > 0)
		{
			rank = FULL_HOUSE;
		}
		//FLUSH
		else if(bFlush==true && bStraight==false)
		{
			rank = FLUSH;
		}
		//STRAIGHT
		else if(bStraight==true)
		{
			rank = STRAIGHT;
		}
		//TRIPLE
		else if(triple>0)
		{
			rank = TRIPLE;
		}
		//TWO_PAIR
		else if(pairs>1)
		{
			rank = TWO_PAIR;
		}
		//ONE_PAIR
		else if(pairs==1)
		{
			rank = ONE_PAIR;
		}
		//HIGH_CARD	
		else
		{
			rank = HIGH_CARD;
		}

		
		return rank;
	}
	
	
	public static void play(Poker p1, Poker p2)
	{	
		int result = -1;
		
		int rank1  = p1.getMyRank();
		//System.out.println("rank 1 : " + rank1);
		int rank2  = p2.getMyRank();
		//System.out.println("rank 2 : " + rank2);
		if(rank1>rank2)
		{
			result = PLAYER1;
		}
		else if(rank1<rank2)
		{
			result = PLAYER2;
		}
		else
		{
			//compare HighNumbers	
			result = compareHighNumbers(p1, p2);
		}
		showResult(result);
	}
	private static int compareHighNumbers(Poker p1, Poker p2)
	{
		/*
		System.out.println("mHighNumber : " + p1.mHighNumber);
		System.out.println("mHighPair1 : " + p1.mHighPair1);
		System.out.println("mHighPair2 : " + p1.mHighPair2);
		System.out.println("mHighTriple : " + p1.mHighTriple);

		System.out.println("mHighNumber : " + p2.mHighNumber);
		System.out.println("mHighPair1 : " + p2.mHighPair1);
		System.out.println("mHighPair2 : " + p2.mHighPair2);
		System.out.println("mHighTriple : " + p2.mHighTriple);
		*/
		
		
		int result = DRAW;
		if(p1.mHighTriple > p2.mHighTriple)
		{
			result = PLAYER1;
		}
		else if(p1.mHighTriple < p2.mHighTriple)
		{
			result = PLAYER2;
		}	
		else//
		{
			if(p1.mHighPair1 > p2.mHighPair1)
			{
				result = PLAYER1;
			}
			else if(p1.mHighPair1 < p2.mHighPair1)
			{
				result = PLAYER2;
			}	
			else//
			{
				if(p1.mHighPair2 > p2.mHighPair2)
				{
					result = PLAYER1;
				}
				else if(p1.mHighPair2 < p2.mHighPair2)
				{
					result = PLAYER2;
				}	
				else//
				{
					if(p1.mHighNumber > p2.mHighNumber)
					{
						result = PLAYER1;
					}
					else if(p1.mHighNumber < p2.mHighNumber)
					{
						result = PLAYER2;
					}	
					else//
					{
						 result = DRAW;
					}
				}
			}
		}
		return result;
	}
	
	public static void showResult(int n)
	{
		if(n==PLAYER1)
			System.out.println("Player 1 Win");
		else if(n==PLAYER2)
			System.out.println("Player 2 Win");
		else if(n==DRAW)
			System.out.println("Draw");
		else
			System.out.println("Oops, There is an Error");
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
