package ch05;

import java.util.*;

public class ListSystemProperties {
	public static void main(String[] args) {

		// 取出所有系統屬性
		Properties p = System.getProperties();
		// 列出所有屬性內容(Key/Value)
		p.list(System.out);

		
	}
}
