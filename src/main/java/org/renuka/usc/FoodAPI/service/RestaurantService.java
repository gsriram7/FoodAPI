package org.renuka.usc.FoodAPI.service;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import org.renuka.usc.FoodAPI.model.Restaurant;

import java.util.List;
import java.util.Map;

public interface RestaurantService {
	
	boolean addRestaurant(Restaurant restaurant);
	Map<String, Object> getRestaurant(String restaurantId);
	List<Map<String, AttributeValue>> getAllRestaurants();
	boolean deleteRestaurant(String id);
    boolean deleteMenuOfRestaurant(String id);
    boolean deleteMenuItemsOfRestaurant(String id);
}
