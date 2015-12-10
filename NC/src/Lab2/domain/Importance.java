package Lab2.domain;

import java.util.HashMap;
import java.util.Map;

public enum Importance {
	FIRST(1, "."),
	SECOND(2, "!.."),
	THRID(3, ""),
	FOURTH(4, "");

	int value;
	String string;

	private static Map<String, Importance> iii = new HashMap<>();

	static {
		for(Importance i: Importance.values()){
			iii.put(i.string, i);
		}
	}

	public static Importance getImp(String s){
		return iii.get(s);
	}

	Importance(int val, String str){
		value = val;
		string =str;
	}
}
