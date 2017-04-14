package test2;

import java.util.ArrayList;

public class Test2 {
	
	//test cases
	static final String testcase1 = "The quick <font color=\"brown\">brown</font> for jumps over the <i>lazy</i> dog"; 
	
	static final char TAG_START = '<';
	static final char TAG_END = '>';
	static final char TAG_SLASH = '/';
	static final char SPACE = ' ';

	
	public Test2()
	{
		//char[] result = reverseWithTag(testcase1);
		//System.out.print("test result : ");
		//System.out.println(result);
		
		//System.out.print("test result : ");
		//System.out.println(reverseString(testcase1));
		
		reverseWithTag(testcase1);
	}
	
	private void reverseWithTag(String data)
	{
		String rString = reverseString(data);
		System.out.println(rString);
		
				
		char[] cData = rString.toCharArray();	
		
		int nTagStartIndex = 0;
		int nTagEndIndex = 0;
		
		//find tags and reverse word
		for(int i=0 ; i<cData.length-1; i++)
		{
			if(cData[i]==TAG_END)
			{
				nTagStartIndex= i;
			}
			else if(cData[i]==TAG_START)
			{
				nTagEndIndex = i;
				cData = reverseStringWithIndex(cData, nTagStartIndex, nTagEndIndex);
			}
		}
		
		String sibal2 = String.valueOf(cData);
		System.out.println(sibal2);
				
		
		//switch tags
		for(int i=0 ; i<cData.length-1; i++)
		{
			
			//find start TAG
			if(cData[i]==TAG_START)
			{
				nTagStartIndex= i;
			}
			else if(cData[i]==TAG_END)
			{
				nTagEndIndex = i;
			}
			
			//find end TAG
			
			
			
		}
		
		
	}
	
	private ArrayList<String> splitword(String s)
	{
		ArrayList<String> result = new ArrayList<String>();
		return result;
	}
	
	private String reverseString(String s)
	{
		return (new StringBuffer(s)).reverse().toString();
	}
	
	private char[] reverseStringWithIndex(char[] c, int start, int end)
	{
		while (start < end)
		{
			char temp = c[start];
			c[start]=c[end];
			c[end]= temp;
			
			start++;
			end--;
		}
		
		return c; 
	}
	
	

}
