package test2;

import java.util.ArrayList;
import java.util.Arrays;

public class Test2 {
	
	//test cases
	static final String testcase1 = "The quick <font color=\"brown\">brown</font> for jumps over the <i>lazy</i> dog"; 
	
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
	
	public Test2()
	{
		String result = reverseWithTag(testcase1);
		System.out.println(result);
	}
	
	private String reverseWithTag(String data)
	{
		//tags put in to map
		ArrayList<TagStruct> tags = new ArrayList<TagStruct>();
		tags = tagsToList(data);
		
		//remove tags from String and reverse
		String reverseData = reverseString(removeTags(data));		

		
		//add tags
		int currentPos = -1;
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
				
			}

		}
		return reverseData;
			 
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
	
	
	//reference of this method : http://stackoverflow.com/a/5678546/829571
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
