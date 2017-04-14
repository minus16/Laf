package test2;

import java.util.ArrayList;
import java.util.Arrays;

public class Test22 {
	
	//test cases
	static final String testcase1 = "The quick <font color=\"brown\">brown</font> for jumps over the <i>lazy</i> dog"; 
	
	//static final String testcase1 = "The quick <font color=brown>brown</font> for jumps over the <i>lazy</i> dog";
	
	//static final String testcase1 = "The quick brown for jumps over the <i>lazy</i> dog";
	
	static final char TAG_START = '<';
	static final char TAG_END = '>';
	static final char TAG_SLASH = '/';
	static final char SPACE = ' ';
	
	class TagStruct
	{
		public String mTag;
		public int mPositon;
		
		public TagStruct(String s , int i)
		{
			mTag=s;
			mPositon=i;
		}
	}
	
	public Test22()
	{
		reverseWithTag(testcase1);
	}
	
	private void reverseWithTag(String data)
	{
		//tags put in to map
		ArrayList<TagStruct> tags = new ArrayList<TagStruct>();
		tags = tagsToList(data);
		
		//remove tags from String and reverse
		String reverseData = reverseString(removeTags(data));		

		String resultData = reverseData;
		
		//add tags
		int currentPos = -1;
		int nAddtemp = 0;
		int nAdd = 0;
		int nPosition = 0;
		
		int index = 0;
		
		for(TagStruct t : tags)
		{
			int pos = reverseData.split(" ").length - t.mPositon;
						
			if(currentPos == t.mPositon)
			{
				if(nPosition%2==0)
					index = nthIndexOf(reverseData, " ", pos+1-nAdd);
				else
					index = nthIndexOf(reverseData, " ", pos+1);
				
				reverseData = new StringBuffer(reverseData).insert(index, t.mTag).toString();
				nAdd += t.mTag.split(" ").length -1;
				System.out.println("1 nAdd : " + nAdd);
				
				System.out.println("1 mPositon : "+ (int)(pos+1));
				System.out.println("1 index : "+ (index));
			}
			else
			{
				nPosition++;
				if(nPosition%2==0)
					index = nthIndexOf(reverseData, " ", pos+1-nAdd);
				else
					index = nthIndexOf(reverseData, " ", pos+1);
				
				
				currentPos = t.mPositon;
				index = nthIndexOf(reverseData, " ", pos-nAdd);
				reverseData = new StringBuffer(reverseData).insert(index+1, t.mTag).toString();
				
				nAdd += t.mTag.split(" ").length -1;
				
				
				
				
				System.out.println("2 nAdd : " + nAdd);
				
				System.out.println("2 mPositon : "+ pos);
				System.out.println("2 index : " + index);
				
			}
			System.out.println(reverseData);
		}
		

		/*
		for(TagStruct t : tags)
		{		
			//System.out.println("pos : " + t.mPositon + " v : "+ t.mTag);
			
			int pos = reverseData.split(" ").length - t.mPositon -1;
			
			if(currentPos == t.mPositon)
			{
				int index = nthIndexOf(reverseData, " ", pos);
				reverseData = new StringBuffer(reverseData).insert(index, t.mTag).toString();	
				System.out.println("nAdd : " + nAdd);
				
				System.out.println("1 mPositon : "+ (int)(pos+nAdd));
				System.out.println("1 index : "+ (index+1));
			}
			else
			{
				currentPos = t.mPositon;
				
				int index = nthIndexOf(reverseData, " ", pos+1);
				reverseData = new StringBuffer(reverseData).insert(index, t.mTag).toString();
				
				System.out.println("2 mPositon : "+ (int)(pos+1+nAdd));
				System.out.println("2 index : " + index);
				
			}
			System.out.println(reverseData);
			
		}*/

		
		System.out.println(reverseData);
		 
	}
	
	private ArrayList<TagStruct> tagsToList(String s)
	{
		ArrayList<TagStruct> result = new ArrayList<TagStruct>();
		
		int currentMapIndex = 0;
		int index = 0;
		
		char[] cData = s.toCharArray();
		
		StringBuffer sb = new StringBuffer();
		
		boolean bInTag = false;

		while(index < cData.length-1)
		{
			if(cData[index]==SPACE)
			{
				if(!bInTag)
					currentMapIndex++;
			}
			else if(cData[index]==TAG_START)
			{
				sb.delete(0, sb.length());
				//sb.append(cData[index]);
				bInTag = true;
			}
			
			else if(cData[index]==TAG_END)
			{
				sb.append(cData[index]);
				bInTag = false;
				
				//insert to map
				result.add(new TagStruct(sb.toString(), currentMapIndex));
			}
			
			if(bInTag)
				sb.append(cData[index]);
			
			index++;
		}
		
		return result;
	}
	
	public String removeTags(String s) {
	    return s.replaceAll("\\<.*?>","");
	}
	
	
	private ArrayList<String> splitword(String str)
	{
		ArrayList<String> result = new ArrayList<String>(Arrays.asList(str.split(" ")));
		return result;
	}
	
	
	//reference : http://stackoverflow.com/a/5678546/829571
	/*
	private int nthIndexOf(String source, String sought, int n) {
		
		System.out.println("n : " + n);
		
	    int index = source.indexOf(sought);
	    if (index == -1) return -1;

	    for (int i = 1; i < n; i++) {
	        index = source.indexOf(sought, index+1);
	        if (index == -1) return -1;
	    }
	    System.out.println("length : " + source.length());
	    index = source.length()-index-3;
	    System.out.println("index in f : " + index);
	    return index;
	}
	*/
	
	
	public int nthIndexOf(String source, String sought, int n) {
	    int index = source.indexOf(sought);
	    if (index == -1) return -1;

	    for (int i = 1; i < n-1; i++) {
	        index = source.indexOf(sought, index + 1);
	        if (index == -1) return -1;
	    }
	    return index;
	}
	
	
	private String reverseString(String s)
	{
		return (new StringBuffer(s)).reverse().toString();
	}

}
