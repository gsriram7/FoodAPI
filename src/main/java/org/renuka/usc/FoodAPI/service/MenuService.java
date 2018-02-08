package org.renuka.usc.FoodAPI.service;

import java.util.List;
import java.util.Map;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import org.renuka.usc.FoodAPI.model.Menu;
import org.renuka.usc.FoodAPI.resources.MenuResource;

public interface MenuService {
	boolean addNewMenu(Menu menu);
	Map<String, Object> getMenuById(String menuId);
	List<Map<String, AttributeValue>> getAllMenu();
	List<MenuResource> getRestaurantMenuByName(String restaurantName);
	List<MenuResource> getRestaurantMenuById(String restaurantId);
	boolean deleteMenu(String menuId);
	boolean deleteMenuOfRestaurant(String restaurantId);
	boolean deleteMenuItemsOfTheMenu(String menuId);
}
