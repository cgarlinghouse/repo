package api;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.json.stream.*;

public class JsonUtils {

	public static void parseJson(String iJsonString) {
		String result = "";
		String[] resultList;
		//Matcher m = Pattern.compile("\\{([^)]+)\\}").matcher(iJsonString);
		//Matcher start = Pattern.compile("\\{").matcher(iJsonString);
		Matcher end = Pattern.compile("\\}").matcher(iJsonString);
		
		int c = 0;
		
		while(end.find()) {
			c=c+1;
			System.out.println("Start: " + end.start());
			
		}
		
		System.out.println("Number of matches: " + c);
		
		
		
		
		/* while(m.find()) {
			result = m.group(1);
			resultList = result.split(",");
			System.out.println(result);
			
			for (String s : resultList) {
				System.out.println(s);
			}
			
		} */
	}

}
