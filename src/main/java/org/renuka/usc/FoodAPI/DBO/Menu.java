package org.renuka.usc.FoodAPI.DBO;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName="Menu")
public class Menu {

	private String menuId;
	private String category;
	private String noOfItems;
	private String restaurantId;

	/*public Menu() {
		// TODO Auto-generated constructor stub
	}

	public Menu(String menuId, String restaurantID, String category, String noOfItems, String restaurantId2) {
		super();
		this.menuId = menuId;
		this.restaurantID = restaurantID;
		this.category = category;
		this.noOfItems = noOfItems;
		restaurantId = restaurantId2;
	}
*/
	
	 @DynamoDBHashKey(attributeName = "MenuId")
	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	
	 @DynamoDBAttribute(attributeName = "Category")
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	 @DynamoDBAttribute(attributeName = "NoOfItems")
	public String getNoOfItems() {
		return noOfItems;
	}

	public void setNoOfItems(String noOfItems) {
		this.noOfItems = noOfItems;
	}
	
	 @DynamoDBAttribute(attributeName = "RestaurantId")
	public String getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(String restaurantId) {
		this.restaurantId = restaurantId;
	}


}
