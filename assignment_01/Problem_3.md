## Problem Statement: 
Design a Car Rental System.

## User can
1. Log-in To App
1. Enter the driving license details
1. Select the pick-up and return locations
1. Select the pick-up and return date & times
1. Select type of the car
1. Choose the car
1. Make payment & Book the reservation
1. Cancel the reservation.

## Pseudocode
```
Class : User

Data : username, name, phone, licenseNumber, paymentDetails, reservation

Behavior :

    loginToApp() {
        App.login(name);    
    }

    getDrivingLicenseInfo() {
        return this.licenseNumber;
    }

    selectTheTypeOfTheCar() {
        carType = selectFrom(App.getCarTypes());
        return carType;
    }

    selectpickUpLocation() {
        pickupLocation = selectFrom(App.getPickupLocations());
        return pickupLocation;
    }

    selectReturnLocation() {
        returnLocation = selectFrom(App.getReturnLocations());
        return returnLocation;
    }

    selectPickupTimings() {
        pickupTimings = selectFrom(App.getPickupTiminings());
        return pickupTimings;
    }

    selectReturnTimings() {
        returnTimings = selectFrom(App.getReturnTimings());
        return returnTimings;
    }

    bookReservation() {
        pickupLocation = this.selectpickUpLocation();
        returnLocation = this.selectReturnLocation();
        pickupTimings = this.selectPickupTimings();
        returnTimings = this.selectReturnTimings();
        carType = selectTheTypeOfTheCar();
        cars = App.findCars(pickupLocation, 
                            returnLocation, 
                            pickupTimings, 
                            returnTimings, 
                            carType);
        selectedCar = selectFrom(cars);
        this.reservation = App.makeReservation(
                    this,
                    selectedCar, 
                    pickupLocation, 
                    returnLocation, 
                    pickupTimings, 
                    returnTimings);
        this.makePayment();
        return reservation;
    }

    reviewReservation(){
        System.out.println(this.reservation);
    }

    makePayment(){
        App.pay(this.paymentDetails);
    }

    cancelReservation(){
        App.cancelReservation(user, reservation);
    }
```

```
Class : App
Data : listOfCarRentals, listOfReservations
Behavior : 
    login(userName, password){
        isLoggedIn = checkAuthentication(userName, password);
        return isLoggedIn;
    }

    getCarTypes(carRental) {
        return carRental.listOfCarTypes;
    }

    getPickupLocations() {
        pickupLocations = extractLocations(listOfCarRentals);
        return pickupLocations;
    }

    getReturnLocations() {
        returnLocations = extractLocations(listOfCarRentals);
        return returnLocations;
    }

    getPickupTiminings() {
        pickupTimings = extractPickupTimings(listOfCarRentals);
        return pickupTimings;
    }

    getReturnTimings() {
        returnTimings = extractReturnTimings(listOfCarRentals);
        return returnTimings;
    }

    findCars(pickupLocation, 
            returnLocation, 
            pickupTimings, 
            returnTimings, 
            carType) {
        return filterBy(listOfCarRentals, 
                        pickupLocation, 
                        returnLocation, 
                        pickupTimings, 
                        returnTimings, 
                        carType)
    }

    makeReservation(user,
                    selectedCar, 
                    pickupLocation, 
                    returnLocation, 
                    pickupTimings, 
                    returnTimings) {
        reservation = new Reservation(
        user.username, 
        selectedCar, 
        pickupLocation, 
        returnLocation, 
        pickupTimings, 
        returnTimings);

        listOfReservations.add(reservation);
        return reservation;
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
    
    cancelReservation(user, reservation) {
        listOfReservations.remove(reservation);
        processRefund(user.paymentDetails, reservation);
    }

    registerCarRental(carRental) {
        listOfCarRentals.add(carRental);
    }
```

```
Class : Reservation

Data : username, car, pickupLocation, returnLocation, pickupTimings, returnTimings
```

```
Class : CarRentals

Data: listOfCarTypes, address, DictionaryOfCarTypeToNumberOfCarsAvailable, DictionaryOfCarTypeToPrice, startTime, endTime

Behavior:
    registerToCarRentalApp() {
        App.registerCarRental(this);
    }
```