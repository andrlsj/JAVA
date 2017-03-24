package example.mongo;

import java.util.Arrays;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.MongoOptions;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;

public class MongoConn {

	public static void main(String[] args) {
		MongoClient mc = new MongoClient("localhost", 27017);
		MongoDatabase db = mc.getDatabase("MyDB");
		
		// 含權限設定與加密的連線
//		MongoCredential credential = MongoCredential.createCredential("David", "MyDB", "123456".toCharArray());
//		MongoClientOptions options = MongoClientOptions.builder().sslEnabled(true).build();
//		MongoClient mc2 = new MongoClient(new ServerAddress("localhost", 27017), Arrays.asList(credential), options);

		mc.close();
//		mc2.close();
	}

}
