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
    @Path("/{itemId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> getMenuItem(@PathParam("itemId") String id) {
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
        return Boolean.toString(menuItemService.addMenuItem(item));
    }

    @DELETE
    @Path("/delete/{itemId}")
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteMenuItem(@PathParam("itemId") String id) {
        return Boolean.toString(menuItemService.deleteMenuItem(id));
    }

}