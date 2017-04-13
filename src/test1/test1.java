package test1;

public class test1 {
	
	//test cases
	static final char[] testcase1 = {};
	static final char[] testcase2 = {1};
	static final char[] testcase3 = {1,3};
	static final char[] testcase4 = {1,2,3};
	static final char[] testcase5 = {1,2,3,6,8,9,10};
	static final char[] testcase6 = {13,14,15,16,20,23,24,25,100};
	
	
	public test1()
	{
		Readnumbers(testcase1);
		Readnumbers(testcase2);
		Readnumbers(testcase3);
		Readnumbers(testcase4);
		Readnumbers(testcase5);
		Readnumbers(testcase6);
		
	}
	
	public void Readnumbers(char[] data)
	{
		System.out.println(data);
	}
	
}
