package org.renuka.usc.FoodAPI.implementation;

import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import org.renuka.usc.FoodAPI.model.Restaurant;
import org.renuka.usc.FoodAPI.service.RestaurantService;
import org.renuka.usc.FoodAPI.store.DynamoDBFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestaurantServiceImpl implements RestaurantService {

    final String tableName = "Restaurant";
    final String primaryKey = "RestaurantId";
    final Table table = DynamoDBFactory.getDynamoInstance().getTable(tableName);

    public boolean addRestaurant(Restaurant restaurant) {
    	System.out.println("DB start OK restaurant");
        boolean status = true;
        try {
            System.out.println("Saving restaurant to DB" + restaurant.toString());
            table.putItem(getItem(restaurant));
        } catch (Exception e) {
            status = false;
            System.out.println("Error occurred while saving restaurant ID: " + restaurant.getRestaurantId());
            System.out.println(e.getMessage());
        }
        return status;
    }

    public Map<String, Object> getRestaurant(String restaurantId) {
        Map<String, Object> result = new HashMap<>();
        try {
            Item item = table.getItem(primaryKey, restaurantId);
            if(item==null) {
            	System.out.println("The restaurant "+restaurantId+" doesn't exist");
            	return result;
            }
            result = item.asMap();
        } catch (Exception e) {
            System.out.println("Exception while retrieving Restaurant ID " + restaurantId);
            System.out.println(e.getMessage());
        }
        return result;
    }

    public List<Map<String, AttributeValue>> getAllRestaurants() {
        ScanRequest scanRequest = new ScanRequest().withTableName(tableName);
        ScanResult result = DynamoDBFactory.getDBInstance().scan(scanRequest);
        return result.getItems();
    }

    public boolean deleteRestaurant(String id) {
        boolean status = true;
        try {
        	Item item = table.getItem(primaryKey, id);
            if(item==null) {
            	System.out.println("The restaurant "+id+" doesn't exist");
            	return status;
            }
        	deleteMenuOfRestaurant(id);
            table.deleteItem(primaryKey, id);
            System.out.println("Following restaurant is deleted... ID:" + id);
        } catch (Exception e) {
            status = false;
            System.out.println("Exception occurred while deleting item " + id);
            System.out.println(e.getMessage());
        }
        return status;
    }

    @Override
    public boolean deleteMenuOfRestaurant(String id) {
        MenuServiceImpl menuService = new MenuServiceImpl();
        return menuService.deleteMenuOfRestaurant(id);
    }

    @Override
    public boolean deleteMenuItemsOfRestaurant(String id) {
        MenuItemServiceImpl menuItemService = new MenuItemServiceImpl();
        return menuItemService.deleteMenuItemsOfRestaurant(id);
    }

    private Item getItem(Restaurant rest) {
        Item item = new Item()
                .withPrimaryKey(primaryKey, rest.getRestaurantId())
                .withString("Name", rest.getName())
                .withString("Address", rest.getAddress())
                .withString("Cuisine", rest.getCuisine())
                .withNumber("Rating", rest.getRating())
                .withString("Contact", rest.getContact())
                .withString("HrsOpen", rest.getHrsOpen())
                .withString("AvgCost", rest.getAvgCost());
        return item;
    }

}
