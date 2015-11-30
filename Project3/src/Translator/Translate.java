package Translator;

import java.util.HashMap;
import java.util.Map;

public class Translate {

	public String translateAction(String strIn, HashMap<String, String> map){
		String out = "";
		HashMap <String, String> tmpMap = new HashMap<String, String>(map);
		for(String element : strIn.split(" ")){
			for(Map.Entry<String, String> i: tmpMap.entrySet()){
				if(element.equalsIgnoreCase(i.getKey())){
					out += i.getValue() + " ";
				}
			}
		}		
		return out;
	}
}
