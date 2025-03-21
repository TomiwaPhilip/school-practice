public class Truck implements Vehicle, TruckVehicle {
    private String make;
    private String model;
    private int year;
    private double cargoCapacity;
    private String transmissionType;

    public Truck(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    @Override
    public String getMake() {
        return make;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public int getYear() {
        return year;
    }

    @Override
    public void setCargoCapacity(double capacity) {
        this.cargoCapacity = capacity;
    }

    @Override
    public double getCargoCapacity() {
        return cargoCapacity;
    }

    @Override
    public void setTransmissionType(String transmission) {
        this.transmissionType = transmission;
    }

    @Override
    public String getTransmissionType() {
        return transmissionType;
    }

    public void displayTruckInfo() {
        System.out.println("Truck: " + year + " " + make + " " + model);
        System.out.println("Cargo Capacity: " + cargoCapacity + " tons");
        System.out.println("Transmission: " + transmissionType);
    }
}
