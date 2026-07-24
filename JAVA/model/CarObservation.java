package model;
import java.time.LocalDate;

public class CarObservation {
    private final String plateNumber;
    private final LocalDate date;
    private final CarType carType;
    private final int speed;
    private final boolean seatbeltFastened;
    public CarObservation(String plateNumber, LocalDate date, CarType carType,int speed, boolean seatbeltFastened) {
        this.plateNumber = plateNumber;
        this.date = date;
        this.carType = carType;
        this.speed = speed;
        this.seatbeltFastened = seatbeltFastened;
    }
    public String getPlateNumber() {
        return plateNumber;
    }
    public LocalDate getDate() {
        return date;
    }
    public CarType getCarType() {
        return carType;
    }
    public int getSpeed() {
        return speed;
    }
    public boolean isSeatbeltFastened() {
        return seatbeltFastened;
    }
}