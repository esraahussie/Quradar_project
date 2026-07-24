from rules.rule import Rule
from model.violation import Violation

class SpeedRule(Rule):
    def __init__(self, max_speed_by_car_type, fee):
        self.max_speed_by_car_type = max_speed_by_car_type
        self.fee = fee

    def evaluate(self, observation):
        max_speed = self.max_speed_by_car_type.get(observation.get_car_type())
        if max_speed is not None and observation.get_speed() > max_speed:
            description = "speed of " + str(observation.get_speed()) + " exceeded max allowed " + str(max_speed)
            return Violation(description, self.fee)
        return None