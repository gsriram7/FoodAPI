package org.renuka.usc.FoodAPI.resources;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import org.renuka.usc.FoodAPI.implementation.MenuServiceImpl;
import org.renuka.usc.FoodAPI.model.Menu;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;

@Path("menu")
public class MenuResource {
    MenuServiceImpl menuService = new MenuServiceImpl();

    @GET
    @Path("/{menuId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> getMenu(@PathParam("menuId") String id) {
        return menuService.getMenuById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Map<String, AttributeValue>> getAllMenus() {
        List<Map<String, AttributeValue>> menu = menuService.getAllMenu();
        System.out.println(menu);
        return menu;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String addMenu(Menu menu) {
    	System.out.println(menu.toString());
        return Boolean.toString(menuService.addNewMenu(menu));
    }

    @DELETE
    @Path("/delete/{menuId}")
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteMenu(@PathParam("menuId") String id) {
        return Boolean.toString(menuService.deleteMenu(id));
    }

    @DELETE
    @Path("/delete/menu/{menuId}")
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteItems(@PathParam("menuId") String id) {
        return Boolean.toString(menuService.deleteMenuItemsOfTheMenu(id));
    }
    
   /* @DELETE
    @Path("/delete/restaurant/{restaurantId}")
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteMenusOfRestaurant(@PathParam("restaurantId") String id) {
        return Boolean.toString(menuService.deleteMenuOfRestaurant(id));
    }*/

}