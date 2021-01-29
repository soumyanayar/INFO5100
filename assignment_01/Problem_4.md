## Problem Statement: 
Design a Parking lot.

## User can
1. Log-in To App
1. Enter the vehicle License plate details
1. Enter type/size of the vehicle
1. Enter the timings of entry
1. Park the vehicle in the available free slot
1. Make payment
1. Call help desk

## Pseudocode
```
Class :  User

Data : name, phone, licensePlate, sizeOfTheVeicle, paymentDetails, entryTime, exitTime

Behaviour : 

    loginToApp(){
        App.login(name);    
    }

    enterTheLicensePlate(){
        return this.licensePlate;
    }

    enterTheSizeOfTheVehicle(){
        enterSize = selectFrom([TRUCKS, MINIVAN, FULLSIZE, COMPACT, ELECTRIC_CAR]);
        return enterSize;
    }

    enterEntryTiming(){
        return this.entryTime;
    }

    parkTheVehicle(numberOfFreeSlotsAvailable){
        selectedSlotForParking = selectFrom(App.numberOfFreeSlotsAvailable);
        return selectedSlotForParking;
    }

    enterExitTiming(){
        return this.exitTime;
    }

    makePayament(){
        App.pay(this.paymentDetails);
    }

    callHelpDesk(){
        callService = App.contactforAssistance();
        return  callService;
    }
```

```
Class : Parking
Data : totalNumberOfSlots, numberOfOccupiedSlots

```

```
Class : App

Data :  listOfUsers, pay, totalNumberOfSlots, numberOfOccupiedSlots, parkingAdmins

Behaviour : 
    login(userName, password){
        isLoggedIn = checkAuthentication(userName, password);
        return isLoggedIn;
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

    totalFreeSlotsAvailable(){
        numberOfFreeSlotsAvailable = totalNumberOfSlots - numberOfOccupiedSlots ; 
        return numberOfFreeSlotsAvailable;
    }

    contactForAssistance(parkingAdmins){
        callForHelp = selectFrom(parkingAdmins);
        return callForHelp;
    }

```

 

