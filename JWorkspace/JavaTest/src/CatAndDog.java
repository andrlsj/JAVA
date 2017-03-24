import java.io.Serializable;

public abstract class CatAndDog implements Serializable {

	private String name;
	
	public CatAndDog(){
	}
	
	public abstract void speak();
}
