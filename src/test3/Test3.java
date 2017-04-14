package test3;

public class Test3 {
	
	//test cases
	
	
	static final char[][] t1_p1 = {{'A','s'}, {'8','d'}, {'A','d'}, {'8','c'}, {'5','d'}};
	static final char[][] t1_p2 = {{'Q','h'}, {'Q','s'}, {'J','d'}, {'K','d'}, {'J','c'}};
	
	static final char[][] t2_p1 = {{'K','s'}, {'K','c'}, {'J','d'}, {'K','d'}, {'J','c'}};
	static final char[][] t2_p2 = {{'J','h'}, {'J','s'}, {'J','d'}, {'K','d'}, {'J','c'}};
	
	static final char[][] t3_p1 = {{'A','d'}, {'K','h'}, {'A','c'}, {'7','h'}, {'7','d'}};
	static final char[][] t3_p2 = {{'A','h'}, {'K','h'}, {'A','c'}, {'7','h'}, {'7','d'}};
	
	
	
	static final char[][] test_player = {{'4','h'}, {'5','h'}, {'6','h'}, {'7','h'}, {'8','d'}};
	
	
	public Test3()
	{
		//game1
		Poker g1Player1 = new Poker(t1_p1);
		Poker g1Player2 = new Poker(t1_p2);
		
		Poker.play(g1Player1, g1Player2);
		
		
		//game2
		Poker g2Player1 = new Poker(t2_p1);
		Poker g2Player2 = new Poker(t2_p2);
		
		Poker.play(g2Player1, g2Player2);
		
		
		
		//game3
		Poker g3Player1 = new Poker(t3_p1);
		Poker g3Player2 = new Poker(t3_p2);
		
		Poker.play(g3Player1, g3Player2);
		
		
		//test
		Poker tp = new Poker(test_player);
	}

}
