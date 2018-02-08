package org.renuka.usc.FoodAPI.DBO;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName="Restaurant")
public class Restaurant {

	String restaurantId;
	String name;
	String address;
	String cuisine;
	Double rating;
	String contact;
	String hrsOpen;
	String avgCost;
	
	/*public Restaurant() {
		// TODO Auto-generated constructor stub
	}
	
	public Restaurant(String restaurantId, String name, String address, String cuisine, Double rating, String contact,
			String hrs_open, String avgCost) {
		super();
		this.restaurantId = restaurantId;
		this.name = name;
		this.address = address;
		this.cuisine = cuisine;
		this.rating = rating;
		this.contact = contact;
		this.hrs_open = hrs_open;
		this.avgCost = avgCost;
	}*/

	 @DynamoDBHashKey(attributeName = "restaurantId")
	public String getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(String restaurantId) {
		this.restaurantId = restaurantId;
	}

	@DynamoDBAttribute(attributeName = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@DynamoDBAttribute(attributeName = "address")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@DynamoDBAttribute(attributeName = "cuisine")
	public String getCuisine() {
		return cuisine;
	}

	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}

	@DynamoDBAttribute(attributeName = "rating")
	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	@DynamoDBAttribute(attributeName = "contact")
	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@DynamoDBAttribute(attributeName = "hrsOpen")
	public String getHrsOpen() {
		return hrsOpen;
	}

	public void setHrsOpen(String hrsOpen) {
		this.hrsOpen = hrsOpen;
	}

	@DynamoDBAttribute(attributeName = "AvgCost")
	public String getAvgCost() {
		return avgCost;
	}

	public void setAvgCost(String avgCost) {
		this.avgCost = avgCost;
	}

}
