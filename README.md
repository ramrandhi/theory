Low Level Design - 
  Design patterns - 3 types 
  1. Creational Design patterns - these are use when the we want to create an object these creational design patterns are used.
     factory, singleton, abstract factory, builder, prototype
  2. Behavioural Design patterns - 
     strategy, observer, iterator, mediator, command, state, template, chain of responsibility, visitor, memeto.
  3. Structural Design patterns -
     adapter, composite, facade, decorator, bridge, proxy, flyweight.

CREATIONAL DESIGN PATTERNS -
1. Factory Design Pattern - factory design pattern bascially deals with creating objects when there are different sub-types of objects under same object needs to be created. eg: car, bike, bus comes under same vehicle type.

public interface Vehicle {
  void start();
  void stop();
}
public class Car implements Vehicle {
  public void start() {
    System.out.println("car is starting");
  }
  public void stop() {
    System.out.println("Car is stopping");
  }
}
public class Bike implements Vehicle {
  public void start() {
    System.out.println("Bike is starting");
  }
  public void stop() {
    System.out.println("Bike is stopping");
  }
}

public class VehicleFactory {
  public static Vehicle getSuitableVehicle(String vehicleType) {
    if(vehicleType.equals("bike") {
      return new Bike();
    } else if(vehicleType.equals("car") {
      return new Car();
    } else {
      throw new IllegalArgumentException("object with type " + vehicleType + " not found");
    }
  }
}
public class Main {
  public static void main(String[] args) {
    Vehicle vehicle1 = VehicleFactory.getSuitableVehicle("car");
    vehicle1.start();
    vehicle.stop();
    Vehicle vehicle2 = VehicleFactory.getSuitableVehicle("bike");
    vehicle2.start();
    vehicle2.stop();
  }
}
====> this is bascially better way of writing the factory class so we just need to create one VehicleFactory class and if
      new vehicle sub-types are added then we can just introduce if condition on VehicleFactory class and no new changes
      elsewhere in code is required.

Abstract Factory Design Pattern - we can use this design pattern for varieties inside an type that is we are having Car type and in that we have multiple brands so to create object for each brand everytime is time consuming so we can use Abstract Factory to overcome that issue.

public interface Car {
  void start();
  void stop();
}

public class BMW implements Car {
  public void start() {
    System.out.println("BMW is starting");
  }
  public void stop() {
    System.out.println("BMW is stopping");
  }
}

public class Audi implements Car {
  public void start() {
    System.out.println("Audi is starting");
  }
  public void stop() {
    System.out.println("Audi is stopping");
  }
}

public interface CarFactory {
  Car createCar();
}

public class BMWFactory implements CarFactory {
  public Car createCar() {
    return new BMW();
  }
}

public class AudiFactory implements CarFactory {
  public Car createCar() {
    return new Audi();
  }
}

public class Main {
  public static void main(String[] args) {
    CarFactory bmwFactory = new BMWFactory();
    Car bmw = bmwFactory.createCar();
    bmw.start();
    bmw.stop();
    CarFactory audiFactory = new AudiFactory();
    Car audi = audiFactory.createCar();
    audi.start();
    audi.stop();
  }
}
===> Conclusion - 
  ○ Factory Method: Focuses on creating a single product.
  ○ Abstract Factory: Creates multiple related products.

3. Builder Design Pattern - 

      
