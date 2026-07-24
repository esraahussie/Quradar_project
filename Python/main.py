from datetime import date
from model.car_type import CarType
from model.car_observation import CarObservation
from rules.speed_rule import SpeedRule
from rules.seatbelt_rule import SeatbeltRule
from core.quradar import QuRadar

def main():
    max_speeds = {
        CarType.TRUCK: 60,
        CarType.PRIVATE: 80
    }
    rules = [
        SeatbeltRule(100),
        SpeedRule(max_speeds, 300)
    ]
    radar = QuRadar(rules)
    obs1 = CarObservation("ABC1234", date.today(), CarType.PRIVATE, 94, False)
    obs2 = CarObservation("TRK5566", date.today(), CarType.TRUCK, 55, True)
    observations = [obs1, obs2]
    for i in range(len(observations)):
        obs = observations[i]
        fine = radar.process_observation(obs)
        if fine is not None:
            print(fine)
            print()

    print("== All fines (plate -> total) ==")
    fines = radar.get_all_possible_fines()
    for plate in fines:
        print(plate + " -> " + str(int(fines[plate])) + " EGP")

    print()
    print("== Violated rules count ==")
    counts = radar.get_all_violated_rules()
    for description in counts:
        print(description + " -> " + str(counts[description]))


if __name__ == "__main__":
    main()