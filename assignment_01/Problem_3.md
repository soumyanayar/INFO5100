### Problem Statement
Design a Car Rental System.

### User can
1. Log-in To App
1. Enter the driving license details
1. Select the pick-up and return locations
1. Select the pick-up and return date & times
1. Select type of the car
1. Choose the car
1. Make payment & Book the reservation
1. Cancel the reservation.
```

Class : User

Data : username, name, phone, licenseNumber, paymentDetails, reservation

Behaviour :

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
        this.makePayment();
        this.reservation = new Reservation(this.username, 
                                           selectedCar,
                                           pickupLocation, 
                                           returnLocation, 
                                           pickupTimings, 
                                           returnTimings);
        return reservation;
    }

    reviewReservation(){
        System.out.println(this.reservation);
    }

    makePayment(){
        App.pay(this.paymentDetails);
    }

    cancelREservation(){
        App.cancelReservation(reservation);
    }
```

```
Class : Reservation

Data : username, car, pickupLocation, returnLocation, pickupTimings, returnTimings
```