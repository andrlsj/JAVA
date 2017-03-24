package testJava_1;

import java.util.Enumeration;
import java.util.Properties;

public class TestProperty {

	public static void main(String[] args) {
		Properties props = System.getProperties();
		Enumeration names = props.propertyNames();

		while (names.hasMoreElements()) {
			String name = (String) names.nextElement();
			String val = props.getProperty(name);
			System.out.println("property of " + name + " = " + val);
		}
		
	}
}
