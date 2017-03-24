
public class AnimalPolttest extends Elephant {

	public static void main(String[] args) {

		Animal[] aniArray = new Animal[2];

		aniArray[0] = new Elephant(2, 1200.0f, "大象");
		aniArray[1] = new Animal(2, 5.0F);

		for (Animal a : aniArray) {
			a.speak();
		}

	}

}
