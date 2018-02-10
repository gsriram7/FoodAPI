package org.renuka.usc.FoodAPI.resources;

import java.util.List;
import java.util.Map;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.renuka.usc.FoodAPI.implementation.MenuServiceImpl;
import org.renuka.usc.FoodAPI.implementation.RestaurantServiceImpl;
import org.renuka.usc.FoodAPI.model.Restaurant;
import org.renuka.usc.FoodAPI.service.RestaurantService;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;;

@Path("restaurant")
public class RestaurantResource {
    RestaurantService restaurantService = new RestaurantServiceImpl();

    @GET
    @Path("/{restaurantId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> getRestaurant(@PathParam("restaurantId") String id) {
        return restaurantService.getRestaurant(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Map<String, AttributeValue>> getAllRestaurants() {
        //System.out.println(restaurantService.getAllRestaurants());
        return restaurantService.getAllRestaurants();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String addRestaurant(Restaurant restaurant) {
    	System.out.println(restaurant.toString());
        return Boolean.toString(restaurantService.addRestaurant(restaurant));
    }

    @DELETE
    @Path("/delete/{restaurantId}")
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteRestaurant(@PathParam("restaurantId") String id) {
        return Boolean.toString(restaurantService.deleteRestaurant(id));
    }

    @DELETE
    @Path("/delete/menu/{restaurantId}")
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteMenuForRestaurant(@PathParam("restaurantId") String id) {
        return Boolean.toString(restaurantService.deleteMenuOfRestaurant(id));
    }

    @DELETE
    @Path("/delete/menuitems/{restaurantId}")
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteMenuItemForRestaurant(@PathParam("restaurantId") String id) {
        return Boolean.toString(restaurantService.deleteMenuItemsOfRestaurant(id));
    }

}
