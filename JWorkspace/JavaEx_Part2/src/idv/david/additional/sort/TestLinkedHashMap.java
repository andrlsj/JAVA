package idv.david.additional.sort;

import java.util.*;

public class TestLinkedHashMap {
	public static void main(String[] args) {

//		Map<Integer , String> map = new HashMap<Integer , String>();
//		Map<Integer, String> map = new TreeMap<Integer, String>(); // TreeMap的Key值要同一種資料型別
		Map<Integer , String> map = new LinkedHashMap<Integer , String>();
		
		for (int i = 6 ; i > 0 ; i--) {
			map.put(i, "David" + i);
		}
		for (String val : map.values()) {
			System.out.println(val);
		}
	}
}

/*
 * HashMap 可能輸出結果： 
 * David2 
 * David4 
 * David1 
 * David3 
 * David5 
 * David0
 */

/*
 * TreeMap 輸出結果： 
 * David0 
 * David1 
 * David2 
 * David3 
 * David4 
 * David5
 */


