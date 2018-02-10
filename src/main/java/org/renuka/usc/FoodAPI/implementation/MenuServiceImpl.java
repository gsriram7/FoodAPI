package org.renuka.usc.FoodAPI.implementation;

import com.amazonaws.services.dynamodbv2.document.*;
import com.amazonaws.services.dynamodbv2.document.spec.DeleteItemSpec;
import com.amazonaws.services.dynamodbv2.document.spec.ScanSpec;
import com.amazonaws.services.dynamodbv2.document.utils.NameMap;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import org.renuka.usc.FoodAPI.model.Menu;
import org.renuka.usc.FoodAPI.resources.MenuResource;
import org.renuka.usc.FoodAPI.service.MenuService;
import org.renuka.usc.FoodAPI.store.DynamoDBFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuServiceImpl implements MenuService {

    final private String tableName = "Menu";
    private String primaryKey = "MenuId";
    final Table table = DynamoDBFactory.getDynamoInstance().getTable(tableName);

    @Override
    public boolean addNewMenu(Menu menu) {
        boolean status = true;
        try {
            System.out.println("Saving menu to DB" + menu.toString());
            table.putItem(getItem(menu));
        } catch (Exception e) {
            status = false;
            System.out.println("Error occurred while saving menu ID: " + menu.getMenuId());
            System.out.println(e.getMessage());
        }
        return status;
    }

    @Override
    public Map<String, Object> getMenuById(String menuId) {
        Map<String, Object> result = new HashMap<>();
        try {
            Item item = table.getItem(primaryKey, menuId);
            if(item==null) {
            	System.out.println("The menu "+menuId+" doesn't exist");
            	return result;
            }
            result = item.asMap();
        } catch (Exception e) {
            System.out.println("Exception while retrieving Menu ID " + menuId);
            System.out.println(e.getMessage());
        }

        return result;
    }

    @Override
    public List<Map<String, AttributeValue>> getAllMenu() {
        ScanRequest scanRequest = new ScanRequest().withTableName(tableName);
        ScanResult result = DynamoDBFactory.getDBInstance().scan(scanRequest);
        return result.getItems();
    }

    @Override
    public List<MenuResource> getRestaurantMenuByName(String restaurantName) {
        return null;
    }

    @Override
    public List<MenuResource> getRestaurantMenuById(String restaurantId) {
        return null;
    }

    @Override
    public boolean deleteMenu(String menuId) {
        boolean status = true;
        try {
        	Item item = table.getItem(primaryKey, menuId);
            if(item==null) {
            	System.out.println("The menu "+menuId+" doesn't exist");
            	return status;
            }
        	MenuItemServiceImpl menuItemService = new MenuItemServiceImpl();
            menuItemService.deleteMenuItemsOfMenu(menuId);
            table.deleteItem(primaryKey, menuId);
            System.out.println("Following menu is deleted... ID: " + menuId);
        } catch (Exception e) {
            status = false;
            System.out.println("Exception occurred while deleting item from Table " + tableName + " ID: " + menuId);
            System.out.println(e.getMessage());
        }
        return status;
    }

    @Override
    public boolean deleteMenuOfRestaurant(String restaurantId) {
        boolean status = true;
        try {
            ScanSpec sp = new ScanSpec()
                    .withFilterExpression("#rs = :numid")
                    .withNameMap(new NameMap().with("#rs", "RestaurantId"))
                    .withValueMap(new ValueMap().withString(":numid", restaurantId));

            ItemCollection<ScanOutcome> items = table.scan(sp);
            for (Item item : items) {
                String menuId = (String) item.get(primaryKey);
                DeleteItemSpec deleteSpec = new DeleteItemSpec()
                        .withPrimaryKey(primaryKey, menuId)
                        .withConditionExpression("#r = :n")
                        .withNameMap(new NameMap().with("#r", "RestaurantId"))
                        .withValueMap(new ValueMap().withString(":n", restaurantId));
                MenuItemServiceImpl menuItemService = new MenuItemServiceImpl();
                menuItemService.deleteMenuItemsOfMenu(menuId);
                table.deleteItem(deleteSpec);
            }
        } catch (Exception e) {
            status = false;
            System.out.println("Exception occurred while deleting item for restaurant ID: " + restaurantId);
            System.out.println(e.getMessage());
        }

        return status;
    }

    @Override
    public boolean deleteMenuItemsOfTheMenu(String menuId) {
        MenuItemServiceImpl menuItemService = new MenuItemServiceImpl();
        return menuItemService.deleteMenuItemsOfMenu(menuId);
    }

    private Item getItem(Menu menu) {
        Item item = new Item()
                .withPrimaryKey("MenuId", menu.getMenuId())
                .withString("Category", menu.getCategory())
                .withString("NoOfItems", menu.getNoOfItems())
                .withString("RestaurantId", menu.getRestaurantId());
        return item;
    }
}
