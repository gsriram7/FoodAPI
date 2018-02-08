package org.renuka.usc.FoodAPI.service;

import java.util.List;
import java.util.Map;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import org.renuka.usc.FoodAPI.model.MenuItem;
import org.renuka.usc.FoodAPI.resources.MenuItemResource;

public interface MenuItemService {

	boolean addMenuItem(MenuItem menuItem);

	Map<String, Object> getMenuItemById(String menuItemId);

	List<Map<String, AttributeValue>> getAllMenuItems();

	List<MenuItemResource> getMenuItemsByMenuId(String restaurantId);

	List<MenuItemResource> getMenuItemsByRestaurantId(String restaurantId);

	boolean deleteMenuItem(String menuItemId);

	boolean deleteMenuItemsOfMenu(String menuId);

	boolean deleteMenuItemsOfRestaurant(String restaurantId);

}
