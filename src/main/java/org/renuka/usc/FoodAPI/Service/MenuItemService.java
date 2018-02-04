package org.renuka.usc.FoodAPI.Service;

import java.util.List;

import org.renuka.usc.FoodAPI.Resources.MenuItemResource;

public class MenuItemService {

	public MenuItemService() {
		// TODO Auto-generated constructor stub
	}
	public boolean addMenuItemToMenu(MenuItemResource menuItem, String MenuId) {
		return false;
	}
	
	public String getMenuItemByName(String name) {
		return "";
	}
	
	public String getMenuItemById(String menuItemId) {
		return "";
	}
	
	public List<MenuItemResource> getAllMenuItems() {
		return null;
	}
	
	public List<MenuItemResource> getMenuItemsByMenuId(String restaurantId){
		return null;
	}
	
	public List<MenuItemResource> getMenuItemsByRestaurantId(String restaurantId){
		return null;
	}
	
	public List<MenuItemResource> getMenuItemsByRestaurantName(String restaurantName){
		return null;
	}
	
	public boolean deleteMenuItem(String menuItemId) {
		return false;
	}
	
	public boolean deleteMenuItemsOfMenu(String MenuId) {
		return false;
	}
	
	public boolean deleteMenuItemsOfRestaurant(String RestaurantId) {
		return false;
	}

}
