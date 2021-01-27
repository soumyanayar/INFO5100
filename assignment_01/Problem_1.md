
### User can
1. Log-in to the app
1. Select from the menu
1. Select Pickup/Deliery
1. Select Timings
1. Review and Make Payment
1. Check the status of the order
1. Contact Restaurant/Delivery Person
1. Cancel the order

```
Class : User
Data : name , userLocation , phone, paymentDetails, order
Behaviour : 
    loginToApp(){
        App.login(name);    
    }

    findDominosLocation(){
        restaurantLocation = App.findNearestRestaurant(userLocation); 
        return restaurantLocation;
    }

    selectItems(){
        menu = Restauarant.getMenu();
        seletedItems = pickItems(menu);
        return selectedItems;
    }

    selectOrderType(){
        orderType = selectFrom([DELIVERY, PICKUP]);
        return orderType;
    }

    selectOrderTimings(){
        orderTimings = selectFrom(Restaurant.getOrderSlots());
        return orderTimings;
    }

    createOrder(){
        items = this.selectItems();
        orderType = this.selectOrderType();
        orderTimings = this.selectOrderTimings();
        order = new Order(items, orderType, orderTimings);
        this.makePayment();
        return order;
    }

    reviewOrder(){
        System.out.println(order);
    }

    makePayament(){
        App.pay(this.paymentDetails);
    }

    checkTheStatusOfTheOrder(){
        orderStatus = Restaurant.getOrderStatus(this.order);
    }

    contactRestaurant(){
        App.makeContact(Restaurant);
    }

    cancelOrder(){
        App.cancelOrder(order);
    }
```

```
Class : Restaurant
Data : name , location , menu , contactDetails, ordersList, availableSlots

Behaviour : 
    confirmOrder(user, order){
        order.status = confirmed;
        ordersList.add({order, user});
    }

    prepareOrder(order) {
        food = cook(order);
        return food;
    }

    processOrder(order, user) {
        food = this.preareOrder(order);
        orderType = order.getType();
        if (orderType == "DELIVERY") {
            App.sendToDelivery(food, user.Location)
        }
        else if (orderType == "PICKUP") {
            keepFoodReadyForPickup(food, user);
        }
    }

    getMenu() {
        return this.menu;
    }

    getOrderSlots() {
        return this.availableSlots;
    }

    getOrderStatus(order) {
        return order.status;
    }

    getContact() {
        return this.contactDetails;
    }    

    cancelOrder(order){
        ordersList.remove(order);
    }
```

```
Class : App
Data : listOfUsers , listOfRestaurants, listOfDeliveryAgents

Behaviour :
    login(userName, password){
        isLoggedIn = checkAuthentication(userName, password);
        return isLoggedIn;
    }

    checkAuthentication(userName, password) {
        user = findUser(this.listOfUsers);
        if (user.password == password) {
            return true;
        }
        else {
            return false;
        }
    }

    findNearestRestaurant(userLocation) {
        locations = getListOfLocations(this.listOfRestaurants);
        nearestLocation = findNearestLocation(locations, userLocation);
        nearestRestaurant = findRestaurantByLocation(nearestLocation);
        return nearestRestaurant;
    }

    pay(paymentDetails) {
        if (isPaymentDetailValid(paymentDetails)) {
            processPayment(paymentDetails);
            return true;
        }
        else {
            return false;
        }
    }

    sendToDelivery(food, userLocation) {
        deliveryPerson = findNextAvailableDeliveryAgent(listOfDeliveryAgents);
        sendDelivery(deliveryPerson, food, userLocation);
    }

    makeContact(restaurant) {
        restaurantContactDetails = restuarant.getContact();
        makeCall(restaurantContactDetails);
    }

    cancelOrder(order) {
        Restaurant.cancelOrder(order);
    }
```

