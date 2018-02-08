package org.renuka.usc.FoodAPI.Service;

import java.util.List;
import java.util.Map;

import org.renuka.usc.FoodAPI.DBO.DBConnection;
import org.renuka.usc.FoodAPI.DBO.Restaurant;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;

public class RestaurantService {
	
	
	public RestaurantService() {
	}
	
	
	public Restaurant addRestuarant(Restaurant restaurant) {
		
		System.out.println(restaurant.toString());
		DBConnection.getMapperInstance().save(restaurant);
		return restaurant;
	}
	
	public Restaurant getRestaurant(String restaurantId) {
		 Restaurant restaurant = DBConnection.getMapperInstance().load(Restaurant.class, restaurantId);
		 return restaurant;
	}
	
	public List<Map<String, AttributeValue>> getAllRestaurants() {
		ScanRequest scanRequest = new ScanRequest().withTableName("Restaurant");
		ScanResult result = DBConnection.getDBInstance().scan(scanRequest);
		return result.getItems();
	}
	
	public boolean deleteRestaurant() {
		return false;
	}
	
}
