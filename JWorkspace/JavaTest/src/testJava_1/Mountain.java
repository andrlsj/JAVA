package testJava_1;

class Atom {
    Atom() {
        System.out.print("atom ");
    }
}

class Rock extends Atom {
    Rock(String type) {
        System.out.print(type);
    }
}


public class Mountain {

	 	Mountain() {
	        super();
	        new Rock("granite ");
	    }

	    public static void main(String[] a) {
	        new Mountain();
	    }

}
