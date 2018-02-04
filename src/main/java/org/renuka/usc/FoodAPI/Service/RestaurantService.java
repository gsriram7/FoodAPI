package org.renuka.usc.FoodAPI.Service;

import java.util.List;
import java.util.Map;

import org.renuka.usc.FoodAPI.DBO.Restaurant;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;

public class RestaurantService {
	
	AmazonDynamoDB client;
	DynamoDBMapper mapper;
	public RestaurantService() {
	}
	
	public Restaurant addRestuarant(Restaurant restaurant) {
		client = AmazonDynamoDBClientBuilder.standard().build();
		mapper = new DynamoDBMapper(client);
		System.out.println(restaurant.toString());
		mapper.save(restaurant);
		return restaurant;
	}
	
	public Restaurant getRestaurant(String restaurantId) {
		 Restaurant restaurant = mapper.load(Restaurant.class, restaurantId);
		 return restaurant;
	}
	
	public List<Map<String, AttributeValue>> getAllRestaurants() {
		ScanRequest scanRequest = new ScanRequest().withTableName("Restaurant");
		ScanResult result = client.scan(scanRequest);
		return result.getItems();
	}
	
	public boolean deleteRestaurant() {
		return false;
	}
	
}
