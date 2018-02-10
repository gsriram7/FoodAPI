package org.renuka.usc.FoodAPI.resources;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import org.renuka.usc.FoodAPI.implementation.MenuItemServiceImpl;
import org.renuka.usc.FoodAPI.model.MenuItem;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;

@Path("menuitem")
public class MenuItemResource {
    MenuItemServiceImpl menuItemService = new MenuItemServiceImpl();

    @GET
    @Path("/{menuitemId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> getMenuItem(@PathParam("menuitemId") String id) {
    	System.out.println("Service call OK"+id);
        return menuItemService.getMenuItemById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Map<String, AttributeValue>> getAllMenuItems() {
        List<Map<String, AttributeValue>> menu = menuItemService.getAllMenuItems();
        System.out.println(menu);
        return menu;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String addMenuItem(MenuItem item) {
    	System.out.println(item.toString());
        return Boolean.toString(menuItemService.addMenuItem(item));
    }

    @DELETE
    @Path("/delete/{menuitemId}")
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteMenuItem(@PathParam("menuitemId") String id) {
    	System.out.println("Service Request OK"+id);
        return Boolean.toString(menuItemService.deleteMenuItem(id));
    }

}