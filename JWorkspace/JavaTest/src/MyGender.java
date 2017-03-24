
public enum MyGender {

	MALE("男"),FEMALE("女");
	//public static final MyGender MALE = new MyGender("男");
	
	private final String name;
	
	private MyGender(String name){
		this.name = name;
	}
	public String getName(){
		return this.name();		
	}
	
	
	//MALE,FEMALE;
	//public String name;
	
	//private String name;
	
//	public void setName(String name){
//		
//		switch(this){
//		
//		case MALE:
//			if(name.equals("男")){
//				this.name = name;
//			}else{
//				System.out.println("wrong");
//			}
//		
//		case FEMALE:
//			if(name.equals("女")){
//				this.name= name;
//			}else{
//				System.out.println("wrong");
//				}		
//			}
//		
//		}
	

	
	
	
}
