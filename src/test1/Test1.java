package test1;

public class Test1 {
	
	//test cases
	static final int[] testcase1 = {};
	static final int[] testcase2 = {1};
	static final int[] testcase3 = {1,3};
	static final int[] testcase4 = {1,2,3};
	static final int[] testcase5 = {1,2,3,6,8,9,10};
	static final int[] testcase6 = {13,14,15,16,20,23,24,25,100};
	
	static final String TILDE = "~";
	static final String COMMA = ", ";
	
	
	public Test1()
	{
		String result1 = Readnumbers(testcase1);
		System.out.print("test case 1 : ");
		System.out.println(result1);
		
		String result2 = Readnumbers(testcase2);
		System.out.print("test case 2 : ");
		System.out.println(result2);
		
		String result3 = Readnumbers(testcase3);
		System.out.print("test case 3 : ");
		System.out.println(result3);
		
		String result4 = Readnumbers(testcase4);
		System.out.print("test case 4 : ");
		System.out.println(result4);
		
		String result5 = Readnumbers(testcase5);
		System.out.print("test case 5 : ");
		System.out.println(result5);
		
		String result6 = Readnumbers(testcase6);
		System.out.print("test case 6 : ");
		System.out.println(result6);
		
	}
	
	private String Readnumbers(int[] data)
	{
		
		String result = "";	

		//Numbers
		int nPrevNumber = -1;
		int nStartNumber = -1;
		int nStartPosition = -1;
		int nEndNumber = -1;
		
		
		//flag
		boolean bSequenceFlag = false;
		
		//empty case
		if(data.length<=0)
		{
			return result;
		}
		
		for(int i=0; i<data.length; i++)
		{
			if(i==0)
			{
				result+= data[0];
			}
			else
			{
				if(nPrevNumber + 1 == data[i])
				{
					if(bSequenceFlag==false)
					{
						bSequenceFlag = true;
						result += TILDE;
					}
					else//true
					{
						if(i==data.length-1)
						{
							result += data[i];
						}
					}
					
				}
				else
				{
					if(bSequenceFlag == true)
					{
						bSequenceFlag= false;
						result += data[i-1];
						result += COMMA;
						result += data[i];
					}
					else
					{
						result += COMMA;
						result += data[i];
					
					}
					
				}
			}
			nPrevNumber = data[i];
		}
		
		return result;
		
	}
	
 	
}
