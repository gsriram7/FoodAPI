package org.renuka.usc.FoodAPI.DBO;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

public class DBConnection {
		private static AmazonDynamoDB client;
		private static DynamoDBMapper mapper;
		
		private DBConnection(){
	         
	    }
	   
	    public static DynamoDBMapper getMapperInstance(){
	        if(mapper == null){
	        	client = AmazonDynamoDBClientBuilder.standard().withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("http://localhost:8000", "us-west-2")).build(); 
	    		mapper = new DynamoDBMapper(client);
	        }
	        return mapper;
	    }
	    public static AmazonDynamoDB getDBInstance(){
	        if(client == null){
	        	client = AmazonDynamoDBClientBuilder.standard().withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("http://localhost:8000", "us-west-2")).build(); 
	        }
	        return client;
	    }
	     
}
