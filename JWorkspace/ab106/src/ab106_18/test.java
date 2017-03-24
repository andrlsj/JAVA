package ab106_18;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.*;
import com.mongodb.ConnectionString;
import com.mongodb.ServerAddress;
import com.mongodb.WriteConcern;
import com.mongodb.async.SingleResultCallback;

import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.mongodb.connection.ClusterSettings;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.omg.CORBA.portable.Delegate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.currentDate;
import static com.mongodb.client.model.Updates.set;
import static java.util.Arrays.asList;

public class test 
{
	public static void main(String[] args)
	{
		try
		{
		
			MongoClient mongoClient = new MongoClient("10.120.28.51",27017);
			MongoDatabase mongoDatabase = mongoClient.getDatabase("uuid");
			 MongoCollection<Document> collection = mongoDatabase.getCollection("original");
			for(int i=1; i<10_000_000; i++)
			{
				for(int j=1; j<((int)(Math.random()*5)+1); j++)
				{
					
					UUID uuid  =  UUID.randomUUID();
					String randomUUIDString = uuid.toString();
					Document document = new Document("uuid", randomUUIDString)
							.append("col", i)
							.append("row", j)
							.append("date", new Date());
							//.append("date", value)
					collection.insertOne(document);
				}
			}
			
		}
		catch(Exception e)
		{
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		}
	}
}
