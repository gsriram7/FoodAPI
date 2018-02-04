package org.renuka.usc.FoodAPI.Resources;

import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.renuka.usc.FoodAPI.DBO.Restaurant;
import org.renuka.usc.FoodAPI.Service.RestaurantService;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;;

@Path("/Restaurant")
public class RestaurantResource {
	RestaurantService restaurantService=new RestaurantService();
	
	@GET
	@Path("/{restaurantId}")
	@Produces(MediaType.TEXT_PLAIN)
	public Restaurant getRestaurant(@PathParam("restaurantId")String id) {
		return restaurantService.getRestaurant(id);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Map<String, AttributeValue>> getAllRestaurants() {
		return restaurantService.getAllRestaurants();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Restaurant addRestaurant(Restaurant restaurant) {
		System.out.println("*******************"+restaurant.toString());
		return restaurantService.addRestuarant(restaurant);
	}
}
