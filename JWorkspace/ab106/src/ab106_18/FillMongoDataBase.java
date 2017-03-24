package ab106_18;
import org.bson.Document;

import com.mongodb.*;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.*;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.result.*;
import org.bson.Document;
import org.bson.types.ObjectId;


import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class FillMongoDataBase {

	public static void main(String[] args) {
		try{   
		      // 连接到 mongodb 服务
		         MongoClient mongoClient = new MongoClient( "10.120.28.51" , 27017 );
		       
		      // 连接到数据库
		         MongoDatabase mongoDatabase = mongoClient.getDatabase("uuid");  
		       System.out.println("Connect to database successfully");
		       MongoCollection<Document> collection = mongoDatabase.getCollection("original");
		       //Write Operation		       
//		       Document document = new Document("name", "Café Con Leche")
//		               .append("contact", new Document("phone", "228-555-0149")
//		                                       .append("email", "cafeconleche@example.com")
//		                                       .append("location",Arrays.asList(-73.92502, 40.8279556)))
//		               .append("stars", 3)
//		               .append("categories", Arrays.asList("Bakery", "Coffee", "Pastries"));
		       	
		       Document document = new Document("name", "Café Con Leche");
		       
		       
		       collection.insertOne(document);
		       
		       
		        
		      }catch(Exception e){
		        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		     }
		   }
	
}
