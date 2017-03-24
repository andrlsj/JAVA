package testJava_1;

import java.util.*;

public class TestVector1 {

	public static void main(String[] args) {
		Vector vt = new Vector();
		vt.addElement(new Integer(12));
		vt.addElement(new Long(34L));
		vt.addElement(new Float(50.5f));
		vt.addElement(new Double(7.8));
		vt.addElement(new String("Hello"));
		
		for(int i = 0;i<vt.size();i++){
			Object obj = vt.elementAt(i);
			System.out.println(obj);		
		}
		
		for(Object obj:vt){
			System.out.println(obj);
		}
		
		
		
	}

}
