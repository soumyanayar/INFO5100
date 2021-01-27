### User can
1. Log-in to the App
1. Select event
1. Select seats
1. Review and Make payment
1. Cancel the Ticket(s)

```
Class : User
Data : name , phone, paymentDetails , booking

Behaviours :
    loginToApp() {
        App.login(name);
    }

    selectEvent() {
        listOfEvents = App.getEvents(type, location, time);
        selectedEvent = chooseEvent(listOfEvents);
        return selectedEvent;
    }

    selectSeats() {
        listOfAvailableSeats = event.getAvailableSeats();
        selectedSeats = chooseSeats(listOfAvailableSeats);
    }

    createBooking() {
        selectedEvent = this.selectEvent();
        selectedSeats = this.selectSeats();
        this.booking = App.doBooking(username, selectedEvent, selectedSeats);
        return this.booking;
    }

    reviewBooking() {
        System.out.println(booking);
    }

    makePayament() {
        App.pay(this.paymentDetails);
    }

    cancelBooking() {
        App.cancelBooking(this.booking);
    }
```

```
Class : App
Data : listOfUsers, listOfEvents, listOfBookings
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
    
    pay(paymentDetails) {
        if (isPaymentDetailValid(paymentDetails)) {
            processPayment(paymentDetails);
            return true;
        }
        else {
            return false;
        }
    }

    getevents(type, location, time){
        events = findEvents(this.listOfEvents, type, location, time);
        return events;
    }

    doBooking(username, event, seats){
        if(event.reserve(seats)) {
            booking = new Booking(user, event, seats);
            listOfBookings.add(booking);
            return booking;
        } else {
            return null;
        }
    }

    cancelBooking(booking) {
        listOfEvents.remove(booking);
    }    
```

```
Class : Event
Data: organizer, location, timings, type, totalSeats, reservedSeats
Behaviour : 

    getAvailableSeats(){
        return totalSeats - reservedSeats;
    }

    reserve(seats){
        if((totalSeats - reservedSeats) < seats)){
            return false; 
        }
        else{
            reservedSeats = reservedSeats + seats;
            return true;
        }
    }
```

```
Class : Booking
Data: username, event, seats
```
