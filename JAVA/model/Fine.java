package model;
import java.util.Collections;
import java.util.List;

public class Fine {
    private final String plateNumber;
    private final List<Violation> violations;
    public Fine(String plateNumber, List<Violation> violations) {
        this.plateNumber = plateNumber;
        this.violations = Collections.unmodifiableList(violations);
    }
    public String getPlateNumber() {
        return plateNumber;
    }
    public List<Violation> getViolations() {
        return violations;
    }
    public double getTotalAmount() {
        double total = 0;
        for (int i = 0; i < violations.size(); i++) {
            Violation v = violations.get(i);
            total += v.getFee();
        }
        return total;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Traffic for car ").append(plateNumber).append("\n");
        sb.append("Total amount: ").append((int) getTotalAmount()).append(" EGP\n");
        sb.append("Violations:");
        for (int i = 0; i < violations.size(); i++) {
            Violation v = violations.get(i);
            sb.append("\n- ").append(v.getDescription()).append(" : ").append((int) v.getFee()).append(" EGP");
        }
        return sb.toString();
    }
}