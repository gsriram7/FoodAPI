package org.renuka.usc.FoodAPI.store;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;

public class DynamoDBFactory {
		private static AmazonDynamoDB client;
		private static DynamoDBMapper mapper;
		private static DynamoDB db;

		private DynamoDBFactory(){}
	   
	    public static DynamoDBMapper getMapperInstance(){
	        if(mapper == null){
	    		mapper = new DynamoDBMapper(getDBInstance());
	        }
	        return mapper;
	    }
	    public static AmazonDynamoDB getDBInstance(){
	        if(client == null){
	        	client = AmazonDynamoDBClientBuilder.standard().withRegion(Regions.US_WEST_2).build();
	        }
	        return client;
	    }

	    public static DynamoDB getDynamoInstance() {
			if (db == null) {
				db = new DynamoDB(getDBInstance());
			}
			return db;
		}
	     
}
