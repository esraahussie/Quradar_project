from rules.rule import Rule
from model.violation import Violation

class SeatbeltRule(Rule):
    def __init__(self, fee):
        self.fee = fee

    def evaluate(self, observation):
        if not observation.is_seatbelt_fastened():
            return Violation("Seatbelt not fastned", self.fee)
        return None