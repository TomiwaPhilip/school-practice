import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Car Input
        System.out.println("Enter Car details (Make, Model, Year, Doors, Fuel Type):");
        Car car = new Car(scanner.next(), scanner.next(), scanner.nextInt());
        car.setNumberOfDoors(scanner.nextInt());
        car.setFuelType(scanner.next());
        car.displayCarInfo();

        // Motorcycle Input
        System.out.println("\nEnter Motorcycle details (Make, Model, Year, Wheels, Type):");
        Motorcycle motorcycle = new Motorcycle(scanner.next(), scanner.next(), scanner.nextInt());
        motorcycle.setNumberOfWheels(scanner.nextInt());
        motorcycle.setMotorcycleType(scanner.next());
        motorcycle.displayMotorcycleInfo();

        // Truck Input
        System.out.println("\nEnter Truck details (Make, Model, Year, Capacity, Transmission):");
        Truck truck = new Truck(scanner.next(), scanner.next(), scanner.nextInt());
        truck.setCargoCapacity(scanner.nextDouble());
        truck.setTransmissionType(scanner.next());
        truck.displayTruckInfo();

        scanner.close();
    }
}
