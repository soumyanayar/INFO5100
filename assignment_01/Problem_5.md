## Problem Statement: 
Design a Traffic Controller System for a Junction.

## Assumptions
1. Traffic light needs to be green to go from south to west, south to north, north to east, north to south, east to south, east to west, west to north and west to east directions.
1. There are free right turns
1. Red means stop, yellow means caution and gree means 'go';
1. light gets 30 seconds.
1. The turns happen in round robin fashion.

## Pseudocode
```
Class: TrafficController

Behaviour: 
    controlSignal() {
        trafficLight_list = [ southToWestTrafficLight, southToNorthTrafficLight, northToEastTrafficLight, northToSouthTrafficLight, eastToSouthTrafficLight, eastToWestTrafficLight, westToNorthTrafficLight, westToEastTrafficLight ];
        AtInterval(30) {
            trafficLight = chooseInRoundRobinFashion(trafficLight_list);
            trafficLight.turnYellow();
            trafficLight.turnGreen();
            otherTrafficLights = trafficLight_list - otherTrafficLights;
            for(trafficlights in otherTrafficLights) {
                trafficlights.turnRed();
            }
        }
    }
```

```
Class: TrafficLight  

Data: state (red, yellow, green)
```