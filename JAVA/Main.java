import core.QuRadar;
import model.CarObservation;
import model.CarType;
import model.Fine;
import rules.Rule;
import rules.SeatbeltRule;
import rules.SpeedRule;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<CarType, Integer> maxSpeeds = new HashMap<>();
        maxSpeeds.put(CarType.TRUCK, 60);
        maxSpeeds.put(CarType.PRIVATE, 80);
        List<Rule> rules = List.of(
            new SeatbeltRule(100),
            new SpeedRule(maxSpeeds, 300)
        );
        QuRadar radar = new QuRadar(rules);
        CarObservation obs1 = new CarObservation("ABC1234", LocalDate.now(), CarType.PRIVATE, 94, false);
        CarObservation obs2 = new CarObservation("TRK5566", LocalDate.now(), CarType.TRUCK, 55, true);
        for (CarObservation obs : List.of(obs1, obs2)) {
            Fine fine = radar.processObservation(obs);
            if (fine != null) {
                System.out.println(fine);
                System.out.println();
            }
        }
        System.out.println("== All fines (plate -> total) ==");
        radar.getAllPossibleFines().forEach((plate, total) ->System.out.println(plate + " -> " + total.intValue() + " EGP"));
        System.out.println();
        System.out.println("== Violated rules count ==");
        radar.getAllViolatedRules().forEach((rule, count) ->System.out.println(rule + " -> " + count));
    }
}