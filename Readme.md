# FoodAPI

1.	This is a JAX RS maven project created using GlassFish jersey-quickstart-webapp archetype and run on Apache Tomcat server in Eclipse IDE.
2. DB layer is DynamoDB local running in localhost. port no 8001.
3. The required dependencies (Jersey, JSON support in Jersey, AWS DynamoDb local) are added in pom.xml. 
4. The DB server can be started using AWS toolkit from eclipse or through CLI by executing the downloadable version of DynamoDB local jar. The endpoint and region are given while instantiating the client in java.
	command: java -Djava.library.path=./DynamoDBLocal_lib -jar DynamoDBLocal.jar -port 8001 -sharedDb — DynamoDB Local
	note: -sharedDb — DynamoDB Local will use a single database file, instead of using separate files for each credential and region
	DynamoDB Local clients will interact with the same set of tables regardless of their region and credential configuration
5.  Once the Db server is up and running, tables are created and data is inserted through DynamoDB JavaScript Console in http://localhost:8001/shell/. The scripts are saved under FoodAPI/data.
## Restaurant Endpoints

### To list all restaurants (GET)
`http://localhost:8080/FoodAPI/webapi/Restaurant`

### To get information about a restaurant with ID 1 (GET)
`http://localhost:8080/FoodAPI/webapi/Restaurant/1`

### To add a new restaurant with ID 6 (POST)
`curl -vX POST http://localhost:8080/FoodAPI/webapi/Restaurant/ -d @(data/restaurants/restaurant6.json) \ --header "Content-Type: application/json"`

### To delete a restaurant with ID 1 (DELETE)
`http://localhost:8080/FoodAPI/webapi/Restaurant/delete/1`

### To delete a menu (breakfast) of ID 11 from restaurant of ID 1:
`http://localhost:8080/FoodAPI/webapi/Restaurant/delete/menu/1`

### To delete a menu items (pizza) of ID 111 from restaurant of ID 1:
`http://localhost:8080/FoodAPI/webapi/Restaurant/delete/menuitems/111`

## Menu Endpoints

### To list all menu (GET)
`http://localhost:8080/FoodAPI/webapi/menu`

### To get information about a menu with ID 1 (GET)
`http://localhost:8080/FoodAPI/webapi/menu/1`

### To add a new menu with ID 31 (POST)
`curl -vX POST http://localhost:8080/FoodAPI/webapi/menu -d @(data/menu/menu31.json) \ --header "Content-Type: application/json"`

### To delete a menu with ID 11 (DELETE)
`http://localhost:8080/FoodAPI/webapi/menu/delete/1`

### To delete a menu items of the menu(breakfast) of ID 11:
`http://localhost:8080/FoodAPI/webapi/menu/delete/menu/1`

### To delete a menus of restaurant of ID 1:
`http://localhost:8080/FoodAPI/webapi/menu/delete/menuitems/1`

## Menu Items Endpoints

### To list all menu item (GET)
`http://localhost:8080/FoodAPI/webapi/menuitem`

### To get information about a menu with ID 1 (GET)
`http://localhost:8080/FoodAPI/webapi/menuitem/1`

### To add a new menu item with ID 211 (POST)
`curl -vX POST http://localhost:8080/FoodAPI/webapi/menuitem -d @(data/menuitems/menuitem211.json) \ --header "Content-Type: application/json"`

### To delete a menu with ID 111 (DELETE)
`http://localhost:8080/FoodAPI/webapi/menuitem/delete/111`