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

3. Builder Design Pattern - This pattern usually solves the problem of multiple constructors when there are multiple constructors when there are optional parameters so we use builder pattern to solve that issue by having inner class with default fields.

lets take an example of car with specific features - 
public class Car {
  private String engine;
  private int wheels;
  private int seats;
  private String color;
  private boolean sunroof;
  private boolean navigationSystem;

  private Car(CarBuilder builder) {
    this.engine = builder.engine;
    this.wheels = builder.wheels;
    this.seats = builder.seats;
    this.color = builder.color;
    this.sunroof = builder.sunroof;
    this.navigationSystem = builder.navigationSystem;
  }

  public String getEngine() {
    return engine;
  }
  public int getWheels() {
    return wheels;
  }
  public int getSeats() {
    return seats;
  }
  public String getColor() {
    return color;
  }
  public boolean hasSunroof() {
    return sunroof;
  }
  public boolean hasNavigationSystem() {
    return navigationSystem;
  }

  @Override
  public String toString() {
     return "Car [engine=" + engine + ", wheels=" + wheels + ", seats=" + seats
        + ", color=" + color + ", sunroof=" + sunroof
        + ", navigationSystem=" + navigationSystem + "]";
  }
  public static class CarBuilder {
    private String engine;
    private int wheels = 4; // Default value
    private int seats = 5; // Default value
    private String color = "Black"; // Default value
    private boolean sunroof = false; // Default value
    private boolean navigationSystem = false; // Default value

    public CarBuilder setEngine(String engine) {
      this.engine = engine;
      return this;
    }
    public CarBuilder setWheels(int wheels) {
      this.wheels = wheels;
      return this;
    }
    public CarBuilder setSeats(int seats) {
      this.seats = seats;
      return this;
    }
    public CarBuilder setColor(String color) {
      this.color = color;
      return this;
    }
    public CarBuilder setSunroof(boolean sunroof) {
      this.sunroof = sunroof;
      return this;
    }
    public CarBuilder setNavigationSystem(boolean navigationSystem) {
      this.navigationSystem = navigationSystem;
      return this;
    }
    public Car build() {
      return new Car(this);
    }
  }
}

public class Main {
  public static void main(String[] args) {
    // Creating a car using the Builder pattern
    Car.CarBuilder builder = new Car.CarBuilder();
    Car car1 = builder.setEngine("V8")
                   .setColor("Red")
                   .setSeats(5)
                   .setSunroof(true)
                   .build(); // The build method returns the final product
    System.out.println(car1);

    // Creating another car with different specifications
    Car car2 = builder.setEngine("V6")
                   .setColor("Blue")
                   .setSeats(4)
                   .build(); // Sunroof and Navigation are default
    System.out.println(car2);
  }
}
    
      
