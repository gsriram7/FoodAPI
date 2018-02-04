package org.renuka.usc.FoodAPI.Service;

import java.util.List;

import org.renuka.usc.FoodAPI.Resources.MenuResource;

public class MenuService {

	public MenuService() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean addMenuToRestaurant(MenuResource menu,String restaurantId) {
		return false;
	}
	
	public String getMenuByName(String name) {
		return "";
	}
	
	public String getMenuById(String menuId) {
		return "";
	}
	
	public List<MenuResource> getAllMenu() {
		return null;
	}
	
	public List<MenuResource> getRestaurantMenuByName(String restaurantName){
		return null;
	}
	
	public List<MenuResource> getRestaurantMenuById(String restaurantId){
		return null;
	}
	
	public boolean deleteMenu(String menuId) {
		return false;
	}
	
	public boolean deleteMenuOfRestaurant(String RestaurantId) {
		return false;
	}
}
