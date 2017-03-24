package idv.david.additional.sort;

import java.util.*;

public class Test_FIFO_List {
	public static void main(String[] args) {
		List list = new Vector();
		list.add("c");
		list.add("a");
		list.add("b");
		list.add("a");
		System.out.println(list.toString());

		for (int i = 0; i < list.size(); i++)
			System.out.println(list.get(i));
	}
}