package model;

public class Violation {
    private final String description;
    private final double fee;
    public Violation(String description, double fee) {
        this.description = description;
        this.fee = fee;
    }
    public String getDescription() {
        return description;
    }
    public double getFee() {
        return fee;
    }
}