package org.renuka.usc.FoodAPI.implementation;

import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazonaws.services.dynamodbv2.document.ScanOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.DeleteItemSpec;
import com.amazonaws.services.dynamodbv2.document.spec.ScanSpec;
import com.amazonaws.services.dynamodbv2.document.utils.NameMap;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import org.renuka.usc.FoodAPI.model.MenuItem;
import org.renuka.usc.FoodAPI.resources.MenuItemResource;
import org.renuka.usc.FoodAPI.service.MenuItemService;
import org.renuka.usc.FoodAPI.store.DynamoDBFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuItemServiceImpl implements MenuItemService {

    final private String tableName = "MenuItem";
    final private String primaryKey = "MenuItemId";
    final Table table = DynamoDBFactory.getDynamoInstance().getTable(tableName);

    @Override
    public boolean addMenuItem(MenuItem menuItem) {
        boolean status = true;
        try {
            System.out.println("Saving menu item to DB" + menuItem.toString());
            table.putItem(getItem(menuItem));
        } catch (Exception e) {
            status = false;
            System.out.println("Error occurred while saving menu item ID: " + menuItem.getMenuItemId());
            System.out.println(e.getMessage());
        }
        return status;
    }

    @Override
    public Map<String, Object> getMenuItemById(String menuItemId) {
    	System.out.println("DB call OK");
        Map<String, Object> result = new HashMap<>();
        try {
            Item item = table.getItem(primaryKey, menuItemId);
            if(item==null) {
            	System.out.println("The menuitem "+menuItemId+" doesn't exist");
            	return result;
            }
            result = item.asMap();
        } catch (Exception e) {
            System.out.println("Exception while retrieving Menu Item ID " + menuItemId);
            System.out.println(e.getMessage());
        }

        return result;
    }

    @Override
    public List<Map<String, AttributeValue>> getAllMenuItems() {
        ScanRequest scanRequest = new ScanRequest().withTableName(tableName);
        ScanResult result = DynamoDBFactory.getDBInstance().scan(scanRequest);
        return result.getItems();
    }

    @Override
    public List<MenuItemResource> getMenuItemsByMenuId(String restaurantId) {
        return null;
    }

    @Override
    public List<MenuItemResource> getMenuItemsByRestaurantId(String restaurantId) {
        return null;
    }

    @Override
    public boolean deleteMenuItem(String menuItemId) {
        boolean status = true;
        try {
            table.deleteItem(primaryKey, menuItemId);
            System.out.println("Following menu item is deleted... ID: " + menuItemId);
        } catch (Exception e) {
            status = false;
            System.out.println("Exception occurred while deleting item from Table " + tableName + " ID: " + menuItemId);
            System.out.println(e.getMessage());
        }
        return status;
    }

    @Override
    public boolean deleteMenuItemsOfMenu(String menuId) {
        boolean status = true;
        try {
            ScanSpec sp = new ScanSpec()
                    .withFilterExpression("#rs = :numid")
                    .withNameMap(new NameMap().with("#rs", "MenuId"))
                    .withValueMap(new ValueMap().withString(":numid", menuId));

            ItemCollection<ScanOutcome> items = table.scan(sp);
            for (Item item : items) {
                String menuItemId = (String) item.get(primaryKey);
                DeleteItemSpec deleteSpec = new DeleteItemSpec()
                        .withPrimaryKey(primaryKey, menuItemId)
                        .withConditionExpression("#r = :n")
                        .withNameMap(new NameMap().with("#r", "MenuId"))
                        .withValueMap(new ValueMap().withString(":n", menuId));
                table.deleteItem(deleteSpec);
            }
        } catch (Exception e) {
            status = false;
            System.out.println("Exception occurred while deleting item for restaurant ID: " + menuId);
            System.out.println(e.getMessage());
        }

        return status;

    }

    @Override
    public boolean deleteMenuItemsOfRestaurant(String restaurantId) {
        boolean status = true;
        try {
            ScanSpec sp = new ScanSpec()
                    .withFilterExpression("#rs = :numid")
                    .withNameMap(new NameMap().with("#rs", "RestaurantId"))
                    .withValueMap(new ValueMap().withString(":numid", restaurantId));

            ItemCollection<ScanOutcome> items = table.scan(sp);
            for (Item item : items) {
                String menuItemId = (String) item.get(primaryKey);
                DeleteItemSpec deleteSpec = new DeleteItemSpec()
                        .withPrimaryKey(primaryKey, menuItemId)
                        .withConditionExpression("#r = :n")
                        .withNameMap(new NameMap().with("#r", "RestaurantId"))
                        .withValueMap(new ValueMap().withString(":n", restaurantId));
                table.deleteItem(deleteSpec);
            }
        } catch (Exception e) {
            status = false;
            System.out.println("Exception occurred while deleting item for restaurant ID: " + restaurantId);
            System.out.println(e.getMessage());
        }

        return status;
    }

    private Item getItem(MenuItem menu) {
        Item item = new Item()
                .withPrimaryKey("MenuItemId", menu.getMenuItemId())
                .withString("Name", menu.getName())
                .withString("Description", menu.getDescription())
                .withString("IsVeg", menu.getIsVeg())
                .withNumber("Price", menu.getPrice())
                .withString("MenuId", menu.getMenuId())
                .withString("RestaurantId", menu.getRestaurantId());
        return item;
    }
}
