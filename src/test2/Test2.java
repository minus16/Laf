package test2;

import java.util.ArrayList;

public class Test2 {
	
	//test cases
	static final String testcase1 = "The quick <font color=\"brown\">brown</font> for jumps over the <i>lazy</i> dog"; 
	
	static final char TAG_START = '<';
	static final char TAG_END = '>';
	static final char TAG_SLASH = '/';

	
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
		ArrayList<String> arr_str = new ArrayList<String>();
		
		String[] splited = data.split("\\s+", -1);
		
		for ( String s :splited)
		{
			System.out.println(s);
		}

	}
	
	private String reverseString(String s)
	{
		return (new StringBuffer(s)).reverse().toString();
	}
	
	

}
