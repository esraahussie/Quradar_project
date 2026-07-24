package core;
import model.CarObservation;
import model.Fine;
import model.Violation;
import rules.Rule;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class QuRadar {
    private final List<Rule> rules;
    private final List<Fine> issuedFines = new ArrayList<>();
    public QuRadar(List<Rule> rules) {
        this.rules = new ArrayList<>(rules);
    }
    public Fine processObservation(CarObservation observation) {
        List<Violation> violations = new ArrayList<>();
        for (int i = 0; i < rules.size(); i++) {
            Rule rule = rules.get(i);
            Optional<Violation> result = rule.evaluate(observation);
            if (result.isPresent()) {
                violations.add(result.get());
            }
        }
        if (violations.isEmpty()) {
            return null;
        }
        Fine fine = new Fine(observation.getPlateNumber(), violations);
        issuedFines.add(fine);
        return fine;
    }

    public Map<String, Double> getAllPossibleFines() {
        Map<String, Double> totalsByPlate = new LinkedHashMap<>();
        for (int i = 0; i < issuedFines.size(); i++) {
            Fine fine = issuedFines.get(i);
            String plate = fine.getPlateNumber();
            double amount = fine.getTotalAmount();
            if (totalsByPlate.containsKey(plate)) {
                double oldTotal = totalsByPlate.get(plate);
                totalsByPlate.put(plate, oldTotal + amount);
            }
            else {
                totalsByPlate.put(plate, amount);
            }
        }
        return totalsByPlate;
    }

    public Map<String, Integer> getAllViolatedRules() {
        Map<String, Integer> counts = new LinkedHashMap<>();
        for (int i = 0; i < issuedFines.size(); i++) {
            Fine fine = issuedFines.get(i);
            List<Violation> violations = fine.getViolations();
            for (int j = 0; j < violations.size(); j++) {
                Violation violation = violations.get(j);
                String description = violation.getDescription();
                if (counts.containsKey(description)) {
                    int oldCount = counts.get(description);
                    counts.put(description, oldCount + 1);
                }
                else {
                    counts.put(description, 1);
                }
            }
        }
        return counts;
    }
}