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
  // why CarBuilder class is static because we don't need to create a new object just call the build method and thats it.
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

4. Singleton Design Pattern - ensuring only one instance for the entire system.
   lets take an example with logger functionality

   public class Logger {
     private static Logger logger;
     private Logger() {}
     public static Logger getLogger() {
      if(logger == null) {
        logger = new Logger();
      }
     return logger;
    }
     public void log(String message) {
      System.out.println("logged info : " + message);
     }
   }

   public class Application {
    public static void main(String[] args) {
      Logger logger = Logger.getLogger();
       logger.log("Application started : ");
    }
   }

// In multi threading scenarios we need to implement synchronization because there are multiple threads accessing the code
public class Logger{
  private static volatile Logger logger = null;
  private Logger() {}
  public static Logger getLogger() {
    if(logger == null) {
      synchronized(Logger.class) {
        if(logger == null) { // we don't know if there is previous thread already created the thread or not so double check
          logger = new Logger();
        }
      }
    }
    return logger;
  }

6. Prototype Design Pattern - This pattern is useful when we are creating prototypes without reling on creating new object     manually.

public class Character implements Clonable {
  private String name;
  private int health;
  private int attackPower;
  private int level;
  public Character(String name, int health, int attackPower, int level) {
    this.name = name;
    this.health = health;
    this.attackPower = attackPower;
    this.level = level;
  }

  @Override
  public Character clone() throws CloneNotSupportedException {
    return (Character) super.clone(); // Shallow copy of the character object
  }

  public void showCharacterInfo() {
    System.out.println("Character [Name=" + name + ", Health=" + health
        + ", AttackPower=" + attackPower + ", Level=" + level + "]");
  }
}

public class CloneFactory {
  private Character prototypeCharacter;
  public CharacterFactory() {
    prototypeCharacter = new Character("DefaultName", 100, 50, 1);
  }
  public Character createCharacterWithNewName(String name)
      throws CloneNotSupportedException {
    Character clonedCharacter = prototypeCharacter.clone();
    clonedCharacter = new Character(name, clonedCharacter.health, clonedCharacter.attackPower, clonedCharacter.level);
    return clonedCharacter;
  }

  public Character createCharacterWithNewLevel(int level)
      throws CloneNotSupportedException {
    Character clonedCharacter = prototypeCharacter.clone();
    clonedCharacter = new Character(clonedCharacter.name, clonedCharacter.health, clonedCharacter.attackPower, level);
    return clonedCharacter;
  }

  public Character createCharacterWithNewAttackPower(int attackPower)
      throws CloneNotSupportedException {
    Character clonedCharacter = prototypeCharacter.clone();‍ 
    clonedCharacter = new Character(clonedCharacter.name, clonedCharacter.health, attackPower, clonedCharacter.level);
    return clonedCharacter;
  }
}


BEHAVIOURAL DESIGN PATTERNS - Enhance the communication between the object.
1. Stragegy Design Pattern - strategy design pattern bascially solves the problem of which class or object to pick.
    => Example - We can see multiple payments in ecommerce website if lets say all the payments are in the same class it will be messy to manage if we suppose to add new payment types we need to add more methods which is a nightmare to manage.

Interface PaymentStrategy {
  void pay(int amount);
}

class CreditCard implements PaymentStrategy {
  public void pay(int amount) {
    System.out.println("payment of " + amount + " doint using creditCard));
  }
}

class Upi implements PaymentStrategy {
  public void pay(int amount) {
    System.out.println("payment of " + amount + " doint using upi));
  }
}

class ShoppingCart {
  private PaymentStrategy paymentStrategy;
  public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
    this.paymentStrategy = paymentStrategy;
  }
  public void checkout(int amount) {
    paymentStrategy.pay(amount);
  }
}

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.setPaymentStrategy(new CreditCardPayment());
        cart.checkout(100);
        cart.setPaymentStrategy(new PayPalPayment());
        cart.checkout(200);
    }
}
    
      
