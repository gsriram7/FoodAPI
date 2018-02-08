# FoodAPI

## Restaurant Endpoints

### To list all restaurants (GET)
`http://localhost:8000/Restaurant`

### To get information about a restaurant with ID 1 (GET)
`http://localhost:8000/Restaurant/1`

### To add a new restaurant with ID 6 (POST)
`curl -vX POST http://localhost:8000/Restaurant/ -d @(data/restaurants/restaurant6.json) \ --header "Content-Type: application/json"`

### To delete a restaurant with ID 1 (DELETE)
`http://localhost:8000/Restaurant/delete/1`

### To delete a menu (breakfast) of ID 11 from restaurant of ID 1:
`http://localhost:8000/Restaurant/delete/menu/1`

### To delete a menu items (pizza) of ID 111 from restaurant of ID 1:
`http://localhost:8000/Restaurant/delete/menuitems/111`

## Menu Endpoints

### To list all menu (GET)
`http://localhost:8000/menu`

### To get information about a menu with ID 1 (GET)
`http://localhost:8000/menu/1`

### To add a new menu with ID 31 (POST)
`curl -vX POST http://localhost:8000/menu -d @(data/menu/menu31.json) \ --header "Content-Type: application/json"`

### To delete a menu with ID 11 (DELETE)
`http://localhost:8000/menu/delete/1`

### To delete a menu items of the menu(breakfast) of ID 11:
`http://localhost:8000/menu/delete/menu/1`

### To delete a menus of restaurant of ID 1:
`http://localhost:8000/menu/delete/menuitems/1`

## Menu Items Endpoints

### To list all menu item (GET)
`http://localhost:8000/menuitem`

### To get information about a menu with ID 1 (GET)
`http://localhost:8000/menuitem/1`

### To add a new menu item with ID 211 (POST)
`curl -vX POST http://localhost:8000/menuitem -d @(data/menuitems/menuitem211.json) \ --header "Content-Type: application/json"`

### To delete a menu with ID 111 (DELETE)
`http://localhost:8000/menuitem/delete/111`