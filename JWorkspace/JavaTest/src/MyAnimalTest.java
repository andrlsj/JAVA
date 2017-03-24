
public class MyAnimalTest {

	public static void main(String[] args) {
		Bird bird = new Bird();
		bird.breath();
		bird.fly();
		System.out.println("================");
		Wolf wolf = new Wolf();
		wolf.breath();
		wolf.run();
	}

}

class Animal1{
	
	private void beat(){
		System.out.println("heat jump");
	}
	public void breath(){
		beat();
		System.out.println("breath like the wind");
	}
	
}

class Bird extends Animal1{
	
	public void fly(){
		System.out.println("flying in the sky");
	}
}

class Wolf extends Animal1{
	
	public void run(){
		System.out.println("running in the filed");
	}
}


