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
	String hrs_open;
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

	 @DynamoDBHashKey(attributeName = "RestaurantId")
	public String getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(String restaurantId) {
		this.restaurantId = restaurantId;
	}

	@DynamoDBAttribute(attributeName = "Name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@DynamoDBAttribute(attributeName = "Address")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@DynamoDBAttribute(attributeName = "Cuisine")
	public String getCuisine() {
		return cuisine;
	}

	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}

	@DynamoDBAttribute(attributeName = "Rating")
	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	@DynamoDBAttribute(attributeName = "Contact")
	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@DynamoDBAttribute(attributeName = "Hrs_open")
	public String getHrs_open() {
		return hrs_open;
	}

	public void setHrs_open(String hrs_open) {
		this.hrs_open = hrs_open;
	}

	@DynamoDBAttribute(attributeName = "AvgCost")
	public String getAvgCost() {
		return avgCost;
	}

	public void setAvgCost(String avgCost) {
		this.avgCost = avgCost;
	}

}
